package de.hsos.mocktail.Gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import de.hsos.mocktail.Boundary.dto.CreateMocktailDTO;
import de.hsos.mocktail.Enitity.Mocktail;
import de.hsos.mocktail.Enitity.MocktailKatalog;
import de.hsos.mocktail.Enitity.Zutat;
import jakarta.inject.Singleton;

@Singleton
public class MocktailRepository implements MocktailKatalog{
    private long idCounter = 0;
    ConcurrentMap<Long, Mocktail> mocktails; //threadsicher

    public MocktailRepository(){
        mocktails = new ConcurrentHashMap<>();

        initDemoMocktails();
    }

    private void initDemoMocktails() {
        // Mocktail 1: Very Summery
        List<Zutat> zutatenSummery = new ArrayList<>();
        zutatenSummery.add(new Zutat("Erdbeerpüree", 30.0, "ml", "Frisch püriert"));
        zutatenSummery.add(new Zutat("Zitronensaft", 20.0, "ml", "Frisch gepresst"));
        zutatenSummery.add(new Zutat("Zuckersirup", 15.0, "ml", ""));
        zutatenSummery.add(new Zutat("Mineralwasser", 150.0, "ml", "Mit Kohlensäure"));
        zutatenSummery.add(new Zutat("Minzblätter", 5.0, "Stück", "Zum Garnieren"));
        zutatenSummery.add(new Zutat("Eiswürfel", 6.0, "Stück", ""));

        CreateMocktailDTO summery = new CreateMocktailDTO(
            "Very Summery",
            "Ein erfrischender Sommerdrink mit Erdbeeren und Minze - perfekt für heiße Tage.",
            zutatenSummery,
            "Team Quarkus"
        );
        createMocktail(summery);
        
        // Mocktail 2: Ginger Lemony
        List<Zutat> zutatenGinger = new ArrayList<>();
        zutatenGinger.add(new Zutat("Ingwer", 20.0, "g", "Frisch gerieben"));
        zutatenGinger.add(new Zutat("Zitronensaft", 30.0, "ml", "Frisch gepresst"));
        zutatenGinger.add(new Zutat("Honig", 15.0, "ml", "Flüssig"));
        zutatenGinger.add(new Zutat("Orangensaft", 100.0, "ml", "Frisch gepresst"));
        zutatenGinger.add(new Zutat("Mineralwasser", 100.0, "ml", "Mit Kohlensäure"));
        zutatenGinger.add(new Zutat("Eiswürfel", 5.0, "Stück", ""));
        zutatenGinger.add(new Zutat("Zitronenscheibe", 1.0, "Stück", "Zum Garnieren"));

        CreateMocktailDTO ginger = new CreateMocktailDTO(
            "Ginger Lemony",
            "Ein würziger Mocktail mit Ingwer und Zitrusfrüchten, der den Stoffwechsel anregt.",
            zutatenGinger,
            "Mocktail-Meister"
        );
        createMocktail(ginger);
        
        // Mocktail 3: Tropical Paradise
        List<Zutat> zutatenTropical = new ArrayList<>();
        zutatenTropical.add(new Zutat("Ananassaft", 100.0, "ml", "Frisch gepresst"));
        zutatenTropical.add(new Zutat("Kokosmilch", 50.0, "ml", ""));
        zutatenTropical.add(new Zutat("Bananenmark", 30.0, "ml", "Frisch püriert"));
        zutatenTropical.add(new Zutat("Limettensaft", 10.0, "ml", "Frisch gepresst"));
        zutatenTropical.add(new Zutat("Agavendicksaft", 15.0, "ml", ""));
        zutatenTropical.add(new Zutat("Crushed Ice", 100.0, "g", ""));
        zutatenTropical.add(new Zutat("Ananasscheibe", 1.0, "Stück", "Zum Garnieren"));

        CreateMocktailDTO tropical = new CreateMocktailDTO(
            "Tropical Paradise",
            "Ein cremiger Mocktail mit exotischen Früchten, der dich gedanklich an den Strand versetzt.",
            zutatenTropical,
            "Quarkus-Cocktail-Bar"
        );
        createMocktail(tropical);
    }


    @Override
    public Mocktail getMocktail(long id) {
        return mocktails.get(id);
    }

    @Override
    public List<Mocktail> getAllMocktails() {
        return new ArrayList<>(mocktails.values());
    }
    @Override
    public boolean createMocktail(CreateMocktailDTO mocktail) {
        try {
            Mocktail newMocktail = new Mocktail(idCounter++, 
                                            mocktail.getName(), 
                                            mocktail.getBeschreibung(), 
                                            mocktail.getZutaten(), 
                                            mocktail.getErsteller());
        mocktails.put(newMocktail.getId(), newMocktail);

        return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public boolean updateMocktail(Mocktail mocktail) {
        if (!mocktails.containsKey(mocktail.getId())) {
            return false;
        }
        mocktails.put(mocktail.getId(), mocktail);
        return true;

    }
    @Override
    public boolean deleteMocktail(long id) {
        // TODO Auto-generated method stub
        return mocktails.remove(id) != null;
    }



}
