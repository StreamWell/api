/**
 * 
 */
package org.demo.poc.common;

import java.sql.Date;
import java.util.Map;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

/**
 * @author pbhave
 *
 */
public enum JsonFieldTypeVal {

    STRING(String.class), BOOLEAN(Boolean.class), INTEGER(Integer.class), DOUBLE(Double.class), DATE(Date.class), LIST(List.class), MAP(Map.class);

    private Class<?> clazz;

    private JsonFieldTypeVal(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getClazz() {
        return clazz;
    }

}
