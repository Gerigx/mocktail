package de.hsos.mocktail.Gateway;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import de.hsos.mocktail.Enitity.CocktailKatalog;
import de.hsos.mocktail.Enitity.Mocktail;
import de.hsos.mocktail.Enitity.MocktailKategorie;
import de.hsos.mocktail.Enitity.Zutat;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CocktailRepository implements CocktailKatalog {
    
    /*@RestClient
    CocktailRestClient cocktailRestClient;*/

    @Inject
    TestCocktailRestClient cocktailRestClient;


        // stack overlfow und mit claude lesbarere gemacht: https://stackoverflow.com/questions/18552005/is-there-a-concise-way-to-iterate-over-a-stream-with-indices-in-java-8
    @Override
    public List<Mocktail> getAllMocktails(Optional<String> name, Optional<String> recipeIngredient) {
        return cocktailRestClient.getCocktails(name.orElse(""))
                .stream()
                .filter(cocktail -> recipeIngredient.isEmpty() || cocktail.getIngredients().stream()
                        .anyMatch(recipeIngredient.get()::equalsIgnoreCase))
                .map(cocktail -> new Mocktail(
                    -1, 
                    cocktail.getStrDrink(),
                    "", // Keine Beschreibung verfügbar aus der API
                    IntStream.range(0, Math.min(cocktail.getIngredients().size(), cocktail.getMeasures().size()))
                        .mapToObj(i -> new Zutat(
                            cocktail.getIngredients().get(i),
                            1.0, // Standardmenge, da die Umrechnung hier komplex wäre
                            "Portion", // Standardeinheit
                            cocktail.getMeasures().get(i) // Verwende Measure als Hinweis
                        ))
                        .filter(zutat -> !zutat.name().isEmpty() && zutat.name() != null && !zutat.name().equals("null"))
                        .toList(), 
                    "", // Kein Ersteller verfügbar aus der API
                    MocktailKategorie.COCKTAIL
                ))
                .toList();
    }

}
