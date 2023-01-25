package libraryapp.dto;

import libraryapp.entity.Genre;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class BookDto {

    private String title;
    private UUID authorId;
    private long isbn;
    private long quantity;
    private LocalDate releaseDate;
    private Set<Genre> genres;

}
