package de.hsos.mocktail.Controller;

import java.util.List;
import java.util.Optional;

import de.hsos.mocktail.Enitity.Mocktail;

public interface CocktailManager {
    List<Mocktail> getAllMocktails(Optional<String> name, Optional<String> zutat);

}
