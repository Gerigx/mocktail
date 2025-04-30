package de.hsos.mocktail.Boundary.Resourceses;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import de.hsos.mocktail.Boundary.dto.CreateMocktailDTO;
import de.hsos.mocktail.Controller.CocktailManager;
import de.hsos.mocktail.Controller.MocktailManager;
import de.hsos.mocktail.Enitity.Mocktail;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.media.*;
import org.eclipse.microprofile.openapi.annotations.media.Content;

@Path("/Mocktail")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Mocktail Collection", description = "Operationen zur Verwaltung aller Mocktails")
public class MocktailResource {

    @Inject
    MocktailManager mocktailManager;

    @Inject
    Logger log;

    // get

    @GET
    @Retry(
        maxRetries = 3
    )
    @Timeout(2000)
    @Operation(
        summary = "Gibt alle Mocktails zurück",
        description = "Liefert eine Liste aller verfügbaren Mocktails in der Datenbank. " +
                     "Diese Operation unterstützt Retry-Mechanismen bei Fehlern und hat ein Timeout."
    )
    @APIResponses(value = {
        @APIResponse(
            responseCode = "200",
            description = "Erfolgreiche Operation",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON
            )
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
    public List<Mocktail> getAllMocktails(){
        log.info("GET /Mocktail: Abrufen aller Mocktails");
        List<Mocktail> mocktails = new ArrayList<>();

        try {
            mocktails.addAll(mocktailManager.getAllMocktails());
            log.info("GET /Mocktail: " + mocktails.size() + " Mocktails erfolgreich abgerufen");
        } catch (Exception e) {
            log.error("GET /Mocktail: Fehler beim Abrufen der Mocktails", e);
            throw e;
        }

        return mocktails;
    }

    // post

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Retry(
        maxRetries = 2
    )
    @Timeout(3000)
    @Operation(
        summary = "Erstellt einen neuen Mocktail",
        description = "Erstellt einen neuen Mocktail basierend auf den bereitgestellten Daten. " +
                     "Die Operation wird bis zu zweimal wiederholt, wenn ein Fehler auftritt, " +
                     "und bricht nach 3 Sekunden ab, wenn keine Antwort erfolgt."
    )
    @APIResponses(value = {
        @APIResponse(
            responseCode = "201",
            description = "Mocktail erfolgreich erstellt"
        ),
        @APIResponse(
            responseCode = "400",
            description = "Ungültige Anfrage - Die bereitgestellten Daten sind ungültig"
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
    public Response createMocktail(
            @Schema(
                description = "DTO zur Erstellung eines neuen Mocktails", 
                required = true, 
                implementation = CreateMocktailDTO.class
            ) 
            CreateMocktailDTO mocktailDTO) {
        log.info("POST /Mocktail: Versuch, einen neuen Mocktail zu erstellen: " + mocktailDTO.getName());
        
        try {
            boolean success = mocktailManager.createMocktail(mocktailDTO);
            if (success) {
                log.info("POST /Mocktail: Mocktail erfolgreich erstellt: " + mocktailDTO.getName());
                return Response.status(Status.CREATED).build();
            } else {
                log.warn("POST /Mocktail: Mocktail konnte nicht erstellt werden: " + mocktailDTO.getName());
                return Response.status(Status.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            log.error("POST /Mocktail: Fehler beim Erstellen des Mocktails", e);
            throw e;
        }
    }

    @Inject
    CocktailManager cocktailManager; // Falls noch nicht vorhanden

    @GET
    @Path("/api-test")
    public List<Mocktail> testCocktailAPI(@QueryParam("name") String name) {
        Optional<String> nameOpt = name != null ? Optional.of(name) : Optional.of("margarita");
        Optional<String> ingredient = Optional.empty();
        return cocktailManager.getAllMocktails(nameOpt, ingredient);
    }
}
