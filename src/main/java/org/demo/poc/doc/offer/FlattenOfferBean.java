/**
 * 
 */
package org.demo.poc.doc.offer;

/**
 * @author pbhave
 *
 */
public class FlattenOfferBean {

    private String id, brandName;

    long timeStamp, bucket;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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
