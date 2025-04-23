package de.hsos.mocktail.Boundary.dto;

import java.util.ArrayList;
import java.util.List;

import de.hsos.mocktail.Enitity.Zutat;

public class CreateMocktailDTO {
    private String name;
    private String beschreibung;
    private List<Zutat> zutaten;
    private String ersteller; 

    public CreateMocktailDTO(){
        zutaten = new ArrayList<>();
    }

    public CreateMocktailDTO(String name, String beschreibung, List<Zutat> zutaten, String ersteller) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.zutaten = zutaten;
        this.ersteller = ersteller;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public List<Zutat> getZutaten() {
        return zutaten;
    }

    public String getErsteller() {
        return ersteller;
    }

    public void setErsteller(String ersteller) {
        this.ersteller = ersteller;
    }


}
