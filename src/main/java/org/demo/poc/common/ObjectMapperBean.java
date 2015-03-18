/**
 * 
 */
package org.demo.poc.common;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author pbhave
 *
 */
public class ObjectMapperBean extends ObjectMapper {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ObjectMapperBean() {
        super();

        // Register CustomModule, resolves setHierarchy vs sethierarchy issue with HierarchySpecificMaster class
        // objectMapper.registerModule(new CustomModule());
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        registerModules(new CustomModule());
    }

}
