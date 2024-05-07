package sir.zproject.pfe_back.deserializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import sir.zproject.pfe_back.enumeration.StatutEmploye;

import java.io.IOException;

public class StatutEmployeDeserialize extends JsonDeserializer<StatutEmploye> {
    @Override
    public StatutEmploye deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String statutString = jsonParser.getText().toUpperCase(); // Convert to uppercase to handle case insensitivity
        for (StatutEmploye statut : StatutEmploye.values()) {
            if (statut.getLabel().toUpperCase().equals(statutString)) {
                return statut;
            }
        }
        throw new IllegalArgumentException("Invalid situation: " + statutString);
    }
}

