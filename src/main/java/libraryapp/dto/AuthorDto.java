package libraryapp.dto;

import jakarta.validation.constraints.NotNull;
import libraryapp.entity.Genre;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class AuthorDto {

    @NotNull
    private String name;

    private UUID bookId;

    private LocalDate dateOfBirth;

    private Set<Genre> genres;
}
