package sir.zproject.pfe_back.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import sir.zproject.pfe_back.enumeration.SITUATION_FAMILIALE;

import java.io.IOException;

public class SituationFamilialeDeserializer extends JsonDeserializer<SITUATION_FAMILIALE> {
    @Override
    public SITUATION_FAMILIALE deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String situationString = jsonParser.getText().toUpperCase(); // Convert to uppercase to handle case insensitivity
        for (SITUATION_FAMILIALE situation : SITUATION_FAMILIALE.values()) {
            if (situation.getLabel().toUpperCase().equals(situationString)) {
                return situation;
            }
        }
        throw new IllegalArgumentException("Invalid situation: " + situationString);
    }
}