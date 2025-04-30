package de.hsos.mocktail.Gateway;

public class CocktailRestClient {
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
