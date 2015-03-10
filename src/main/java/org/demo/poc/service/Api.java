/**
 * 
 */
package org.demo.poc.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.demo.poc.common.FlatBeanWrapper;
import org.demo.poc.common.ResponseBeanWrapper;
import org.demo.poc.common.ResponseWrapper;

/**
 * @author pbhave
 *
 */

@Path("/data")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Api extends ParentApiBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(Api.class.getSimpleName());

    @GET
    @Path("/price")
    public Response getPrice(@QueryParam("id") String id) {

        String uri = this.getOfferIds(getBaseUri(), getPricing(), id);

        HttpGet httpGet = getHttpGet(uri);

        List<ResponseBeanWrapper> priceList = new ArrayList<>();

        try {

            HttpResponse httpResponse = httpClient.execute(httpGet);

            InputStream content = httpResponse.getEntity().getContent();
            // LOG.info(IOUtils.toString(content));
            ResponseWrapper[] priceWrapper = (ResponseWrapper[]) getObjectMapper()
                    .readValue(content, ResponseWrapper[].class);

            priceList = getPriceDao().getPriceList(priceList, priceWrapper);

            return responseBuilder(Status.OK, priceList);

        } catch (IOException e) {
            LOG.info(e.getMessage());
        }
        return responseBuilder(Status.NOT_FOUND, "Possible issues with api");

    }

    @GET
    @Path("/offer")
    public Response getOffer(@QueryParam("id") String id) {

        String uri = getOfferIds(getBaseUri(), getOffer(), id);

        HttpGet httpGet = getHttpGet(uri);

        FlatBeanWrapper offerList = new FlatBeanWrapper();

        try {

            HttpResponse httpResponse = httpClient.execute(httpGet);

            InputStream content = httpResponse.getEntity().getContent();
            // LOG.info(IOUtils.toString(content));
            ResponseWrapper[] offerWrapper = (ResponseWrapper[]) getObjectMapper()
                    .readValue(content, ResponseWrapper[].class);

            offerList = getOfferDao().getOfferList(offerList, offerWrapper);
            return responseBuilder(Status.OK, offerList);
            // return responseBuilder(Status.OK, IOUtils.toString(content));

        } catch (IOException e) {
            LOG.info(e.getMessage());
        }
        return responseBuilder(Status.NOT_FOUND, "Possible issues with api");

    }

}
