package de.hsos.mocktail.Enitity;

import java.util.Objects;

public record Zutat(
    String name,
    double menge,
    String einheit,
    String hinweis
) {
    

    // orintiert an https://www.infoq.com/articles/exploring-java-records/
    public Zutat {
        Objects.requireNonNull(name, "Name darf nicht null sein");
        if (menge <= 0) {
            throw new IllegalArgumentException("Menge muss größer als 0 sein");
        }
        Objects.requireNonNull(einheit, "Einheit darf nicht null sein");
    }
        

    public boolean istFlüssigkeit() {
        return einheit.equalsIgnoreCase("ml") || 
               einheit.equalsIgnoreCase("l");
    }
}