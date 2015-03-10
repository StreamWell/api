/**
 * 
 */
package org.demo.poc.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author pbhave
 * @date Feb 26,2016 22:36
 *
 */

@Path("/")
@Produces({ MediaType.APPLICATION_JSON + ";qs=1", MediaType.APPLICATION_XML + ";qs=0.8" })
@Consumes({ MediaType.APPLICATION_JSON + ";qs=1;", MediaType.APPLICATION_XML + ";qs=0.8" })
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Ping extends ParentApiBean {

    private static final String PING_OK = "OK";

    private static final Logger LOG = Logger.getLogger(Ping.class.getSimpleName());

    @GET
    @Path("/ping")
    public Response ping() {
        LOG.info("Ping-ed");
        return super.responseBuilder(Status.OK, PING_OK);
    }
}
