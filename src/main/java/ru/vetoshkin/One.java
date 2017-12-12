package ru.vetoshkin;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@Path("/ebota")
public class One {

    private static final Logger logger = LogManager.getLogger(One.class);

    @GET
    @Path("/ok")
    public Response all() {
        logger.info("AHAHHAHAH");
        return Response.ok().build();
    }

}
