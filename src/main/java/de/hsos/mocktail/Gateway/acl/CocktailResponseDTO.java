package de.hsos.mocktail.Gateway.acl;

import java.util.ArrayList;
import java.util.List;

public class CocktailResponseDTO {
    private List<CocktailDTO> drinks;

    public List<CocktailDTO> getDrinks() {
        return drinks != null ? drinks : new ArrayList<>();
    }

    public void setDrinks(List<CocktailDTO> drinks) {
        this.drinks = drinks;
    }
}