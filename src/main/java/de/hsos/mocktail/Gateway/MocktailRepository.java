package de.hsos.mocktail.Gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import de.hsos.mocktail.Boundary.dto.CreateMocktailDTO;
import de.hsos.mocktail.Enitity.Mocktail;
import de.hsos.mocktail.Enitity.MocktailKatalog;
import de.hsos.mocktail.Enitity.MocktailKategorie;
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
        // Mocktail 1: Trockener Mund
        List<Zutat> zutatenTrocken = new ArrayList<>();
        zutatenTrocken.add(new Zutat("Sand", 10.0, "l", "Feinkörnig"));
        zutatenTrocken.add(new Zutat("Wodka", 5.0, "l", "Hochprozentig"));

        CreateMocktailDTO trocken = new CreateMocktailDTO(
            "Trockener Mund",
            "Verursacht Sodbrennen",
            zutatenTrocken,
            "Tom und Oli",
            MocktailKategorie.MOCKTAIL
        );
        createMocktail(trocken);
        
        // Mocktail 2: Elden Mische
        List<Zutat> zutatenElden = new ArrayList<>();
        zutatenElden.add(new Zutat("Alkohol", 1.0, "l", "Viel"));
        zutatenElden.add(new Zutat("Kreuz", 1.0, "Stück", ""));
        zutatenElden.add(new Zutat("Quees", 2.0, "Stück", ""));
        zutatenElden.add(new Zutat("Unbekannte Zutat", 0.5, "l", "Kann mich nicht mehr erinnern"));
        zutatenElden.add(new Zutat("Wilder Kram", 3.0, "l", "War definitiv wild"));

        CreateMocktailDTO elden = new CreateMocktailDTO(
            "Elden Mische",
            "Nur für den Fürst",
            zutatenElden,
            "Oli (kinda alki oder so)",
            MocktailKategorie.MOCKTAIL
        );
        createMocktail(elden);
        
        // Mocktail 3: Gottlose Kreation
        List<Zutat> zutatenGottlos = new ArrayList<>();
        zutatenGottlos.add(new Zutat("Energydrink", 1.0, "l", "Abgelaufen"));
        zutatenGottlos.add(new Zutat("Ketchup", 250.0, "ml", "Mit extra Zucker"));
        zutatenGottlos.add(new Zutat("Mayonnaise", 100.0, "ml", "Die scharfe Variante"));
        zutatenGottlos.add(new Zutat("Essiggurken-Saft", 200.0, "ml", "Aus dem Glas"));
        zutatenGottlos.add(new Zutat("Crushed Ice", 300.0, "g", "Muss sein für die Optik"));
        zutatenGottlos.add(new Zutat("Dosenthunfisch-Öl", 30.0, "ml", "Am besten 2 Wochen offen"));

        CreateMocktailDTO gottlos = new CreateMocktailDTO(
            "Der Gottlose",
            "Trink das und du kommst garantiert in die Hölle. Oder ins Krankenhaus. Oder beides.",
            zutatenGottlos,
            "Das Chaos persönlich",
            MocktailKategorie.MOCKTAIL
        );
        createMocktail(gottlos);
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
                                            mocktail.getErsteller(),
                                            mocktail.getMocktailKategorie());
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
