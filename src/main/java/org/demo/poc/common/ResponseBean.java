/**
 * 
 */
package org.demo.poc.common;

/**
 * @author pbhave
 * @param <T>
 *
 */
public class ResponseBean {

    Object value;
    String path;
    Class<?> type;

    public String getPath() {
        return path;
    }

    public ResponseBean setPath(String path) {
        this.path = path;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public ResponseBean setValue(Object value) {
        this.value = value;
        return this;
    }

    public Class<?> getType() {
        return type;
    }

    public ResponseBean setType(Class<?> type) {
        this.type = type;
        return this;
    }

}
