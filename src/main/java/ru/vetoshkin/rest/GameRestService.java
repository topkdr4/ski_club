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
    @Path("/list/{date}")
    public SimpleResponse getAllGames(@PathParam("date") long date) throws SystemException {
        SimpleResponse response = new SimpleResponse();
        response.setResult(GameService.getGameList(date));
        return response;
    }

}
