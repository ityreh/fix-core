package de.ityreh.fixotron.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/session")
public class SessionResource {

    @GET
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public String create() {
        return "hello";
    }
}