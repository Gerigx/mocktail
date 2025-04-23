package de.hsos.mocktail.Boundary.Resourceses;

import de.hsos.mocktail.Controller.MocktailManager;
import de.hsos.mocktail.Enitity.Mocktail;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/mocktail/{id}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MocktailIDResource {

    @Inject
    MocktailManager mocktailManager;

    @GET
    public Mocktail getMocktail(@PathParam("id") long mocktailID){
        return mocktailManager.getMocktail(mocktailID);
    }

    // PUT
    @PUT
    public Response updateMocktail(@PathParam("id") long mocktailID, Mocktail mocktail) {
        if (mocktail.getId() != mocktailID) {
            return Response.status(Status.BAD_REQUEST)
                    .entity("Die Mocktail-ID im Pfad und im Objekt stimmen nicht überein").build();
        }
        
        boolean updated = mocktailManager.updateMocktail(mocktail);
        if (updated) {
            return Response.status(Status.OK).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    // DELETE 
    @DELETE
    public Response deleteMocktail(@PathParam("id") long mocktailID) {
        boolean deleted = mocktailManager.deleteMocktail(mocktailID);
        if (deleted) {
            return Response.status(Status.NO_CONTENT).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

}
