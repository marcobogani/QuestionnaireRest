package com.torbogatti.questionnairerest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.torbogatti.questionnairerest.csv.CSVHandler;
import com.torbogatti.questionnairerest.model.Answer;
import com.torbogatti.questionnairerest.model.Submission;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/submission")
public class SubmissionPage {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubmissionList(@QueryParam("is_risk") Optional<Boolean> is_risk) throws IOException {
        Boolean isRisk = is_risk.orElse(null);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Submission> submissions = CSVHandler.getSubmissionsByRisk(isRisk);
        String res = objectMapper.writeValueAsString(submissions);

        return Response.ok(res).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response submitQuestionnaire(Object requestEntity) throws IOException {
        HashMap<String, Object> mapper;
        mapper = (HashMap<String, Object>) requestEntity;

        Submission sub = new ObjectMapper().convertValue(mapper, Submission.class);
        sub.setUuid(UUID.randomUUID());

        int yesCounter = 0;
        for (Answer answer : sub.getAnswers()) {
            if (answer.getText().equals("yes")) {
                yesCounter++;
            }
        }
        boolean inRisk = (yesCounter > sub.getAnswers().length / 2);
        sub.setRisk(inRisk);

        JSONObject response = new JSONObject();
        response.put("uuid", sub.getUuid());
        response.put("score", inRisk ? "You will be called back by phone for additional analysis" : "You are ok!");

        CSVHandler.appendSubmissionToCsv(sub);

        return Response.ok().entity(response.toString()).build();
    }
}
