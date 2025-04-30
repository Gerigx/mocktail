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

import java.util.List;

public class TestCocktailRestClient {
    public List<CocktailDTO> getCocktails(String searchName) {
        String versionNr = "v1";
        String pathName = "/1/search.php";

        Client restClient = ClientBuilder.newClient();
        WebTarget target = restClient.target("https://www.thecocktaildb.com/api/json/")
                .path(versionNr)
                .path(pathName)
                .queryParam("s", searchName);



        Response response = target.request().accept(MediaType.APPLICATION_JSON).get();

        List<CocktailDTO> cocktails = null;
        try {
            CocktailResponseDTO cocktailResponse = response.readEntity(CocktailResponseDTO.class);
            cocktails = cocktailResponse.getDrinks();
        } catch (ProcessingException e) {
            
            return List.of();
        }

        response.close();
        restClient.close();

        return cocktails;
    }

}
