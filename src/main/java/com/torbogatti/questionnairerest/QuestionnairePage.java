package com.torbogatti.questionnairerest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.torbogatti.questionnairerest.model.Questionnaire;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/questionnaire")
public class QuestionnairePage {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTemplate() throws JsonProcessingException {
        Questionnaire questionnaire = new Questionnaire();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(questionnaire);
        return Response.ok(json).build();
    }
}
