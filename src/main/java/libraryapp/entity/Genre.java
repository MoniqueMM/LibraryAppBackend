package libraryapp.entity;

import com.fasterxml.jackson.annotation.JsonValue;
public enum Genre {
    FANTASY("Fantastyka"),
    SCI_FI("Sci-Fi"),
    ROMANCE("Romans"),
    HISTORICAL_NOVEL("Powieść historyczna"),
    HORROR("Horror"),
    CRIME_NOVEL("Kryminał"),
    THRILLER("Thriller"),
    BIOGRAPHY("Biografia"),
    REPORTAGE("Reportaż"),
    YOUTH_NOVEL("Powieść młodieżowa"),
    TRAVELOG("Książka podróżnicza"),
    COOKBOOK("Książka kucharska"),
    GUIDE("Poradnik")
    ;
    private final String genre;

    Genre(String genre) {
        this.genre = genre;
    }
@JsonValue
    public String getGenre() {
        return genre;
    }
}
