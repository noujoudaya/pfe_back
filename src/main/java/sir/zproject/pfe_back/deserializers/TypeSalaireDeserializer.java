package sir.zproject.pfe_back.deserializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import sir.zproject.pfe_back.enumeration.TYPE_SALAIRE;

import java.io.IOException;

public class TypeSalaireDeserializer extends JsonDeserializer<TYPE_SALAIRE> {
    @Override
    public TYPE_SALAIRE deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String typeString = jsonParser.getText().toUpperCase(); // Convert to uppercase to handle case insensitivity
        for (TYPE_SALAIRE type : TYPE_SALAIRE.values()) {
            if (type.getLabel().toUpperCase().equals(typeString)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid situation: " + typeString);
    }
}
