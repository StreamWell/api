/**
 * 
 */
package org.demo.poc.doc.price;

/**
 * @author pbhave
 *
 */
public enum PriceDocumentFields {

    BUCKET("_bucket"),
    TIMESTAMP("_tmpstmp"),
    ID("_blob.price.id"),
    CMT("_blob.price.cmt"),
    MAPVAL("_blob.price.mapVal"),
    CREATEDTS("_blob.price.meta.createdTs"),
    MODIFIEDTS("_blob.price.meta.modifiedTs"),
    LASTMODIFIEDBY("_blob.price.meta.lastModifiedBy"),
    PROGRAMTYPE("_blob.price.programType"),
    PROMOTEXT("_blob.price.promoText"),
    REGPRICE("_blob.price.regPrice"),
    REGPRICESRC("_blob.price.regPriceSrc"),
    COST("_blob.price.cost"),
    SALEENDDATE("_blob.price.sale.saleEndDate"),
    SALEPRICE("_blob.price.sale.salePrice"),
    SHIPMAXELIG("_blob.price.shipping.shipMaxElig"),
    INTLCOUNTRYGRPS("_blob.price.shipping.intlCountryGrps"),
    GNDMODEFREESTARTDATE("_blob.price.shipping.mode.gnd.free.startDt"),
    GNDMODEFREEENDDATE("_blob.price.shipping.mode.gnd.free.endDt"),
    GNDMODEFREEPROMOTXT("_blob.price.shipping.mode.gnd.free.promoTxt"),
    SEARSMAXQNTYPURCHASABLE("_blob.price.shipping.maxQntyPurchasable.sites.sears"),
    KMARTMAXQNTYPURCHASABLE("_blob.price.shipping.maxQntyPurchasable.sites.kmart"),
    FREESHIPTHRESHOLD("_blob.price.shipping.freeShip.freeShipThreshold"),
//    FREESHIPSEARS
//    FREESHIPKMART"),("
//    SYWRFREEDELIVERYSTARTDATE"),("
//    SYWRFREEDELIVERYENDDATE"),("
    COUNTRYGRPS("_blob.price.shipping.intlCountryGrps"),
    FREESHIPFLAG("_blob.price.shipping.freeShip.freeShipFlag"),
    FREESHIPDELIVERY("_blob.price.shipping.freeShip.freeShipDelivery"),
    SHIPSOPT("_blob.price.shipping.soptDays"),
    SHIPTAXCODE("_blob.price.shipping.taxCode"),
    SHIPMINRATE("_blob.price.shipping.minRate"),
    HANDLINGFEEMODE("_blob.price.shipping.mode.handlingFee"),
    GNDMODEPRICE("_blob.price.shipping.mode.gnd.price"),
    EXPMODEPRICE("_blob.price.shipping.mode.exp.price"),
    SHIPSURCHARGE("_blob.price.shipping.shipSurcharge"),
    SHIPWEIGHT("_blob.price.shipping.weight"),
    HEIGHT("_blob.price.shipping.dimensions.height"),
    WIDTH("_blob.price.shipping.dimensions.width"),
    LENGTH("_blob.price.shipping.dimensions.length"),
//    SYWRMINPURCHVALUE"),("
//    TIMESTAMP"),("
//    BUCKET"),("
    SHIPALONE("_blob.price.shipping.shipSurcharge"),
    INTLSHIPELIG("_blob.price.shipping.isIntlShipElig"),
    MAILABLE("_blob.price.shipping.isMailable"),
    GNDMODEEXCLUDE("_blob.price.shipping.mode.gnd.excluded"),
    EXPMODEEXCLUDED("_blob.price.shipping.mode.exp.excluded"),
    PREMMODEEXCLUDED("_blob.price.shipping.mode.prem.excluded"),
    PREMMODEPRICE("_blob.price.shipping.mode.prem.price"),
    EMPTYFREESHIP("_blob.price.shipping.freeShip.emptyFreeShip"),
    SYWRMAXSHIPELIG("_blob.price.shipping.isSywrMaxShipElig"),
    FLATRATESHIP("_blob.price.shipping.isFlatRateShip"),
    SIMIELIG("_blob.price.shipping.isSimiElig"),
    GROUNDONLY("_blob.price.shipping.isGroundOnly"),
    CENOTEXISTS("_blob.price.isCENotExists");

    private String path;

    private PriceDocumentFields(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
