package de.hsos.mocktail.Gateway;


import de.hsos.mocktail.Gateway.acl.CocktailDTO;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey = "cocktailAPI")
public interface CocktailRestClient {
    @GET
    @Path("/search.php")
    List<CocktailDTO> getCocktails(@QueryParam("s") String searchName);
}
