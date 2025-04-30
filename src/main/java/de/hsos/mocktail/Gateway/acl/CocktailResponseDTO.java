package de.hsos.mocktail.Gateway.acl;

import java.util.List;

public class CocktailResponseDTO {
    private List<CocktailDTO> drinks;

    public List<CocktailDTO> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<CocktailDTO> drinks) {
        this.drinks = drinks;
    }

}
