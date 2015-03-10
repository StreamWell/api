/**
 * 
 */
package org.demo.poc.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.demo.poc.common.JsonFieldTypeVal;
import org.demo.poc.common.ResponseBean;
import org.demo.poc.common.ResponseBeanWrapper;
import org.demo.poc.common.ResponseWrapper;
import org.demo.poc.doc.price.PriceDocumentFields;

import com.shc.ift.greenbox.common.v2.doc.common.Blob;
import com.shc.ift.greenbox.common.v2.doc.common.Meta;
import com.shc.ift.greenbox.common.v2.doc.offer.Dimensions;
import com.shc.ift.greenbox.common.v2.doc.offer.Expedited;
import com.shc.ift.greenbox.common.v2.doc.offer.Free;
import com.shc.ift.greenbox.common.v2.doc.offer.FreeShip;
import com.shc.ift.greenbox.common.v2.doc.offer.FreeShipSiteInfo;
import com.shc.ift.greenbox.common.v2.doc.offer.FreeShipSites;
import com.shc.ift.greenbox.common.v2.doc.offer.Ground;
import com.shc.ift.greenbox.common.v2.doc.offer.MaxQntyPurchasable;
import com.shc.ift.greenbox.common.v2.doc.offer.ModeInfo;
import com.shc.ift.greenbox.common.v2.doc.offer.Premium;
import com.shc.ift.greenbox.common.v2.doc.offer.SYWRFreeDelivery;
import com.shc.ift.greenbox.common.v2.doc.offer.Shipping;
import com.shc.ift.greenbox.common.v2.doc.offer.SiteVal;
import com.shc.ift.greenbox.common.v2.doc.offer.SitesForMaxQnty;
import com.shc.ift.greenbox.common.v2.doc.price.Price;

/**
 * @author pbhave
 *
 */
public class PriceDao {

    private static final Logger LOG = Logger.getLogger(PriceDao.class.getSimpleName());

    private String convertEpochToDateTime(Long epochTime) {

        Date date = new Date(epochTime);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public List<ResponseBeanWrapper> getPriceList(List<ResponseBeanWrapper> priceList, ResponseWrapper[] priceWrapper) {

        List<ResponseBeanWrapper> priceListWrapper = new ArrayList<>();

        ResponseBeanWrapper priceBeanWrapper = new ResponseBeanWrapper();

        for (ResponseWrapper price : priceWrapper) {

            Blob blob = price.get_blob();
            Price priceItem = blob.getPrice();

            if (priceItem != null) {
                priceBeanWrapper = this.setFlatPrice(price, priceItem);
            }

            priceListWrapper.add(priceBeanWrapper);
        }

        return priceListWrapper;
    }

    private ResponseBean setPriceBeanAttr(Object value, String jsonPath, Class<?> type) {

        return new ResponseBean().setValue(value).setPath(jsonPath).setType(type);
    }

    private ResponseBeanWrapper setFlatPrice(ResponseWrapper price, Price priceItem) {

        ResponseBeanWrapper priceBeanWrapper = new ResponseBeanWrapper();
        ResponseBean priceBean = new ResponseBean();
        List<ResponseBean> priceList = new ArrayList<>();

        priceBean = setPriceBeanAttr(price.get_bucket(), PriceDocumentFields.BUCKET.getPath(), JsonFieldTypeVal.STRING.getClazz());
        priceList.add(priceBean);

        priceBean = setPriceBeanAttr(convertEpochToDateTime(price.get_tmstmp()), PriceDocumentFields.TIMESTAMP.getPath(), JsonFieldTypeVal.STRING
                .getClazz());
        priceList.add(priceBean);

        priceBean = setPriceBeanAttr(priceItem.getId(), PriceDocumentFields.ID.getPath(), JsonFieldTypeVal.STRING.getClazz());
        priceList.add(priceBean);

        priceBean = setPriceBeanAttr(priceItem.getRegPrice(), PriceDocumentFields.REGPRICE.getPath(), JsonFieldTypeVal.DOUBLE
                .getClazz());
        priceList.add(priceBean);

        priceBean = this
                .setPriceBeanAttr(priceItem.getRegPriceSrc(), PriceDocumentFields.REGPRICESRC.getPath(), JsonFieldTypeVal.STRING
                        .getClazz());
        priceList.add(priceBean);

        priceBean = this
                .setPriceBeanAttr(priceItem.getProgramType(), PriceDocumentFields.PROGRAMTYPE.getPath(), JsonFieldTypeVal.STRING
                        .getClazz());
        priceList.add(priceBean);

        priceBean = this
                .setPriceBeanAttr(priceItem.getPromotext(), PriceDocumentFields.PROMOTEXT.getPath(), JsonFieldTypeVal.STRING
                        .getClazz());
        priceList.add(priceBean);

        priceBean = this
                .setPriceBeanAttr(priceItem.getCost(), PriceDocumentFields.COST.getPath(), JsonFieldTypeVal.DOUBLE
                        .getClazz());
        priceList.add(priceBean);

        priceBean = this
                .setPriceBeanAttr(priceItem.getMapVal(), PriceDocumentFields.MAPVAL.getPath(), JsonFieldTypeVal.STRING
                        .getClazz());
        priceList.add(priceBean);

        if (priceItem.getMeta() != null) {
            Meta meta = priceItem.getMeta();

            priceBean = this
                    .setPriceBeanAttr(meta.getCreatedTs(), PriceDocumentFields.CREATEDTS.getPath(), JsonFieldTypeVal.STRING
                            .getClazz());
            priceList.add(priceBean);

            priceBean = this
                    .setPriceBeanAttr(meta.getModifiedTs(), PriceDocumentFields.MODIFIEDTS.getPath(), JsonFieldTypeVal.STRING
                            .getClazz());
            priceList.add(priceBean);

            priceBean = this
                    .setPriceBeanAttr(meta.getLastModifiedBy(), PriceDocumentFields.LASTMODIFIEDBY.getPath(), JsonFieldTypeVal.STRING
                            .getClazz());
            priceList.add(priceBean);

        }

        if (priceItem.getShipping() != null) {

            Shipping shipping = priceItem.getShipping();

            if (shipping.getMinRate() != null) {
                priceBean = this
                        .setPriceBeanAttr(shipping.getMinRate(), PriceDocumentFields.SHIPMINRATE.getPath(), JsonFieldTypeVal.DOUBLE
                                .getClazz());
                priceList.add(priceBean);
            }

            if (shipping.getIsShipAlone() != null) {
                priceBean = this
                        .setPriceBeanAttr(shipping.getIsShipAlone(), PriceDocumentFields.SHIPALONE.getPath(), JsonFieldTypeVal.BOOLEAN
                                .getClazz());
                priceList.add(priceBean);
            }

            // if (shipping.getIsCENotExists() != null) {
            // flattenedPriceBean.setCENotExists(shipping.getIsCENotExists());
            // }

            if (shipping.getSoptDays() != null) {
                priceBean = this
                        .setPriceBeanAttr(shipping.getSoptDays(), PriceDocumentFields.SHIPSOPT.getPath(), JsonFieldTypeVal.INTEGER
                                .getClazz());
                priceList.add(priceBean);
            }

            if (shipping.getWeight() != null) {
                priceBean = this
                        .setPriceBeanAttr(shipping.getWeight(), PriceDocumentFields.SHIPWEIGHT.getPath(), JsonFieldTypeVal.DOUBLE
                                .getClazz());
                priceList.add(priceBean);
            }

            if (shipping.getTaxCode() != null) {
                priceBean = this
                        .setPriceBeanAttr(shipping.getTaxCode(), PriceDocumentFields.SHIPTAXCODE.getPath(), JsonFieldTypeVal.INTEGER
                                .getClazz());
                priceList.add(priceBean);
            }

            if (shipping.getMaxShipElig() != null) {
                priceBean = this
                        .setPriceBeanAttr(shipping.getMaxShipElig(), PriceDocumentFields.SHIPMAXELIG.getPath(), JsonFieldTypeVal.STRING
                                .getClazz());
                priceList.add(priceBean);
            }

            if (shipping.getIsIntlShipElig() != null) {
                priceBean = this.setPriceBeanAttr(shipping.getIsIntlShipElig(), PriceDocumentFields.INTLSHIPELIG
                        .getPath(), JsonFieldTypeVal.BOOLEAN.getClazz());
                priceList.add(priceBean);
            }

            if (shipping.getDimensions() != null) {

                Dimensions dimensions = shipping.getDimensions();

                if (dimensions.getHeight() != null) {
                    priceBean = this
                            .setPriceBeanAttr(dimensions.getHeight(), PriceDocumentFields.HEIGHT.getPath(), JsonFieldTypeVal.DOUBLE
                                    .getClazz());
                    priceList.add(priceBean);

                }

                if (dimensions.getWidth() != null) {
                    priceBean = this
                            .setPriceBeanAttr(dimensions.getWidth(), PriceDocumentFields.WIDTH.getPath(), JsonFieldTypeVal.DOUBLE
                                    .getClazz());
                    priceList.add(priceBean);

                }

                if (dimensions.getLength() != null) {
                    priceBean = this
                            .setPriceBeanAttr(dimensions.getLength(), PriceDocumentFields.LENGTH.getPath(), JsonFieldTypeVal.DOUBLE
                                    .getClazz());
                    priceList.add(priceBean);
                }
            }

            if (shipping.getIsMailable() != null) {
                priceBean = this
                        .setPriceBeanAttr(shipping.getIsMailable(), PriceDocumentFields.MAILABLE.getPath(), JsonFieldTypeVal.BOOLEAN
                                .getClazz());
                priceList.add(priceBean);
            }

            if (shipping.getMode() != null) {
                ModeInfo mode = shipping.getMode();
                if (mode != null) {
                    if (mode.getHandlingFee() != null) {

                        priceBean = this.setPriceBeanAttr(mode.getHandlingFee(), PriceDocumentFields.HANDLINGFEEMODE
                                .getPath(), JsonFieldTypeVal.DOUBLE.getClazz());
                        priceList.add(priceBean);
                    }

                    if (mode.getGnd() != null) {

                        Ground gnd = mode.getGnd();

                        if (gnd.getPrice() != null) {
                            priceBean = this.setPriceBeanAttr(gnd.getPrice(), PriceDocumentFields.GNDMODEPRICE
                                    .getPath(), JsonFieldTypeVal.DOUBLE.getClazz());
                            priceList.add(priceBean);
                        }
                        if (gnd.getExcluded() != null) {
                            priceBean = this.setPriceBeanAttr(gnd.getExcluded(), PriceDocumentFields.GNDMODEEXCLUDE
                                    .getPath(), JsonFieldTypeVal.BOOLEAN.getClazz());
                            priceList.add(priceBean);
                        }

                        if (gnd.getFree() != null) {

                            Free free = gnd.getFree();
                            if (free != null) {
                                if (free.getStartDt() != null) {
                                    priceBean = this
                                            .setPriceBeanAttr(free.getStartDt(), PriceDocumentFields.GNDMODEFREESTARTDATE
                                                    .getPath(), JsonFieldTypeVal.STRING.getClazz());
                                    priceList.add(priceBean);
                                }
                                if (free.getEndDt() != null) {
                                    priceBean = this
                                            .setPriceBeanAttr(free.getEndDt(), PriceDocumentFields.GNDMODEFREEENDDATE
                                                    .getPath(), JsonFieldTypeVal.STRING.getClazz());
                                    priceList.add(priceBean);
                                }
                                if (free.getPromoTxt() != null) {
                                    priceBean = this
                                            .setPriceBeanAttr(free.getPromoTxt(), PriceDocumentFields.GNDMODEFREEPROMOTXT
                                                    .getPath(), JsonFieldTypeVal.STRING.getClazz());
                                    priceList.add(priceBean);
                                }
                            }
                        }

                        if (mode.getExp() != null) {
                            Expedited exp = mode.getExp();

                            if (exp.getPrice() != null) {

                                priceBean = this.setPriceBeanAttr(exp.getPrice(), PriceDocumentFields.EXPMODEPRICE
                                        .getPath(), JsonFieldTypeVal.DOUBLE.getClazz());
                                priceList.add(priceBean);

                            }

                            if (exp.getExcluded() != null) {
                                priceBean = this
                                        .setPriceBeanAttr(exp.getExcluded(), PriceDocumentFields.EXPMODEEXCLUDED
                                                .getPath(), JsonFieldTypeVal.BOOLEAN.getClazz());
                                priceList.add(priceBean);
                            }
                        }

                        if (mode.getPrem() != null) {
                            Premium premium = mode.getPrem();

                            if (premium.getPrice() != null) {
                                priceBean = this.setPriceBeanAttr(premium.getPrice(), PriceDocumentFields.PREMMODEPRICE
                                        .getPath(), JsonFieldTypeVal.DOUBLE.getClazz());
                                priceList.add(priceBean);
                            }

                            if (premium.getExcluded() != null) {
                                priceBean = this
                                        .setPriceBeanAttr(premium.getPrice(), PriceDocumentFields.PREMMODEEXCLUDED
                                                .getPath(), JsonFieldTypeVal.BOOLEAN.getClazz());
                                priceList.add(priceBean);
                            }
                        }
                    }

                    if (shipping.getShipSurcharge() != null) {
                        priceBean = this
                                .setPriceBeanAttr(shipping.getShipSurcharge(), PriceDocumentFields.SHIPSURCHARGE
                                        .getPath(), JsonFieldTypeVal.DOUBLE.getClazz());
                        priceList.add(priceBean);
                    }

                    // if (shipping.getIsShipAlone() != null) {
                    // flattenedPriceBean.setShipAlone(shipping.getIsShipAlone());
                    // }

                    if (shipping.getMaxQntyPurchasable() != null) {

                        MaxQntyPurchasable maxQntyPurchasable = shipping.getMaxQntyPurchasable();

                        if (maxQntyPurchasable.getSites() != null) {

                            SitesForMaxQnty sites = maxQntyPurchasable.getSites();

                            if (sites != null) {

                                if (sites.getSears() != null) {

                                    SiteVal sears = sites.getSears();
                                    if (sears != null) {

                                        priceBean = this
                                                .setPriceBeanAttr(sears.getVal(), PriceDocumentFields.SEARSMAXQNTYPURCHASABLE
                                                        .getPath(), JsonFieldTypeVal.STRING.getClazz());
                                        priceList.add(priceBean);
                                    }
                                }

                                if (sites.getKmart() != null) {
                                    SiteVal kmart = sites.getKmart();
                                    if (kmart != null) {

                                        priceBean = this
                                                .setPriceBeanAttr(kmart.getVal(), PriceDocumentFields.KMARTMAXQNTYPURCHASABLE
                                                        .getPath(), JsonFieldTypeVal.STRING.getClazz());
                                        priceList.add(priceBean);
                                    }
                                }
                            }
                        }
                    }

                    if (shipping.getFreeShip() != null) {

                        FreeShip freeShip = shipping.getFreeShip();

                        if (freeShip.getFreeShipThreshold() != null) {

                            priceBean = this
                                    .setPriceBeanAttr(freeShip.getFreeShipThreshold(), PriceDocumentFields.FREESHIPTHRESHOLD
                                            .getPath(), JsonFieldTypeVal.STRING.getClazz());
                            priceList.add(priceBean);
                        }

                        if (freeShip.isFreeDelivery() != null) {

                            priceBean = this
                                    .setPriceBeanAttr(freeShip.isFreeDelivery(), PriceDocumentFields.FREESHIPDELIVERY
                                            .getPath(), JsonFieldTypeVal.BOOLEAN.getClazz());
                            priceList.add(priceBean);
                        }

                        if (freeShip.isFreeShipFlag() != null) {

                            priceBean = this
                                    .setPriceBeanAttr(freeShip.isFreeShipFlag(), PriceDocumentFields.FREESHIPFLAG
                                            .getPath(), JsonFieldTypeVal.BOOLEAN.getClazz());
                            priceList.add(priceBean);

                        }

                        if (freeShip.getSites() != null) {

                            FreeShipSites sites = freeShip.getSites();

                            if (sites != null) {
                                if (sites.getSears() != null) {

                                    FreeShipSiteInfo shipSite = sites.getSears();

                                    if (shipSite.getFreeShipThreshold() != null) {

                                        // priceBean = this
                                        // .setPriceBeanAttr(shipSite.getFreeShipThreshold(),
                                        // PriceDocumentFields..getPath(), JsonFieldTypeVal.BOOLEAN
                                        // .getClazz());
                                        // priceList.add(priceBean);

                                        // flattenedPriceBean.setFreeShipThreshold(shipSite.getFreeShipThreshold());
                                    }

                                    // flattenedPriceBean.setEmptyFreeShip(shipSite.isEmptyFreeShip());
                                    // flattenedPriceBean.setFreeShipFlag(shipSite.isFreeShipFlag());
                                    // flattenedPriceBean.setFreeShipDelivery(shipSite.isFreeDelivery());
                                    // }
                                    // if (sites.getKmart() != null) {
                                    // FreeShipSiteInfo shipSite = sites.getKmart();
                                    //
                                    // if (shipSite.getFreeShipThreshold() != null) {
                                    // flattenedPriceBean.setFreeShipThreshold(shipSite.getFreeShipThreshold());
                                    // }
                                    //
                                    // flattenedPriceBean.setEmptyFreeShip(shipSite.isEmptyFreeShip());
                                    // flattenedPriceBean.setFreeShipFlag(shipSite.isFreeShipFlag());
                                    // flattenedPriceBean.setFreeShipDelivery(shipSite.isFreeDelivery());
                                    // }
                                }

                            }

                            if (shipping.getIsSywrMaxShipElig() != null) {

                                priceBean = this
                                        .setPriceBeanAttr(shipping.getIsSywrMaxShipElig(), PriceDocumentFields.SYWRMAXSHIPELIG
                                                .getPath(), JsonFieldTypeVal.BOOLEAN.getClazz());
                                priceList.add(priceBean);
                            }

                            if (shipping.getIsFlatRateShip() != null) {

                                priceBean = this
                                        .setPriceBeanAttr(shipping.getIsFlatRateShip(), PriceDocumentFields.FLATRATESHIP
                                                .getPath(), JsonFieldTypeVal.BOOLEAN.getClazz());
                                priceList.add(priceBean);
                            }

                            if (shipping.getIsSimiElig() != null) {

                                priceBean = this
                                        .setPriceBeanAttr(shipping.getIsSimiElig(), PriceDocumentFields.SIMIELIG
                                                .getPath(), JsonFieldTypeVal.BOOLEAN.getClazz());
                                priceList.add(priceBean);
                            }

                            if (shipping.getIsGroundOnly() != null) {

                                priceBean = this
                                        .setPriceBeanAttr(shipping.getIsGroundOnly(), PriceDocumentFields.GROUNDONLY
                                                .getPath(), JsonFieldTypeVal.BOOLEAN.getClazz());
                                priceList.add(priceBean);
                            }

                            if (shipping.getSywrFreeDelivery() != null) {

                                SYWRFreeDelivery sywrFreeDel = shipping.getSywrFreeDelivery();

                                if (sywrFreeDel != null) {
                                    if (sywrFreeDel.getStartDate() != null) {

                                        // priceBean = this
                                        // .setPriceBeanAttr(sywrFreeDel.getStartDate(), PriceDocumentFields..getPath(),
                                        // JsonFieldTypeVal.STRING
                                        // .getClazz());
                                        // priceList.add(priceBean);

                                        // flattenedPriceBean.setSywrFreeDeliveryStartDate(sywrFreeDel.getStartDate());
                                    }

                                    if (sywrFreeDel.getEndDate() != null) {

                                        // priceBean = this
                                        // .setPriceBeanAttr(sywrFreeDel.getEndDate(),
                                        // PriceDocumentFields.PREMMODEEXCLUDED.getPath(), JsonFieldTypeVal.BOOLEAN
                                        // .getClazz());
                                        // priceList.add(priceBean);

                                        // flattenedPriceBean.setSywrFreeDeliveryEndDate(sywrFreeDel.getEndDate());
                                    }

                                    if (sywrFreeDel.getMinpurchvalue() != null) {

                                        // priceBean = this
                                        // .setPriceBeanAttr(premium.getPrice(),
                                        // PriceDocumentFields.PREMMODEEXCLUDED.getPath(), JsonFieldTypeVal.BOOLEAN
                                        // .getClazz());
                                        // priceList.add(priceBean);

                                        // flattenedPriceBean.setSywrMinpurchvalue(sywrFreeDel.getMinpurchvalue());
                                    }
                                }
                            }
                        }
                    }
                    //
                    // if (shipping.getIntlCountryGrps().isEmpty()) {
                    // List<CountryGrp> countryList = shipping.getIntlCountryGrps();
                    // String country = "";
                    // for (CountryGrp countryGrp : countryList) {
                    // country += countryGrp.getId() + ":" + countryGrp.getName() + ";";
                    // }
                    //
                    // flattenedPriceBean.setCountryGrps(country);
                    // }
                }
            }
            //
        }
        priceBeanWrapper.setList(priceList);
        return priceBeanWrapper;
    }

}
