package libraryapp.entity;

import com.fasterxml.jackson.annotation.JsonValue;
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
