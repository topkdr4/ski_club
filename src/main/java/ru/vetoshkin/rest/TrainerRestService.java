package ru.vetoshkin.rest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vetoshkin.bean.Trainer;
import ru.vetoshkin.core.SystemException;
import ru.vetoshkin.service.TrainerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;





@Path("/trainer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TrainerRestService {

    private static final Logger logger = LogManager.getLogger(TrainerRestService.class);
    private static final Response EMPTY = Response.status(200).build();


    @GET
    @Path("/list")
    public SimpleResponse getTrainerList() throws SystemException {
        logger.debug("get trainer list");
        SimpleResponse response = new SimpleResponse();
        response.setResult(TrainerService.getAllTrainers());
        return response;
    }


    @GET
    @Path("/list/{from}/{to}")
    public SimpleResponse getTrainerListRange(@PathParam("from") int from, @PathParam("to") int to) throws SystemException {
        logger.debug("get trainer list range");
        SimpleResponse response = new SimpleResponse();
        response.setResult(TrainerService.getTrainers(from, to));
        return response;
    }


    @GET
    @Path("/list/count")
    public SimpleResponse getTrainersCount() throws SystemException {
        logger.debug("get trainers count");
        SimpleResponse response = new SimpleResponse();
        response.setResult(TrainerService.getAllTrainersCount());
        return response;
    }


    @GET
    @Path("/get")
    public Trainer getTrainerInfo(IdentityRequest request) throws SystemException {
        logger.info(request == null);
        logger.debug("get trainer with id: " + request.getId());
        return TrainerService.getTrainer(request.getId());
    }


    @DELETE
    @Path("/remove")
    public Response removeTrainer(IdentityRequest request) {
        logger.debug("remove trainer with id: " + request.getId());
        TrainerService.removeTrainer(request.getId());
        return EMPTY;
    }


    @PUT
    @Path("/save")
    public Trainer addTrainer(Trainer trainer) throws SystemException {
        logger.debug("save trainer");
        TrainerService.saveTrainer(trainer);
        return trainer;
    }

}
