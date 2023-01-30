package libraryapp.dto;


import libraryapp.entity.Genre;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class BookDtoIn {

    private String title;
    private Set<UUID> authorsId;
    private Long isbn;
    private Long quantity;
    private LocalDate releaseDate;
    private Set<Genre> genres;


}
