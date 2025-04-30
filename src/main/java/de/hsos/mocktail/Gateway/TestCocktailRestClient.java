package de.hsos.mocktail.Gateway;

import de.hsos.mocktail.Gateway.acl.CocktailDTO;
import de.hsos.mocktail.Gateway.acl.CocktailResponseDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ProcessingException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import org.jboss.logging.Logger;

@ApplicationScoped
public class TestCocktailRestClient {
    
    private static final Logger log = Logger.getLogger(TestCocktailRestClient.class);
    
    public List<CocktailDTO> getCocktails(String searchName) {
        String versionNr = "v1";
        String pathName = "/1/search.php";

        log.info("Rufe externe Cocktail-API auf mit Suchbegriff: " + searchName);
        
        Client restClient = null;
        Response response = null;
        List<CocktailDTO> cocktails = new ArrayList<>();
        
        try {
            restClient = ClientBuilder.newClient();
            WebTarget target = restClient.target("https://www.thecocktaildb.com/api/json/")
                    .path(versionNr)
                    .path(pathName)
                    .queryParam("s", searchName);

            log.debug("API-Anfrage-URL: " + target.getUri().toString());
            
            response = target.request().accept(MediaType.APPLICATION_JSON).get();
            
            if (response.getStatus() == 200) {
                CocktailResponseDTO cocktailResponse = response.readEntity(CocktailResponseDTO.class);
                cocktails = cocktailResponse.getDrinks();
                log.info("API-Antwort erfolgreich verarbeitet, " + cocktails.size() + " Cocktails abgerufen");
            } else {
                log.warn("API antwortete mit Status: " + response.getStatus());
            }
            
        } catch (ProcessingException e) {
            log.error("Fehler beim Aufrufen der Cocktail-API", e);
        } catch (Exception e) {
            log.error("Unerwarteter Fehler", e);
        } finally {
            if (response != null) {
                response.close();
            }
            if (restClient != null) {
                restClient.close();
            }
        }

        return cocktails;
    }
}