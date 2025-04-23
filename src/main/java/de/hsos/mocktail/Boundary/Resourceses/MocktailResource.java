package de.hsos.mocktail.Boundary.Resourceses;

import java.util.ArrayList;
import java.util.List;

import de.hsos.mocktail.Boundary.dto.CreateMocktailDTO;
import de.hsos.mocktail.Controller.MocktailManager;
import de.hsos.mocktail.Enitity.Mocktail;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/Mocktail")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MocktailResource {

    @Inject
    MocktailManager mocktailManager;

    // get

    @GET
    public List<Mocktail> getAllMocktails(){
        List<Mocktail> mocktails = new ArrayList<>();

        mocktails.addAll(mocktailManager.getAllMocktails());

        return mocktails;
    }

    // post

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMocktail(CreateMocktailDTO mocktailDTO) {
        boolean success = mocktailManager.createMocktail(mocktailDTO);
        if (success) {
            return Response.status(Status.CREATED).build();
        } else {
            return Response.status(Status.BAD_REQUEST).build();
        }
    }
}
