package de.hsos.mocktail.Boundary.Resourceses;

import org.jboss.logging.Logger;

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

import org.eclipse.microprofile.faulttolerance.*;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.media.Content;



//TODO: add info and trace log
//TODO: add rety, timeout and fallback when nessesary

@Path("/mocktail/{id}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON) // multiple sachen möglich 
public class MocktailIDResource {

    // wenn privat dann gibts eine reflexion und das ist imperformant
    // damit entfernen wir acuh das new. Das new is blöd weil es die kopplung erhöht
    // braucht deshalb auch einen default konstruktor
    @Inject
    MocktailManager mocktailManager;

    @Inject
    Logger logTest;

    //fallback?
    @GET
    @Retry(
        maxRetries = 3
    )
    @Timeout(2500)
    @Operation(
        summary = "Gibt einen spezifischen Mocktail zurück",
        description = "Liefert den Mocktail mit der angegebenen ID. Im Fehlerfall wird die Anfrage bis zu " +
                     "dreimal wiederholt und nach 1,5 Sekunden abgebrochen, wenn keine Antwort erfolgt."
    )
    @APIResponses(value = {
        @APIResponse(
            responseCode = "200",
            description = "Erfolgreiche Operation",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON,
                schema = @Schema(implementation = Mocktail.class)
            )
        ),
        @APIResponse(
            responseCode = "404",
            description = "Mocktail nicht gefunden",
            content = @Content(mediaType = MediaType.TEXT_PLAIN)
        ),
        @APIResponse(
            responseCode = "408",
            description = "Timeout - Die Anfrage konnte nicht innerhalb des Zeitlimits abgeschlossen werden"
        ),
        @APIResponse(
            responseCode = "500",
            description = "Interner Serverfehler - Die Anfrage konnte trotz Wiederholungsversuchen nicht abgeschlossen werden"
        )
    })
    public Mocktail getMocktail(
            @PathParam("id") long mocktailID){
        logTest.info("GET /mocktail/" + mocktailID + ": Abrufen eines Mocktails");
        logTest.trace("Das ist ein Test");
        try {
            Mocktail mocktail = mocktailManager.getMocktail(mocktailID);
            if (mocktail != null) {
                logTest.info("GET /mocktail/" + mocktailID + ": Mocktail erfolgreich abgerufen");
            } else {
                logTest.warn("GET /mocktail/" + mocktailID + ": Mocktail nicht gefunden");
            }
            return mocktail;
        } catch (Exception e) {
            logTest.error("GET /mocktail/" + mocktailID + ": Fehler beim Abrufen des Mocktails", e);
            throw e;
        }      
    }

    // PUT
    @PUT
    @Retry(
        maxRetries = 2
    )
    @Timeout(2000)
    @Operation(
        summary = "Aktualisiert einen Mocktail",
        description = "Aktualisiert den Mocktail mit der angegebenen ID. Die Anfrage wird im Fehlerfall " +
                     "bis zu zweimal wiederholt und nach 2 Sekunden abgebrochen, wenn keine Antwort erfolgt."
    )
    @APIResponses(value = {
        @APIResponse(
            responseCode = "200",
            description = "Mocktail erfolgreich aktualisiert"
        ),
        @APIResponse(
            responseCode = "400",
            description = "Ungültige Anfrage - IDs stimmen nicht überein",
            content = @Content(mediaType = MediaType.TEXT_PLAIN)
        ),
        @APIResponse(
            responseCode = "404",
            description = "Mocktail nicht gefunden"
        ),
        @APIResponse(
            responseCode = "408",
            description = "Timeout - Die Anfrage konnte nicht innerhalb des Zeitlimits abgeschlossen werden"
        ),
        @APIResponse(
            responseCode = "500",
            description = "Interner Serverfehler - Die Anfrage konnte trotz Wiederholungsversuchen nicht abgeschlossen werden"
        )
    })
    public Response updateMocktail(
            @PathParam("id") long mocktailID, 
            @Schema(implementation = Mocktail.class)
            Mocktail mocktail) {
        logTest.info("PUT /mocktail/" + mocktailID + ": Versuch, Mocktail zu aktualisieren");
        
        try {
            if (mocktail.getId() != mocktailID) {
                logTest.warn("PUT /mocktail/" + mocktailID + ": ID-Diskrepanz - Pfad: " + mocktailID + ", Objekt: " + mocktail.getId());
                return Response.status(Status.BAD_REQUEST)
                        .entity("Die Mocktail-ID im Pfad und im Objekt stimmen nicht überein").build();
            }
            
            boolean updated = mocktailManager.updateMocktail(mocktail);
            if (updated) {
                logTest.info("PUT /mocktail/" + mocktailID + ": Mocktail erfolgreich aktualisiert");
                return Response.status(Status.OK).build();
            } else {
                logTest.warn("PUT /mocktail/" + mocktailID + ": Mocktail nicht gefunden");
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            logTest.error("PUT /mocktail/" + mocktailID + ": Fehler beim Aktualisieren des Mocktails", e);
            throw e;
        }
    }

    // DELETE 
    @DELETE
    @Retry(
        maxRetries = 1
    )
    @Operation(
        summary = "Löscht einen Mocktail",
        description = "Löscht den Mocktail mit der angegebenen ID. Ein Wiederholungsversuch wird im Fehlerfall " +
                     "durchgeführt und die Anfrage wird nach 1 Sekunde abgebrochen, wenn keine Antwort erfolgt."
    )
    @APIResponses(value = {
        @APIResponse(
            responseCode = "204",
            description = "Mocktail erfolgreich gelöscht"
        ),
        @APIResponse(
            responseCode = "404",
            description = "Mocktail nicht gefunden"
        ),
        @APIResponse(
            responseCode = "408",
            description = "Timeout - Die Anfrage konnte nicht innerhalb des Zeitlimits abgeschlossen werden"
        ),
        @APIResponse(
            responseCode = "500",
            description = "Interner Serverfehler - Die Anfrage konnte trotz Wiederholungsversuchen nicht abgeschlossen werden"
        )
    })
    public Response deleteMocktail(
            @PathParam("id") long mocktailID) {
        logTest.info("DELETE /mocktail/" + mocktailID + ": Versuch, Mocktail zu löschen");
        
        try {
            boolean deleted = mocktailManager.deleteMocktail(mocktailID);
            if (deleted) {
                logTest.info("DELETE /mocktail/" + mocktailID + ": Mocktail erfolgreich gelöscht");
                return Response.status(Status.NO_CONTENT).build();
            } else {
                logTest.warn("DELETE /mocktail/" + mocktailID + ": Mocktail nicht gefunden");
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            logTest.error("DELETE /mocktail/" + mocktailID + ": Fehler beim Löschen des Mocktails", e);
            throw e; 
        }
    }

}
