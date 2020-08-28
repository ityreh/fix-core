package de.ityreh.fixotron.session;

import quickfix.ConfigError;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/session")
public class SessionResource {

    private final SessionService sessionService = new SessionService();

    @GET
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public String create() {
        try {
            sessionService.createAccetor();
        } catch (ConfigError configError) {
            configError.printStackTrace();
            return "ERROR";
        }
        return "OK";
    }
}