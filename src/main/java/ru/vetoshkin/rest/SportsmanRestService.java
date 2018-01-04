package ru.vetoshkin.rest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vetoshkin.bean.Sportsman;
import ru.vetoshkin.service.SportsmanService;

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
    public SimpleResponse getSportsmanList() {
        logger.debug("get sportsman list");
        SimpleResponse response = new SimpleResponse();
        response.setResult(SportsmanService.getAllSportsmans());
        return response;
    }


    @GET
    @Path("/get")
    public Sportsman getSportsman(IdentityRequest request) {
        logger.debug("get sportsman info with id: " + request.getId());
        return SportsmanService.getSportsman(request.getId());
    }


    @DELETE
    @Path("/remove")
    public Response removeSportsman(IdentityRequest request) {
        logger.debug("remove sportsman with id: " + request.getId());
        SportsmanService.removeSportsman(request.getId());
        return EMPTY;
    }


    @PUT
    @Path("/save")
    public Sportsman addSportsman(Sportsman sportsman) {
        logger.debug("save sportsman");
        SportsmanService.saveSportsman(sportsman);
        return sportsman;
    }


}
