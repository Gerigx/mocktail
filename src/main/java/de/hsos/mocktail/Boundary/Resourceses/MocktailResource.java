package de.hsos.mocktail.Boundary.Resourceses;

import java.util.ArrayList;
import java.util.List;

import de.hsos.mocktail.Controller.MocktailManager;
import de.hsos.mocktail.Enitity.Mocktail;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/Mocktail")
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

}
