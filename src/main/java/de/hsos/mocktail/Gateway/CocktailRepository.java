package de.hsos.mocktail.Gateway;

public class CocktailRepository implements CocktailCatalog {
    
    /*@RestClient
    CocktailRestClient cocktailRestClient;*/

    @Inject
    AnotherCocktailRestClient cocktailRestClient;

    @Override
    public List<Recipe> getAllRecipes(Optional<String> name, Optional<String> recipeIngredient) {
        return cocktailRestClient.getCocktails(name.orElse(""))
                .stream()
                .filter(cocktail -> recipeIngredient.isEmpty() || cocktail.getIngredients().stream()
                        .anyMatch(recipeIngredient.get()::equalsIgnoreCase))
                .map(cocktail -> new Recipe(-1, cocktail.getStrDrink(), IntStream.range(0, cocktail.getIngredients().size())
                        .mapToObj(i -> new RecipeIngredient(cocktail.getIngredients().get(i), cocktail.getMeasures().get(i)))
                        .filter(ingredient -> !ingredient.getName().isEmpty() && ingredient.getName() != null && !ingredient.getName().equals("null"))
                        .toList(), RecipeCategory.COCKTAIL))
                .toList();
    }
    // https://stackoverflow.com/questions/18552005/is-there-a-concise-way-to-iterate-over-a-stream-with-indices-in-java-8

}
