package com.torbogatti.questionnairerest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.torbogatti.questionnairerest.model.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;

import java.util.HashMap;

@Path("/user")
public class PersonalDataPage {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(Object requestEntity) throws JsonProcessingException {
        HashMap<String, Object> mapper;
        mapper = (HashMap<String, Object>) requestEntity;
        User user = new ObjectMapper().convertValue(mapper, User.class);
        String json = new ObjectMapper().writeValueAsString(user);
        return Response.ok(json).build();
    }
}
