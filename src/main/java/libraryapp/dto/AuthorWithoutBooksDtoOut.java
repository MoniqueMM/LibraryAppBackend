package libraryapp.dto;


import libraryapp.entity.Genre;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class AuthorWithoutBooksDtoOut {

    private UUID id;
    private String name;
    private LocalDate dateOfBirth;
    private Set<Genre> genres ;
    private Double rating;
}
