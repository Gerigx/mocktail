package de.hsos.mocktail.Controller;

import java.util.ArrayList;
import java.util.List;

import de.hsos.mocktail.Boundary.dto.CreateMocktailDTO;
import de.hsos.mocktail.Enitity.Mocktail;
import de.hsos.mocktail.Enitity.MocktailKatalog;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MocktailService implements MocktailManager {

    @Inject
    MocktailKatalog mocktailKatalog;
    

    @Override
    public boolean createMocktail(CreateMocktailDTO mocktail) {
        return mocktailKatalog.createMocktail(mocktail);
    }

    @Override
    public boolean deleteMocktail(long mocktailID) {
        return mocktailKatalog.deleteMocktail(mocktailID);
    }

    @Override
    public Mocktail getMocktail(long mocktailID) {
        return mocktailKatalog.getMocktail(mocktailID);
    }

    @Override
    public List<Mocktail> getAllMocktails() {
        List<Mocktail> mocktails = new ArrayList<>();
        mocktails.addAll(mocktailKatalog.getAllMocktails());

        return mocktails;
    }

    @Override
    public boolean updateMocktail(Mocktail mocktail) {
        return mocktailKatalog.updateMocktail(mocktail);
    }

}
