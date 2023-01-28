package libraryapp.dto;

import jakarta.validation.constraints.NotNull;
import libraryapp.entity.Genre;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class BookDto {

    @NotNull(message = "Title is required")
    @Length(max = 255)
    private String title;
//    @NotNull(message = "Author had to exist in order to write this book")
    private UUID authorId;
    @NotNull(message = "This number is important")
    @Length(max = 20)
    private Long isbn;
    @NotNull
    private Long quantity;
    @NotNull(message = "Book was released one day")
    private LocalDate releaseDate;
    private Set<Genre> genres;

}
