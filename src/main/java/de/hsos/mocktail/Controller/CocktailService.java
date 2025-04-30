package de.hsos.mocktail.Controller;

@ApplicationScoped
public class CocktailService implements CocktailManager {

    @Inject
    CocktailCatalog cocktailCatalog;

    @Override
    public List<Recipe> getAllRecipes(Optional<String> name, Optional<String> recipeIngredient) {
        return cocktailCatalog.getAllRecipes(name, recipeIngredient);
    }
}
