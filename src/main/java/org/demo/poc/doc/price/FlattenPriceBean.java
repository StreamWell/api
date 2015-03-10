/**
 * 
 */
package org.demo.poc.doc.price;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author pbhave
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "cmt", "mapVal", "createdTs", "modifiedTs", "lastModifiedBy", "programType", "promoText", "regPrice", "saleEndDate", "salePrice", "cost", "shipSopt", "shipweight", "shipMinRate", "shipTaxCode", "shipMaxElig", "isSywrMaxShipElig", "isIntlShipElig", "intlCountryGrps", "height", "width", "length", "isMailable", "handlingFeeMode", "isGndModeExclude", "gndModePrice", "gndModeFreeStartDate", "gndModeFreeEndDate", "gndModeFreePromoTxt", "expModePrice", "isExpModeExcluded", "shipSurcharge", "isShipAlone", "searsMaxQntyPurchasable", "kmartMaxQntyPurchasable", "freeShipDelivery", "freeShipFlag", "freeShipThreshold", "freeShipSears", "freeShipKmart", "isEmptyFreeShip", "isSimiElig", "    isGroundOnly", "sywrFreeDelivery", "isFlatRateShip", "isCENotExists", "regPriceSrc" })
public class FlattenPriceBean {

    String id;
    String cmt, mapVal, createdTs, modifiedTs, lastModifiedBy, programType, promoText, regPrice, regPriceSrc, cost,
            saleEndDate, salePrice, shipMaxElig, intlCountryGrps, gndModeFreeStartDate, gndModeFreeEndDate,
            gndModeFreePromoTxt, searsMaxQntyPurchasable, kmartMaxQntyPurchasable, freeShipThreshold, freeShipSears,
            freeShipKmart, sywrFreeDeliveryStartDate, sywrFreeDeliveryEndDate, countryGrps;

    boolean isSywrMaxShipElig, isIntlShipElig, isMailable, isGndModeExclude, isExpModeExcluded, isShipAlone,
            freeShipFlag, isEmptyFreeShip, isSimiElig, isGroundOnly, isFlatRateShip, isCENotExists, freeShipDelivery;

    Integer shipSopt, shipTaxCode;
    Double shipMinRate, handlingFeeMode, gndModePrice, expModePrice, shipSurcharge, shipweight, height, width, length,
            sywrMinpurchvalue;

    long timeStamp, bucket;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getMapVal() {
        return mapVal;
    }

    public void setMapVal(String mapVal) {
        this.mapVal = mapVal;
    }

    public String getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(String createdTs) {
        this.createdTs = createdTs;
    }

    public String getModifiedTs() {
        return modifiedTs;
    }

    public void setModifiedTs(String modifiedTs) {
        this.modifiedTs = modifiedTs;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getPromoText() {
        return promoText;
    }

    public void setPromoText(String promoText) {
        this.promoText = promoText;
    }

    public String getRegPrice() {
        return regPrice;
    }

    public void setRegPrice(String regPrice) {
        this.regPrice = regPrice;
    }

    public String getRegPriceSrc() {
        return regPriceSrc;
    }

    public void setRegPriceSrc(String regPriceSrc) {
        this.regPriceSrc = regPriceSrc;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getSaleEndDate() {
        return saleEndDate;
    }

    public void setSaleEndDate(String saleEndDate) {
        this.saleEndDate = saleEndDate;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getShipMaxElig() {
        return shipMaxElig;
    }

    public void setShipMaxElig(String shipMaxElig) {
        this.shipMaxElig = shipMaxElig;
    }

    public String getIntlCountryGrps() {
        return intlCountryGrps;
    }

    public void setIntlCountryGrps(String intlCountryGrps) {
        this.intlCountryGrps = intlCountryGrps;
    }

    public String getGndModeFreeStartDate() {
        return gndModeFreeStartDate;
    }

    public void setGndModeFreeStartDate(String gndModeFreeStartDate) {
        this.gndModeFreeStartDate = gndModeFreeStartDate;
    }

    public String getGndModeFreeEndDate() {
        return gndModeFreeEndDate;
    }

    public void setGndModeFreeEndDate(String gndModeFreeEndDate) {
        this.gndModeFreeEndDate = gndModeFreeEndDate;
    }

    public String getGndModeFreePromoTxt() {
        return gndModeFreePromoTxt;
    }

    public void setGndModeFreePromoTxt(String gndModeFreePromoTxt) {
        this.gndModeFreePromoTxt = gndModeFreePromoTxt;
    }

    public String getSearsMaxQntyPurchasable() {
        return searsMaxQntyPurchasable;
    }

    public void setSearsMaxQntyPurchasable(String searsMaxQntyPurchasable) {
        this.searsMaxQntyPurchasable = searsMaxQntyPurchasable;
    }

    public String getKmartMaxQntyPurchasable() {
        return kmartMaxQntyPurchasable;
    }

    public void setKmartMaxQntyPurchasable(String kmartMaxQntyPurchasable) {
        this.kmartMaxQntyPurchasable = kmartMaxQntyPurchasable;
    }

    public String getFreeShipThreshold() {
        return freeShipThreshold;
    }

    public void setFreeShipThreshold(String freeShipThreshold) {
        this.freeShipThreshold = freeShipThreshold;
    }

    public String getFreeShipSears() {
        return freeShipSears;
    }

    public void setFreeShipSears(String freeShipSears) {
        this.freeShipSears = freeShipSears;
    }

    public String getFreeShipKmart() {
        return freeShipKmart;
    }

    public void setFreeShipKmart(String freeShipKmart) {
        this.freeShipKmart = freeShipKmart;
    }

    public String getSywrFreeDeliveryStartDate() {
        return sywrFreeDeliveryStartDate;
    }

    public void setSywrFreeDeliveryStartDate(String sywrFreeDeliveryStartDate) {
        this.sywrFreeDeliveryStartDate = sywrFreeDeliveryStartDate;
    }

    public String getSywrFreeDeliveryEndDate() {
        return sywrFreeDeliveryEndDate;
    }

    public void setSywrFreeDeliveryEndDate(String sywrFreeDeliveryEndDate) {
        this.sywrFreeDeliveryEndDate = sywrFreeDeliveryEndDate;
    }

    public String getCountryGrps() {
        return countryGrps;
    }

    public void setCountryGrps(String countryGrps) {
        this.countryGrps = countryGrps;
    }

    public boolean isSywrMaxShipElig() {
        return isSywrMaxShipElig;
    }

    public void setSywrMaxShipElig(boolean isSywrMaxShipElig) {
        this.isSywrMaxShipElig = isSywrMaxShipElig;
    }

    public boolean isIntlShipElig() {
        return isIntlShipElig;
    }

    public void setIntlShipElig(boolean isIntlShipElig) {
        this.isIntlShipElig = isIntlShipElig;
    }

    public boolean isMailable() {
        return isMailable;
    }

    public void setMailable(boolean isMailable) {
        this.isMailable = isMailable;
    }

    public boolean isGndModeExclude() {
        return isGndModeExclude;
    }

    public void setGndModeExclude(boolean isGndModeExclude) {
        this.isGndModeExclude = isGndModeExclude;
    }

    public boolean isExpModeExcluded() {
        return isExpModeExcluded;
    }

    public void setExpModeExcluded(boolean isExpModeExcluded) {
        this.isExpModeExcluded = isExpModeExcluded;
    }

    public boolean isShipAlone() {
        return isShipAlone;
    }

    public void setShipAlone(boolean isShipAlone) {
        this.isShipAlone = isShipAlone;
    }

    public boolean isFreeShipFlag() {
        return freeShipFlag;
    }

    public void setFreeShipFlag(boolean freeShipFlag) {
        this.freeShipFlag = freeShipFlag;
    }

    public boolean isEmptyFreeShip() {
        return isEmptyFreeShip;
    }

    public void setEmptyFreeShip(boolean isEmptyFreeShip) {
        this.isEmptyFreeShip = isEmptyFreeShip;
    }

    public boolean isSimiElig() {
        return isSimiElig;
    }

    public void setSimiElig(boolean isSimiElig) {
        this.isSimiElig = isSimiElig;
    }

    public boolean isGroundOnly() {
        return isGroundOnly;
    }

    public void setGroundOnly(boolean isGroundOnly) {
        this.isGroundOnly = isGroundOnly;
    }

    public boolean isFlatRateShip() {
        return isFlatRateShip;
    }

    public void setFlatRateShip(boolean isFlatRateShip) {
        this.isFlatRateShip = isFlatRateShip;
    }

    public boolean isCENotExists() {
        return isCENotExists;
    }

    public void setCENotExists(boolean isCENotExists) {
        this.isCENotExists = isCENotExists;
    }

    public boolean isFreeShipDelivery() {
        return freeShipDelivery;
    }

    public void setFreeShipDelivery(boolean freeShipDelivery) {
        this.freeShipDelivery = freeShipDelivery;
    }

    public Integer getShipSopt() {
        return shipSopt;
    }

    public void setShipSopt(Integer shipSopt) {
        this.shipSopt = shipSopt;
    }

    public Integer getShipTaxCode() {
        return shipTaxCode;
    }

    public void setShipTaxCode(Integer shipTaxCode) {
        this.shipTaxCode = shipTaxCode;
    }

    public Double getShipMinRate() {
        return shipMinRate;
    }

    public void setShipMinRate(Double shipMinRate) {
        this.shipMinRate = shipMinRate;
    }

    public Double getHandlingFeeMode() {
        return handlingFeeMode;
    }

    public void setHandlingFeeMode(Double handlingFeeMode) {
        this.handlingFeeMode = handlingFeeMode;
    }

    public Double getGndModePrice() {
        return gndModePrice;
    }

    public void setGndModePrice(Double gndModePrice) {
        this.gndModePrice = gndModePrice;
    }

    public Double getExpModePrice() {
        return expModePrice;
    }

    public void setExpModePrice(Double expModePrice) {
        this.expModePrice = expModePrice;
    }

    public Double getShipSurcharge() {
        return shipSurcharge;
    }

    public void setShipSurcharge(Double shipSurcharge) {
        this.shipSurcharge = shipSurcharge;
    }

    public Double getShipweight() {
        return shipweight;
    }

    public void setShipweight(Double shipweight) {
        this.shipweight = shipweight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getSywrMinpurchvalue() {
        return sywrMinpurchvalue;
    }

    public void setSywrMinpurchvalue(Double sywrMinpurchvalue) {
        this.sywrMinpurchvalue = sywrMinpurchvalue;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getBucket() {
        return bucket;
    }

    public void setBucket(long bucket) {
        this.bucket = bucket;
    }

}
