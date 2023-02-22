package libraryapp.dto;

import libraryapp.entity.Genre;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class AuthorDtoIn {


    private String name;
    private LocalDate dateOfBirth;
    private Set<UUID> bookId;
    private Set<Genre> genres;
    private String description;
}
