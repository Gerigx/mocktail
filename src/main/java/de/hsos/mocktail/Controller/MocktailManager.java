package de.hsos.mocktail.Controller;

import java.util.List;

import de.hsos.mocktail.Boundary.dto.CreateMocktailDTO;
import de.hsos.mocktail.Enitity.Mocktail;
import de.hsos.mocktail.Enitity.Zutat;

public interface MocktailManager {

    boolean createMocktail(CreateMocktailDTO mocktail);
    boolean deleteMocktail(long mocktailID);

    Mocktail getMocktail(long mocktailID);
    List<Mocktail> getAllMocktails();

    boolean updateMocktail(Mocktail mocktail);

    // to dto
    // from dto, dtos should be cleared in the control layer/ boundary
}
