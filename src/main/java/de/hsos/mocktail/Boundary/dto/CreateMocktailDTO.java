package de.hsos.mocktail.Boundary.dto;

import java.util.ArrayList;
import java.util.List;

import de.hsos.mocktail.Enitity.MocktailKategorie;
import de.hsos.mocktail.Enitity.Zutat;

public class CreateMocktailDTO {
    private String name;
    private String beschreibung;
    private List<Zutat> zutaten;
    private String ersteller; 
    private MocktailKategorie mocktailKategorie;



    public CreateMocktailDTO(){
        zutaten = new ArrayList<>();
    }

    public CreateMocktailDTO(String name, String beschreibung, List<Zutat> zutaten, String ersteller, MocktailKategorie mocktailKategorie) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.zutaten = zutaten;
        this.ersteller = ersteller;
        this.mocktailKategorie = mocktailKategorie;

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

    public MocktailKategorie getMocktailKategorie() {
        return mocktailKategorie;
    }

    public void setMocktailKategorie(MocktailKategorie mocktailKategorie) {
        this.mocktailKategorie = mocktailKategorie;
    }


}
