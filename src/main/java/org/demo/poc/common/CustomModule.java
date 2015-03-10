/**
 * 
 */
package org.demo.poc.common;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.shc.ift.greenbox.common.v2.doc.common.HierarchySpecificsMaster;

/**
 * @author pbhave
 *
 */
public class CustomModule extends SimpleModule {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public CustomModule() {
        super("CustomModule");
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(HierarchySpecificsMaster.class, MixIn.class);
    }

}
