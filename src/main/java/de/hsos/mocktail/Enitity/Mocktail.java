package de.hsos.mocktail.Enitity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;


import de.hsos.mocktail.Enitity.Zutat;

@Schema(name="Moktail", discription="Ein Mocktail")
public class Mocktail {

    @NotBlank
    @Schema(description = "Eindeutige ID des Mocktails", required = true, example = "1")
    private long id;
    
    @NotBlank
    @Schema(description = "Name des Mocktails", required = true, example = "Virgin Mojito")
    private String name;
    
    @Schema(description = "Beschreibung des Mocktails", example = "Erfrischender alkoholfreier Mojito mit Limette und Minze")
    private String beschreibung;
    
    @NotBlank
    @Schema(description = "Liste aller Zutaten des Mocktails")
    private List<Zutat> zutaten;
    
    @Schema(description = "Name des Erstellers des Mocktails", example = "Max Mustermann")
    private String ersteller; 
    public Mocktail(){
        zutaten = new ArrayList<>();
    }

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
