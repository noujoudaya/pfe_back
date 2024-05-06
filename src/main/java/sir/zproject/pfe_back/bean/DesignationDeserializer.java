package sir.zproject.pfe_back.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import sir.zproject.pfe_back.enumeration.DESIGNATION;

import java.io.IOException;


public class DesignationDeserializer extends JsonDeserializer<DESIGNATION> {
    @Override
    public DESIGNATION deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String designationString = jsonParser.getText().toUpperCase(); // Convert to uppercase to handle case insensitivity
        for (DESIGNATION designation : DESIGNATION.values()) {
            if (designation.getLabel().toUpperCase().equals(designationString)) {
                return designation;
            }
        }
        throw new IllegalArgumentException("Invalid designation: " + designationString);
    }
}
