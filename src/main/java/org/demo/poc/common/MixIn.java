/**
 * 
 */
package org.demo.poc.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shc.ift.greenbox.common.v2.doc.common.IdSpinIdName;

/**
 * @author pbhave
 *
 */

public abstract class MixIn {

    @JsonProperty(value = "hierarchy")
    List<IdSpinIdName> hierarchy;

    @JsonIgnore
    public List<IdSpinIdName> gethierarchy() {
        return hierarchy;
    }

    @JsonIgnore
    public void sethierarchy(List<IdSpinIdName> hierarchy) {
        this.hierarchy = hierarchy;
    }

}
