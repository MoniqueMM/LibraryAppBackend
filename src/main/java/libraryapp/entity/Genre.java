package libraryapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Genre {
    FANTASY("Fantasy");
    private final String genre;

    Genre(String genre) {
        this.genre = genre;
    }
@JsonValue
    public String getGenre() {
        return genre;
    }
}
