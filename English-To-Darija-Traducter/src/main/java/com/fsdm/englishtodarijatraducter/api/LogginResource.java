package com.fsdm.englishtodarijatraducter.api;


import com.fsdm.englishtodarijatraducter.SecurityConfiguration.BasicAuthFilter;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.io.*;

@Path("/signUp")
public class LogginResource {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public boolean signUp(@QueryParam("username") String username , @QueryParam("password") String password) throws IOException {
        File f = new File("password.pwd");
        Writer writer = new FileWriter(f);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        System.out.println(username+":"+password);
        System.out.println(f.getAbsolutePath());
        bufferedWriter.write(username+":"+password);
        bufferedWriter.close();
        writer.close();
        return true;
    }
}
