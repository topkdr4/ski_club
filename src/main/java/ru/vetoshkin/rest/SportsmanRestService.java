package ru.vetoshkin.rest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vetoshkin.bean.Sportsman;
import ru.vetoshkin.core.SystemException;
import ru.vetoshkin.service.SportsmanService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;





@Path("/sportsman")
@Consumes({ APPLICATION_JSON, APPLICATION_FORM_URLENCODED })
@Produces(APPLICATION_JSON)
public class SportsmanRestService {

    private static final Logger logger = LogManager.getLogger(SportsmanRestService.class);
    private static final Response EMPTY = Response.status(200).build();


    @GET
    @Path("/list")
    public SimpleResponse getSportsmanList() throws SystemException {
        logger.debug("get sportsman list");
        SimpleResponse response = new SimpleResponse();
        response.setResult(SportsmanService.getAllSportsmans());
        return response;
    }


    @GET
    @Path("/list/{from}/{to}")
    public SimpleResponse getSportsmanListRange(@PathParam("from") int from, @PathParam("to") int to) throws SystemException {
        logger.debug("get sportsmans list range");
        SimpleResponse response = new SimpleResponse();
        response.setResult(SportsmanService.getSportsmans(from, to));
        return response;
    }


    @GET
    @Path("/list/count")
    public SimpleResponse getTrainersCount() throws SystemException {
        logger.debug("get sportsmans count");
        SimpleResponse response = new SimpleResponse();
        response.setResult(SportsmanService.getAllSportsmansCount());
        return response;
    }


    @GET
    @Path("/get/{id}")
    public Sportsman getSportsman(@PathParam("id") int id) throws SystemException {
        logger.debug("get sportsman info with id: " + id);
        return SportsmanService.getSportsman(id);
    }


    @DELETE
    @Path("/remove/{id}")
    public Response removeSportsman(@PathParam("id") int id) {
        logger.debug("remove sportsman with id: " + id);
        SportsmanService.removeSportsman(id);
        return EMPTY;
    }


    @PUT
    @Path("/save")
    public Sportsman addSportsman(Sportsman sportsman) throws SystemException {
        logger.debug("save sportsman");
        SportsmanService.saveSportsman(sportsman);
        return sportsman;
    }


}
