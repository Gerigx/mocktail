package de.hsos.mocktail.Gateway.acl;

import jakarta.json.JsonValue;
import jakarta.json.bind.serializer.DeserializationContext;
import jakarta.json.bind.serializer.JsonbDeserializer;
import jakarta.json.stream.JsonParser;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.stream.Stream;

public class CocktailDTODeserializer implements JsonbDeserializer<CocktailDTO> {
    @Override
    public CocktailDTO deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
        CocktailDTO cocktailDTO = new CocktailDTO();

        Stream<Map.Entry<String, JsonValue>> objectStream = parser.getObjectStream();

        objectStream.forEach(entry -> {
            String key = entry.getKey();
            JsonValue value = entry.getValue();
            switch (key) {
                case "strDrink" -> cocktailDTO.setStrDrink(value.toString().replace("\"", ""));
                case "strIngredient1" -> cocktailDTO.setStrIngredient1(value.toString().replace("\"", ""));
                case "strIngredient2" -> cocktailDTO.setStrIngredient2(value.toString().replace("\"", ""));
                case "strIngredient3" -> cocktailDTO.setStrIngredient3(value.toString().replace("\"", ""));
                case "strIngredient4" -> cocktailDTO.setStrIngredient4(value.toString().replace("\"", ""));
                case "strIngredient5" -> cocktailDTO.setStrIngredient5(value.toString().replace("\"", ""));
                case "strIngredient6" -> cocktailDTO.setStrIngredient6(value.toString().replace("\"", ""));
                case "strIngredient7" -> cocktailDTO.setStrIngredient7(value.toString().replace("\"", ""));
                case "strIngredient8" -> cocktailDTO.setStrIngredient8(value.toString().replace("\"", ""));
                case "strIngredient9" -> cocktailDTO.setStrIngredient9(value.toString().replace("\"", ""));
                case "strIngredient10" -> cocktailDTO.setStrIngredient10(value.toString().replace("\"", ""));
                case "strIngredient11" -> cocktailDTO.setStrIngredient11(value.toString().replace("\"", ""));
                case "strIngredient12" -> cocktailDTO.setStrIngredient12(value.toString().replace("\"", ""));
                case "strIngredient13" -> cocktailDTO.setStrIngredient13(value.toString().replace("\"", ""));
                case "strIngredient14" -> cocktailDTO.setStrIngredient14(value.toString().replace("\"", ""));
                case "strIngredient15" -> cocktailDTO.setStrIngredient15(value.toString().replace("\"", ""));
                case "strMeasure1" -> cocktailDTO.setStrMeasure1(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
                case "strMeasure2" -> cocktailDTO.setStrMeasure2(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
                case "strMeasure3" -> cocktailDTO.setStrMeasure3(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
                case "strMeasure4" -> cocktailDTO.setStrMeasure4(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
                case "strMeasure5" -> cocktailDTO.setStrMeasure5(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
                case "strMeasure6" -> cocktailDTO.setStrMeasure6(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
                case "strMeasure7" -> cocktailDTO.setStrMeasure7(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
                case "strMeasure8" -> cocktailDTO.setStrMeasure8(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
                case "strMeasure9" -> cocktailDTO.setStrMeasure9(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
                case "strMeasure10" -> cocktailDTO.setStrMeasure10(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
                case "strMeasure11" -> cocktailDTO.setStrMeasure11(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
                case "strMeasure12" -> cocktailDTO.setStrMeasure12(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
                case "strMeasure13" -> cocktailDTO.setStrMeasure13(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
                case "strMeasure14" -> cocktailDTO.setStrMeasure14(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
                case "strMeasure15" -> cocktailDTO.setStrMeasure15(value.toString().replace("\"", "").replaceAll("^null$", "No quantity specified"));
            }
        });
        return cocktailDTO;
    }

}
