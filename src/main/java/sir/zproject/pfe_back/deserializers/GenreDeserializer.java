package sir.zproject.pfe_back.deserializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import sir.zproject.pfe_back.enumeration.GENRE;

import java.io.IOException;

public class GenreDeserializer  extends JsonDeserializer<GENRE> {
    @Override
    public GENRE deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String genreString = jsonParser.getText().toUpperCase(); // Convert to uppercase to handle case insensitivity
        for (GENRE genre : GENRE.values()) {
            if (genre.getLabel().toUpperCase().equals(genreString)) {
                return genre;
            }
        }
        throw new IllegalArgumentException("Invalid situation: " + genreString);
    }
}
