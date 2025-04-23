package de.hsos.mocktail.Boundary.Resourceses;

import de.hsos.mocktail.Controller.MocktailManager;
import de.hsos.mocktail.Enitity.Mocktail;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/mocktail/{id}")
public class MocktailIDResource {

    @Inject
    MocktailManager mocktailManager;

    @GET
    public Mocktail getMocktail(@PathParam("id") long mocktailID){
        return mocktailManager.getMocktail(mocktailID);
    }

}
