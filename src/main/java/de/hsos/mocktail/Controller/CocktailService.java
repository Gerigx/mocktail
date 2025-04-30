package de.hsos.mocktail.Controller;

import java.util.List;
import java.util.Optional;

import de.hsos.mocktail.Enitity.Mocktail;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import de.hsos.mocktail.Enitity.CocktailKatalog;

@ApplicationScoped
public class CocktailService implements CocktailManager {

    @Inject
    CocktailKatalog cocktailKatalog;

    @Override
    public List<Mocktail> getAllMocktails(Optional<String> name, Optional<String> zutat) {
        // TODO Auto-generated method stub
        return cocktailKatalog.getAllMocktails(name, zutat);
    }


}
