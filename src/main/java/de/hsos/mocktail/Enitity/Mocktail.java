package de.hsos.mocktail.Enitity;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import de.hsos.mocktail.Enitity.Zutat;

public class Mocktail {

    private long id;
    private String name;
    private String beschreibung;
    private final List<Zutat> zutaten;
    private String ersteller; 

    public Mocktail(long id, String name, String beschreibung, List<Zutat> zutaten, String ersteller ){
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
        this.zutaten = zutaten;
        this.ersteller = ersteller;
    }

    public long getId() {
        return id;
    }



    public void setId(long id) {
        this.id = id;
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



    public String getErsteller() {
        return ersteller;
    }



    public void setErsteller(String ersteller) {
        this.ersteller = ersteller;
    }

    // Zutaten

    public void fügeZutatHinzu(Zutat zutat){
        zutaten.add(zutat);
    }

    public List<Zutat> getZutaten(){
        return Collections.unmodifiableList(zutaten);
    }

}
