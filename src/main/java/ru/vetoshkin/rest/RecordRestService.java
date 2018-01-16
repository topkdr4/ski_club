package ru.vetoshkin.rest;
import ru.vetoshkin.core.SystemException;
import ru.vetoshkin.service.RecordService;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
@Path("/record")
@Consumes({ APPLICATION_JSON, APPLICATION_FORM_URLENCODED })
@Produces(APPLICATION_JSON)
public class RecordRestService {


    @GET
    @Path("/jump/{sex}")
    public SimpleResponse getJumpRecord(@PathParam("sex") boolean sex) throws SystemException {
        SimpleResponse response = new SimpleResponse();
        response.setResult(RecordService.getJump(sex));
        return response;
    }


    @GET
    @Path("/judge/{sex}")
    public SimpleResponse getJudgeRecord(@PathParam("sex") boolean sex) throws SystemException {
        SimpleResponse response = new SimpleResponse();
        response.setResult(RecordService.getJudge(sex));
        return response;
    }


    @GET
    @Path("/wind/{sex}")
    public SimpleResponse getWindRecord(@PathParam("sex") boolean sex) throws SystemException {
        SimpleResponse response = new SimpleResponse();
        response.setResult(RecordService.getWind(sex));
        return response;
    }


    @GET
    @Path("/compensation/{sex}")
    public SimpleResponse getCompensationRecord(@PathParam("sex") boolean sex) throws SystemException {
        SimpleResponse response = new SimpleResponse();
        response.setResult(RecordService.getCompensation(sex));
        return response;
    }


    @GET
    @Path("/sum/{sex}")
    public SimpleResponse getSumRecords(@PathParam("sex") boolean sex) throws SystemException {
        SimpleResponse response = new SimpleResponse();
        response.setResult(RecordService.getSum(sex));
        return response;
    }

}
