package sir.zproject.pfe_back.deserializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import sir.zproject.pfe_back.enumeration.TypeContrat;

import java.io.IOException;

public class TypeContratDeserializer extends JsonDeserializer<TypeContrat> {
    @Override
    public TypeContrat deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String typeString = jsonParser.getText().toUpperCase(); // Convert to uppercase to handle case insensitivity
        for (TypeContrat type : TypeContrat.values()) {
            if (type.getLabel().toUpperCase().equals(typeString)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid situation: " + typeString);
    }
}
