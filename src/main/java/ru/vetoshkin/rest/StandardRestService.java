package ru.vetoshkin.rest;
import ru.vetoshkin.core.SystemException;
import ru.vetoshkin.service.StandardService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@Path("/standard")
@Consumes({ APPLICATION_JSON, APPLICATION_FORM_URLENCODED })
@Produces(APPLICATION_JSON)
public class StandardRestService {

    private static final Response EMPTY = Response.status(200).build();

    @GET
    @Path("/list/{sex}/{age}")
    public SimpleResponse getWindRecord(@PathParam("sex") boolean sex, @PathParam("age") int age) throws SystemException {
        SimpleResponse response = new SimpleResponse();
        response.setResult(StandardService.getAll(sex, age));
        return response;
    }


    @DELETE
    @Path("/remove/{id}")
    public Response remove(@PathParam("id") int id) throws SystemException {
        StandardService.removeStandard(id);
        return EMPTY;
    }

}
