package ru.vetoshkin.rest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vetoshkin.bean.Trainer;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/trainer")
@Consumes("application/json")
@Produces("application/json")
public class TrainerRestService {

    private static final Logger logger = LogManager.getLogger(TrainerRestService.class);
    private static final Response EMPTY = Response.status(200).build();


    @GET
    @Path("/list")
    public Response getTrainerList() {
        logger.debug("get trainer list");
        return EMPTY;
    }


    @GET
    @Path("/item/{id}")
    public Response getTrainerInfo(@PathParam("id") String trainerId) {
        logger.debug("get traiiner with id: " + trainerId);
        return EMPTY;
    }


    @DELETE
    @Path("/item/{id}")
    public Response removeTrainer(@PathParam("id") String trainerId) {
        logger.debug("remove trainer with id: " + trainerId);
        return EMPTY;
    }


    @PUT
    @Path("/item/new")
    public String addTrainer(Trainer trainer) {
        logger.debug("add new trainer");
        return trainer.getId();
    }

}
