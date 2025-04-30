package de.hsos.mocktail.Enitity;

public interface CocktailKatalog {
    List<Recipe> getAllRecipes(Optional<String> name, Optional<String> recipeIngredient);
}
