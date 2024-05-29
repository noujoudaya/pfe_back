package sir.zproject.pfe_back.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import sir.zproject.pfe_back.enumeration.ModePaiement;

import java.io.IOException;

public class ModePaiementDeserializer extends JsonDeserializer<ModePaiement> {
    @Override
    public ModePaiement deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String modePaiementString = jsonParser.getText().toUpperCase(); // Convert to uppercase to handle case insensitivity
        for (ModePaiement modePaiement : ModePaiement.values()) {
            if (modePaiement.getLabel().toUpperCase().equals(modePaiementString)) {
                return modePaiement;
            }
        }
        throw new IllegalArgumentException("Invalid designation: " + modePaiementString);
    }
}