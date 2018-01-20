package ru.vetoshkin.rest;
import ru.vetoshkin.core.SystemException;
import ru.vetoshkin.service.GameService;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@Path("/games")
@Consumes({ APPLICATION_JSON, APPLICATION_FORM_URLENCODED })
@Produces(APPLICATION_JSON)
public class GameRestService {

    @GET
    @Path("/list/{date}/{sex}/{age}")
    public SimpleResponse getAllGames(
            @PathParam("date") long date,
            @PathParam("sex") boolean sex,
            @PathParam("age") int age)
            throws SystemException {
        SimpleResponse response = new SimpleResponse();
        response.setResult(GameService.getGameList(date, sex, age));
        return response;
    }


    @GET
    @Path("/sportsmans/list/{gameId}")
    public SimpleResponse getSportsmans(@PathParam("gameId") int gameId) throws SystemException {
        SimpleResponse response = new SimpleResponse();
        response.setResult(GameService.getSportsmans(gameId));
        return response;
    }


    @DELETE
    @Path("/remove/{id}")
    public SimpleResponse removeResult(@PathParam("id") int id) throws SystemException {
        GameService.removeResult(id);
        return new SimpleResponse();
    }


    @DELETE
    @Path("/game/remove/{id}")
    public SimpleResponse removeGame(@PathParam("id") int id) throws SystemException {
        GameService.removeGame(id);
        return new SimpleResponse();
    }


    @PUT
    @Path("/add/{name}/{date}/{sex}/{age}")
    public SimpleResponse saveGame(
            @PathParam("name") String name,
            @PathParam("date") long date,
            @PathParam("sex") boolean sex,
            @PathParam("age") int age
    ) throws SystemException {
        GameService.saveGame(name, date, sex, age);
        return new SimpleResponse();
    }

}
