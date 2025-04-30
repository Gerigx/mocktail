package de.hsos.mocktail.Controller;

import java.util.ArrayList;
import java.util.List;

import de.hsos.mocktail.Boundary.dto.CreateMocktailDTO;
import de.hsos.mocktail.Enitity.Mocktail;
import de.hsos.mocktail.Enitity.MocktailKatalog;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

// quasie wie ein singelton bloß das ein proxy erstellt wird vorher und der scheduler reciht das rum
// ichh kann auch rquestScoped drasu amchen dann wird es nur während der request genutzt
// also application scoped ist gut bei sehr vielen nutzungen
// request bei seltenerer nutzung und wenn das system zustandlos sein soll
@ApplicationScoped
public class MocktailService implements MocktailManager {

    // achte auf qualifier
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
