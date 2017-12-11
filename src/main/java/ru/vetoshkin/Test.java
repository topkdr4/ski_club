package ru.vetoshkin;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@Path("/go")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Test {

    private static final Logger logger = LogManager.getLogger(Test.class);


    @GET
    @Path("/now")
    public String go() {
        logger.info("OLOLOL");
        return "";
    }


}
