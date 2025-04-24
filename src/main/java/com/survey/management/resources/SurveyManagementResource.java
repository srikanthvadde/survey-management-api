package com.survey.management.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.survey.management.dtos.SurveyDataDto;
import com.survey.management.services.OciLoggingService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/surveys")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SurveyManagementResource {

    private static final Logger log = LoggerFactory.getLogger(SurveyManagementResource.class);

    private final OciLoggingService loggingService;
    private final ObjectMapper objectMapper;

    public SurveyManagementResource(OciLoggingService loggingService,ObjectMapper objectMapper) {
        this.loggingService = loggingService;
        this.objectMapper =  objectMapper;
    }

    @POST
    public Response receiveSurvey(SurveyDataDto survey) throws JsonProcessingException {
        log.info("Received survey: {}", survey);
        String payload = objectMapper.writeValueAsString(survey);
        try {
            loggingService.sendToOci(payload);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_GATEWAY)
                    .entity("Failed to log to OCI: " + e.getMessage())
                    .build();
        }
        return Response.ok("Survey logged successfully").build();
    }
}
