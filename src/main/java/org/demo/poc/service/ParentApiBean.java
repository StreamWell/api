/**
 * 
 */
package org.demo.poc.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.demo.poc.common.ObjectMapperBean;
import org.demo.poc.dao.OfferDao;
import org.demo.poc.dao.PriceDao;

/**
 * @author pbhave
 *
 */
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
// @JsonInclude(JsonInclude.Include.NON_NULL)
// @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ParentApiBean {

    private static final String ACCEPT = "Accept";

    private static final String USER_AGENT = "RestFul";
    HttpClient httpClient = HttpClientBuilder.create().build();

    private String baseUri, pricing, content, offer;

    private ObjectMapperBean objectMapper;

    private PriceDao priceDao;

    private OfferDao offerDao;

    public OfferDao getOfferDao() {
        return offerDao;
    }

    public void setOfferDao(OfferDao offerDao) {
        this.offerDao = offerDao;
    }

    public PriceDao getPriceDao() {
        return priceDao;
    }

    public void setPriceDao(PriceDao priceDao) {
        this.priceDao = priceDao;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public ObjectMapperBean getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapperBean objectMapper) {
        this.objectMapper = objectMapper;
    }

    protected String getOfferIds(String uri, String collection, String ids) {

        String[] offerIds = ids.split(",");
        uri += collection;
        for (String offerId : offerIds) {
            uri += offerId + "/";
        }
        return uri;

    }

    protected HttpGet getHttpGet(String uri) {
        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeader("User-Agent", USER_AGENT);
        httpGet.setHeader(ACCEPT, MediaType.APPLICATION_JSON);
        return httpGet;
    }

    /**
     * Common method to send response as a service. Expects Status and Entity
     * object and returns a response with custom headers
     */
    protected Response responseBuilder(Status status, Object entity) {
        return Response.status(status).entity(entity).header("Server", "RESTful WS Demo").build();
    }

}
