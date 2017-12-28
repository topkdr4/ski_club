package ru.vetoshkin.rest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vetoshkin.bean.Sportsman;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/sportsman")
@Consumes("application/json")
@Produces("application/json")
public class SportsmanRestService {

    private static final Logger logger = LogManager.getLogger(SportsmanRestService.class);
    private static final Response EMPTY = Response.status(200).build();


    @GET
    @Path("/list")
    public Response getSportsmanList() {
        logger.debug("get sportsman list");
        return EMPTY;
    }


    @GET
    @Path("/item/{id}")
    public Response getSportsman(@PathParam("id") String sportsmanId) {
        logger.debug("get sportsman info with id: " + sportsmanId);
        return EMPTY;
    }


    @DELETE
    @Path("/item/{id}")
    public Response removeSportsman(@PathParam("id") String sportsmanId) {
        logger.debug("remove sportsman with id: " + sportsmanId);
        return EMPTY;
    }


    @PUT
    @Path("/item/new")
    public Response addSportsman(Sportsman sportsman) {
        logger.debug("add new sportsman");
        return EMPTY;
    }


}
