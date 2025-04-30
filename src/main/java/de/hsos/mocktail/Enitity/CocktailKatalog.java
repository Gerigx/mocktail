package de.hsos.mocktail.Enitity;

import java.util.List;
import java.util.Optional;

public interface CocktailKatalog {
    List<Mocktail> getAllMocktails(Optional<String> name, Optional<String> recipeIngredient);
}
