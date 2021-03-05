package io.openliberty.sample.jakarta.jaxrs;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("goodbye")
public class GoodbyeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    // end::produces[]
    public String getProperties() {
        return "Goodbye";
    }
    
}
