/**
 * 
 */
package org.demo.poc.common;

import javax.ws.rs.ext.ContextResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author pbhave
 *
 */

public class CustomObjectMapperProvider implements ContextResolver<ObjectMapper> {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModules(new CustomModule());
    }

    @Override
    public ObjectMapper getContext(Class<?> blah) {
        return objectMapper;
    }
}
