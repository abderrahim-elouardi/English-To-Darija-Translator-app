package com.fsdm.englishtodarijatraducter.api;

import com.fsdm.englishtodarijatraducter.dto.ResponseTextToDarija;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.ws.rs.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.StringReader;

@Path("/translate")
public class TranslateResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseTextToDarija toDarija(@QueryParam("originalText") String originalText , @QueryParam("language") String language ) {
        System.out.println("converting started!!!!!!!!");
        Client client = ClientBuilder.newClient();

        String jsonBody = """
    {
        "model": "tngtech/deepseek-r1t2-chimera:free",
        "messages": [
            {
                "role": "system",
                "content": "You are a translation tool. Translate this text in %s to Moroccan Darija using Arabic letters. Output ONLY the translated text."
            },
            {
                "role": "user",
                "content": "%s"
            }
        ]
    }
    """.formatted(originalText,language);

        System.out.println(jsonBody);

        Response response = client.target("https://openrouter.ai/api/v1/chat/completions")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer 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") // Ta clé ici
                .post(Entity.entity(jsonBody, MediaType.APPLICATION_JSON));

        String resultat = response.readEntity(String.class);
        System.out.println(resultat);
        JsonReader jsonReader = Json.createReader(new StringReader(resultat));
        JsonObject root = jsonReader.readObject();

        ResponseTextToDarija rtd = new ResponseTextToDarija();
        rtd.setDarijaText(root.getJsonArray("choices")
                .getJsonObject(0)
                .getJsonObject("message")
                .getString("content"));
        rtd.setOriginalText(originalText);
        client.close();
        return rtd;
    }
}