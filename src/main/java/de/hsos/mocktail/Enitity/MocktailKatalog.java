package de.hsos.mocktail.Enitity;

import java.util.List;

import de.hsos.mocktail.Boundary.dto.CreateMocktailDTO;

public interface MocktailKatalog {
    Mocktail getMocktail(long id);
    List<Mocktail> getAllMocktails();

    boolean createMocktail(CreateMocktailDTO mocktail);

    boolean updateMocktail(Mocktail mocktail);

    boolean deleteMocktail(long id);
}
