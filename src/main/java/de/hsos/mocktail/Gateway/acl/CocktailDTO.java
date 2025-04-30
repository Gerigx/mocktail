package de.hsos.mocktail.Gateway.acl;

import jakarta.json.bind.annotation.JsonbTypeDeserializer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@JsonbTypeDeserializer(value = CocktailDTODeserializer.class)
public class CocktailDTO {
    private String strDrink;

    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;
    private String strIngredient7;
    private String strIngredient8;
    private String strIngredient9;
    private String strIngredient10;
    private String strIngredient11;
    private String strIngredient12;
    private String strIngredient13;
    private String strIngredient14;
    private String strIngredient15;

    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;
    private String strMeasure11;
    private String strMeasure12;
    private String strMeasure13;
    private String strMeasure14;
    private String strMeasure15;

    public CocktailDTO() {

    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public void setStrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public void setStrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }

    public String getStrIngredient6() {
        return strIngredient6;
    }

    public void setStrIngredient6(String strIngredient6) {
        this.strIngredient6 = strIngredient6;
    }

    public String getStrIngredient7() {
        return strIngredient7;
    }

    public void setStrIngredient7(String strIngredient7) {
        this.strIngredient7 = strIngredient7;
    }

    public String getStrIngredient8() {
        return strIngredient8;
    }

    public void setStrIngredient8(String strIngredient8) {
        this.strIngredient8 = strIngredient8;
    }

    public String getStrIngredient9() {
        return strIngredient9;
    }

    public void setStrIngredient9(String strIngredient9) {
        this.strIngredient9 = strIngredient9;
    }

    public String getStrIngredient10() {
        return strIngredient10;
    }

    public void setStrIngredient10(String strIngredient10) {
        this.strIngredient10 = strIngredient10;
    }

    public String getStrIngredient11() {
        return strIngredient11;
    }

    public void setStrIngredient11(String strIngredient11) {
        this.strIngredient11 = strIngredient11;
    }

    public String getStrIngredient12() {
        return strIngredient12;
    }

    public void setStrIngredient12(String strIngredient12) {
        this.strIngredient12 = strIngredient12;
    }

    public String getStrIngredient13() {
        return strIngredient13;
    }

    public void setStrIngredient13(String strIngredient13) {
        this.strIngredient13 = strIngredient13;
    }

    public String getStrIngredient14() {
        return strIngredient14;
    }

    public void setStrIngredient14(String strIngredient14) {
        this.strIngredient14 = strIngredient14;
    }

    public String getStrIngredient15() {
        return strIngredient15;
    }

    public void setStrIngredient15(String strIngredient15) {
        this.strIngredient15 = strIngredient15;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public void setStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public void setStrMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }

    public void setStrMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
    }

    public String getStrMeasure4() {
        return strMeasure4;
    }

    public void setStrMeasure4(String strMeasure4) {
        this.strMeasure4 = strMeasure4;
    }

    public String getStrMeasure5() {
        return strMeasure5;
    }

    public void setStrMeasure5(String strMeasure5) {
        this.strMeasure5 = strMeasure5;
    }

    public String getStrMeasure6() {
        return strMeasure6;
    }

    public void setStrMeasure6(String strMeasure6) {
        this.strMeasure6 = strMeasure6;
    }

    public String getStrMeasure7() {
        return strMeasure7;
    }

    public void setStrMeasure7(String strMeasure7) {
        this.strMeasure7 = strMeasure7;
    }

    public String getStrMeasure8() {
        return strMeasure8;
    }

    public void setStrMeasure8(String strMeasure8) {
        this.strMeasure8 = strMeasure8;
    }

    public String getStrMeasure9() {
        return strMeasure9;
    }

    public void setStrMeasure9(String strMeasure9) {
        this.strMeasure9 = strMeasure9;
    }

    public String getStrMeasure10() {
        return strMeasure10;
    }

    public void setStrMeasure10(String strMeasure10) {
        this.strMeasure10 = strMeasure10;
    }

    public String getStrMeasure11() {
        return strMeasure11;
    }

    public void setStrMeasure11(String strMeasure11) {
        this.strMeasure11 = strMeasure11;
    }

    public String getStrMeasure12() {
        return strMeasure12;
    }

    public void setStrMeasure12(String strMeasure12) {
        this.strMeasure12 = strMeasure12;
    }

    public String getStrMeasure13() {
        return strMeasure13;
    }

    public void setStrMeasure13(String strMeasure13) {
        this.strMeasure13 = strMeasure13;
    }

    public String getStrMeasure14() {
        return strMeasure14;
    }

    public void setStrMeasure14(String strMeasure14) {
        this.strMeasure14 = strMeasure14;
    }

    public String getStrMeasure15() {
        return strMeasure15;
    }

    public void setStrMeasure15(String strMeasure15) {
        this.strMeasure15 = strMeasure15;
    }

    public List<String> getIngredients() {
        // Verwende eine ArrayList statt List.of(), um null-Werte zu vermeiden
        List<String> ingredients = new ArrayList<>();
        
        // Füge jedes nicht-leere Ingredient zur Liste hinzu
        if (strIngredient1 != null && !strIngredient1.isBlank()) ingredients.add(strIngredient1);
        if (strIngredient2 != null && !strIngredient2.isBlank()) ingredients.add(strIngredient2);
        if (strIngredient3 != null && !strIngredient3.isBlank()) ingredients.add(strIngredient3);
        if (strIngredient4 != null && !strIngredient4.isBlank()) ingredients.add(strIngredient4);
        if (strIngredient5 != null && !strIngredient5.isBlank()) ingredients.add(strIngredient5);
        if (strIngredient6 != null && !strIngredient6.isBlank()) ingredients.add(strIngredient6);
        if (strIngredient7 != null && !strIngredient7.isBlank()) ingredients.add(strIngredient7);
        if (strIngredient8 != null && !strIngredient8.isBlank()) ingredients.add(strIngredient8);
        if (strIngredient9 != null && !strIngredient9.isBlank()) ingredients.add(strIngredient9);
        if (strIngredient10 != null && !strIngredient10.isBlank()) ingredients.add(strIngredient10);
        if (strIngredient11 != null && !strIngredient11.isBlank()) ingredients.add(strIngredient11);
        if (strIngredient12 != null && !strIngredient12.isBlank()) ingredients.add(strIngredient12);
        if (strIngredient13 != null && !strIngredient13.isBlank()) ingredients.add(strIngredient13);
        if (strIngredient14 != null && !strIngredient14.isBlank()) ingredients.add(strIngredient14);
        if (strIngredient15 != null && !strIngredient15.isBlank()) ingredients.add(strIngredient15);
        
        return ingredients;
    }

    public List<String> getMeasures() {
        // Wie bei Ingredients, verwende eine ArrayList
        List<String> measures = new ArrayList<>();
        
        // Füge jedes nicht-leere Measure zur Liste hinzu
        if (strMeasure1 != null && !strMeasure1.isBlank()) measures.add(strMeasure1);
        if (strMeasure2 != null && !strMeasure2.isBlank()) measures.add(strMeasure2);
        if (strMeasure3 != null && !strMeasure3.isBlank()) measures.add(strMeasure3);
        if (strMeasure4 != null && !strMeasure4.isBlank()) measures.add(strMeasure4);
        if (strMeasure5 != null && !strMeasure5.isBlank()) measures.add(strMeasure5);
        if (strMeasure6 != null && !strMeasure6.isBlank()) measures.add(strMeasure6);
        if (strMeasure7 != null && !strMeasure7.isBlank()) measures.add(strMeasure7);
        if (strMeasure8 != null && !strMeasure8.isBlank()) measures.add(strMeasure8);
        if (strMeasure9 != null && !strMeasure9.isBlank()) measures.add(strMeasure9);
        if (strMeasure10 != null && !strMeasure10.isBlank()) measures.add(strMeasure10);
        if (strMeasure11 != null && !strMeasure11.isBlank()) measures.add(strMeasure11);
        if (strMeasure12 != null && !strMeasure12.isBlank()) measures.add(strMeasure12);
        if (strMeasure13 != null && !strMeasure13.isBlank()) measures.add(strMeasure13);
        if (strMeasure14 != null && !strMeasure14.isBlank()) measures.add(strMeasure14);
        if (strMeasure15 != null && !strMeasure15.isBlank()) measures.add(strMeasure15);
        
        return measures;
    }
}