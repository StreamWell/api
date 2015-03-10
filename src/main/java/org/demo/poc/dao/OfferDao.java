/**
 * 
 */
package org.demo.poc.dao;

import java.util.ArrayList;
import java.util.List;

import org.demo.poc.common.FlatBeanWrapper;
import org.demo.poc.common.ResponseWrapper;
import org.demo.poc.doc.offer.FlattenOfferBean;
import org.demo.poc.doc.price.FlattenPriceBean;

import com.shc.ift.greenbox.common.v2.doc.common.Blob;
import com.shc.ift.greenbox.common.v2.doc.common.Meta;
import com.shc.ift.greenbox.common.v2.doc.offer.CountryGrp;
import com.shc.ift.greenbox.common.v2.doc.offer.Dimensions;
import com.shc.ift.greenbox.common.v2.doc.offer.Expedited;
import com.shc.ift.greenbox.common.v2.doc.offer.Free;
import com.shc.ift.greenbox.common.v2.doc.offer.FreeShip;
import com.shc.ift.greenbox.common.v2.doc.offer.FreeShipSiteInfo;
import com.shc.ift.greenbox.common.v2.doc.offer.FreeShipSites;
import com.shc.ift.greenbox.common.v2.doc.offer.Ground;
import com.shc.ift.greenbox.common.v2.doc.offer.MaxQntyPurchasable;
import com.shc.ift.greenbox.common.v2.doc.offer.ModeInfo;
import com.shc.ift.greenbox.common.v2.doc.offer.Offer;
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
public class OfferDao {

    public FlatBeanWrapper getOfferList(FlatBeanWrapper offerList, ResponseWrapper[] offerWrapper) {

        List<FlattenOfferBean> flatOfferBeanList = new ArrayList<>();

        for (ResponseWrapper offerItem : offerWrapper) {
            FlattenOfferBean flatOffer = new FlattenOfferBean();
            Blob blob = offerItem.get_blob();
            Offer offer = blob.getOffer();

            flatOffer.setBucket(offerItem.get_bucket());
            flatOffer.setTimeStamp(offerItem.get_tmstmp());

            if (offer != null) {
                flatOffer = this.setFlatOffer(flatOffer, offer);
            }

            flatOfferBeanList.add(flatOffer);
        }
        offerList.setList(flatOfferBeanList);
        return offerList;
    }

    private FlattenOfferBean setFlatOffer(FlattenOfferBean flatOffer, Offer offer) {
        flatOffer.setId(offer.getId());
        flatOffer.setBrandName(offer.getBrandName());
        return flatOffer;
    }

    private FlattenPriceBean setFlatPrice(FlattenPriceBean flattenedPriceBean, Price priceItem) {

        flattenedPriceBean.setId(priceItem.getId());
        flattenedPriceBean.setCmt(priceItem.getCmt());
        flattenedPriceBean.setRegPrice(priceItem.getRegPrice());
        flattenedPriceBean.setRegPriceSrc(priceItem.getRegPriceSrc());
        flattenedPriceBean.setProgramType(priceItem.getProgramType());
        flattenedPriceBean.setPromoText(priceItem.getPromotext());
        flattenedPriceBean.setCost(priceItem.getCost());
        flattenedPriceBean.setMapVal(priceItem.getMapVal());

        if (priceItem.getMeta() != null) {
            Meta meta = priceItem.getMeta();
            flattenedPriceBean.setCreatedTs(meta.getCreatedTs());
            flattenedPriceBean.setModifiedTs(meta.getModifiedTs());
            flattenedPriceBean.setLastModifiedBy(meta.getLastModifiedBy());
        }

        if (priceItem.getShipping() != null) {
            Shipping shipping = priceItem.getShipping();
            flattenedPriceBean.setShipMinRate(shipping.getMinRate());

            if (shipping.getIsShipAlone() != null) {
                flattenedPriceBean.setShipAlone(shipping.getIsShipAlone());
            }

            // if (shipping.getIsCENotExists() != null) {
            // flattenedPriceBean.setCENotExists(shipping.getIsCENotExists());
            // }

            if (shipping.getSoptDays() != null) {
                flattenedPriceBean.setShipSopt(shipping.getSoptDays());
            }

            if (shipping.getWeight() != null) {
                flattenedPriceBean.setShipweight(shipping.getWeight());
            }

            if (shipping.getMinRate() != null) {
                flattenedPriceBean.setShipMinRate(shipping.getMinRate());
            }

            if (shipping.getTaxCode() != null) {
                flattenedPriceBean.setShipTaxCode(shipping.getTaxCode());
            }

            if (shipping.getMaxShipElig() != null) {
                flattenedPriceBean.setShipMaxElig(shipping.getMaxShipElig());
            }

            if (shipping.getIsIntlShipElig() != null) {
                flattenedPriceBean.setIntlShipElig(shipping.getIsIntlShipElig());
            }

            if (shipping.getDimensions() != null) {

                Dimensions dimensions = shipping.getDimensions();

                if (dimensions.getHeight() != null) {
                    flattenedPriceBean.setHeight(dimensions.getHeight());
                }

                if (dimensions.getWidth() != null) {
                    flattenedPriceBean.setWidth(dimensions.getWidth());
                }

                if (dimensions.getLength() != null) {
                    flattenedPriceBean.setLength(dimensions.getLength());
                }
            }

            if (shipping.getIsMailable() != null) {
                flattenedPriceBean.setMailable(shipping.getIsMailable());
            }

            if (shipping.getMode() != null) {
                ModeInfo mode = shipping.getMode();
                if (mode != null) {
                    if (mode.getHandlingFee() != null) {
                        flattenedPriceBean.setHandlingFeeMode(mode.getHandlingFee());
                    }

                    if (mode.getGnd() != null) {
                        Ground gnd = mode.getGnd();
                        if (gnd.getPrice() != null) {
                            flattenedPriceBean.setGndModePrice(gnd.getPrice());
                        }
                        if (gnd.getExcluded() != null) {
                            flattenedPriceBean.setGndModeExclude(gnd.getExcluded());
                        }
                        if (gnd.getFree() != null) {
                            Free free = gnd.getFree();
                            if (free != null) {
                                if (free.getStartDt() != null) {
                                    flattenedPriceBean.setGndModeFreeStartDate(free.getStartDt());
                                }
                                if (free.getEndDt() != null) {
                                    flattenedPriceBean.setGndModeFreeEndDate(free.getEndDt());
                                }
                                if (free.getPromoTxt() != null) {
                                    flattenedPriceBean.setGndModeFreePromoTxt(free.getPromoTxt());
                                }
                            }
                        }

                        if (mode.getExp() != null) {
                            Expedited exp = mode.getExp();

                            if (exp.getPrice() != null) {
                                flattenedPriceBean.setExpModePrice(exp.getPrice());
                            }

                            if (exp.getExcluded() != null) {
                                flattenedPriceBean.setExpModeExcluded(exp.getExcluded());
                            }
                        }

                        if (mode.getPrem() != null) {
                            Premium premium = mode.getPrem();

                            if (premium.getPrice() != null) {
                                flattenedPriceBean.setExpModePrice(premium.getPrice());
                            }

                            if (premium.getExcluded() != null) {
                                flattenedPriceBean.setExpModeExcluded(premium.getExcluded());
                            }
                        }
                    }

                    if (shipping.getShipSurcharge() != null) {
                        flattenedPriceBean.setShipSurcharge(shipping.getShipSurcharge());
                    }

                    if (shipping.getIsShipAlone() != null) {
                        flattenedPriceBean.setShipAlone(shipping.getIsShipAlone());
                    }

                    if (shipping.getMaxQntyPurchasable() != null) {
                        MaxQntyPurchasable maxQntyPurchasable = shipping.getMaxQntyPurchasable();

                        if (maxQntyPurchasable.getSites() != null) {
                            SitesForMaxQnty sites = maxQntyPurchasable.getSites();

                            if (sites != null) {
                                if (sites.getSears() != null) {
                                    SiteVal sears = sites.getSears();
                                    if (sears != null) {
                                        flattenedPriceBean.setSearsMaxQntyPurchasable(sears.getVal());
                                    }
                                }

                                if (sites.getKmart() != null) {
                                    SiteVal kmart = sites.getKmart();
                                    if (kmart != null) {
                                        flattenedPriceBean.setKmartMaxQntyPurchasable(kmart.getVal());
                                    }
                                }
                            }
                        }
                    }

                    if (shipping.getFreeShip() != null) {
                        FreeShip freeShip = shipping.getFreeShip();

                        if (freeShip.getFreeShipThreshold() != null) {
                            flattenedPriceBean.setFreeShipThreshold(freeShip.getFreeShipThreshold());
                        }

                        if (freeShip.isFreeDelivery() != null) {
                            flattenedPriceBean.setFreeShipDelivery(freeShip.isFreeDelivery());
                        }

                        if (freeShip.isFreeShipFlag() != null) {
                            flattenedPriceBean.setFreeShipFlag(freeShip.isFreeShipFlag());
                        }

                        if (freeShip.getSites() != null) {
                            FreeShipSites sites = freeShip.getSites();

                            if (sites != null) {
                                if (sites.getSears() != null) {
                                    FreeShipSiteInfo shipSite = sites.getSears();

                                    if (shipSite.getFreeShipThreshold() != null) {
                                        flattenedPriceBean.setFreeShipThreshold(shipSite.getFreeShipThreshold());
                                    }

                                    flattenedPriceBean.setEmptyFreeShip(shipSite.isEmptyFreeShip());
                                    flattenedPriceBean.setFreeShipFlag(shipSite.isFreeShipFlag());
                                    flattenedPriceBean.setFreeShipDelivery(shipSite.isFreeDelivery());
                                }
                                if (sites.getKmart() != null) {
                                    FreeShipSiteInfo shipSite = sites.getKmart();

                                    if (shipSite.getFreeShipThreshold() != null) {
                                        flattenedPriceBean.setFreeShipThreshold(shipSite.getFreeShipThreshold());
                                    }

                                    flattenedPriceBean.setEmptyFreeShip(shipSite.isEmptyFreeShip());
                                    flattenedPriceBean.setFreeShipFlag(shipSite.isFreeShipFlag());
                                    flattenedPriceBean.setFreeShipDelivery(shipSite.isFreeDelivery());
                                }
                            }

                        }

                        if (shipping.getIsSywrMaxShipElig() != null) {
                            flattenedPriceBean.setSywrMaxShipElig(shipping.getIsSywrMaxShipElig());
                        }

                        if (shipping.getIsFlatRateShip() != null) {
                            flattenedPriceBean.setFlatRateShip(shipping.getIsFlatRateShip());
                        }

                        if (shipping.getIsSimiElig() != null) {
                            flattenedPriceBean.setSimiElig(shipping.getIsSimiElig());
                        }

                        if (shipping.getIsGroundOnly() != null) {
                            flattenedPriceBean.setGroundOnly(shipping.getIsGroundOnly());
                        }

                        if (shipping.getSywrFreeDelivery() != null) {
                            SYWRFreeDelivery sywrFreeDel = shipping.getSywrFreeDelivery();
                            if (sywrFreeDel != null) {
                                if (sywrFreeDel.getStartDate() != null) {
                                    flattenedPriceBean.setSywrFreeDeliveryStartDate(sywrFreeDel.getStartDate());
                                }

                                if (sywrFreeDel.getEndDate() != null) {
                                    flattenedPriceBean.setSywrFreeDeliveryEndDate(sywrFreeDel.getEndDate());
                                }

                                if (sywrFreeDel.getMinpurchvalue() != null) {
                                    flattenedPriceBean.setSywrMinpurchvalue(sywrFreeDel.getMinpurchvalue());
                                }
                            }
                        }
                    }

                }

                if (shipping.getIntlCountryGrps().isEmpty()) {
                    List<CountryGrp> countryList = shipping.getIntlCountryGrps();
                    String country = "";
                    for (CountryGrp countryGrp : countryList) {
                        country += countryGrp.getId() + ":" + countryGrp.getName() + ";";
                    }

                    flattenedPriceBean.setCountryGrps(country);
                }
            }

        }
        return flattenedPriceBean;
    }

}
