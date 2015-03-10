/**
 * 
 */
package org.demo.poc.common;

import com.shc.ift.greenbox.common.v2.doc.common.Blob;

/**
 * @author pbhave
 *
 */
public class ResponseWrapper {

    private Blob _blob;
    private long _bucket, _tmstmp;

    public Blob get_blob() {
        return _blob;
    }

    public void set_blob(Blob _blob) {
        this._blob = _blob;
    }

    public long get_bucket() {
        return _bucket;
    }

    public void set_bucket(long _bucket) {
        this._bucket = _bucket;
    }

    public long get_tmstmp() {
        return _tmstmp;
    }

    public void set_tmstmp(long _tmstmp) {
        this._tmstmp = _tmstmp;
    }

}
