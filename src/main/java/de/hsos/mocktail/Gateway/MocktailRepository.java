package de.hsos.mocktail.Gateway;

import java.util.ArrayList;
import java.util.List;
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
