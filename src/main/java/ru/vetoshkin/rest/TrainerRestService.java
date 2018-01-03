package ru.vetoshkin.rest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vetoshkin.bean.Trainer;
import ru.vetoshkin.core.HikariPool;
import ru.vetoshkin.core.SystemException;
import ru.vetoshkin.service.TrainerService;
import ru.vetoshkin.util.Jackson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;





@Path("/trainer")
@Consumes("application/json")
@Produces("application/json")
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
    @Path("/get")
    public Trainer getTrainerInfo(IdentityRequest request) throws SystemException {
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


    public static void main(String[] args) throws Exception {
        HikariPool.init();
        String json = "{\"family\":\"Фамилия\",\"name\":\"Имя\",\"qualification\":\"ТОп\",\"dayOfBirth\":\"2018-01-24\",\"id\": null}";
        Trainer trainer = Jackson.toObject(json);

        System.out.println(trainer);
        System.out.println(Jackson.toJson(trainer));
        TrainerService.saveTrainer(trainer);
        System.out.println(
                trainer.getId()
        );
    }

}
