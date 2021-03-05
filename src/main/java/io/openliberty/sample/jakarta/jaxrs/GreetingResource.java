package io.openliberty.sample.jakarta.jaxrs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("greeting")
public class GreetingResource {

    private int pathNum;
  
    public GreetingResource(@PathParam("num") int pathNum) {
        this.pathNum = pathNum;
        // this.uriInfo = uriInfo;
    }
  
    @Path("/test1")
    @POST
    public String handle(String entityParam, String entityParam2) {
        System.out.println(entityParam + "; " + entityParam2);
        return "Received entity parameter: " + entityParam + "; entityParam2: " + entityParam2;
    }
    
    @GET
    @Path("/test{num:[1-9]{0,1}}")
    public String handleRequest(String entity1, String entity2) {
        return "number: " + this.pathNum + "; entity1: " + entity1 + ":" + entity2;
    }
}
