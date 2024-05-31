package com.torbogatti.questionnairerest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;

@Path("/home")
public class PresentationPage {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response home(){
        JSONObject jo = new JSONObject();
        jo.put("title", "Questionnaire");
        jo.put("description", "This is a presentation page");
        return Response.status(200).entity(jo.toString()).build();
    }
}
