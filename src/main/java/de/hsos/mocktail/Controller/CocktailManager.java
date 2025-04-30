package de.hsos.mocktail.Controller;

public interface CocktailManager {
    List<Recipe> getAllRecipes(Optional<String> name, Optional<String> recipeIngredient);

}
