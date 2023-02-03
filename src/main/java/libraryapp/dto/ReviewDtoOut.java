package libraryapp.dto;

import libraryapp.entity.Book;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
public class ReviewDtoOut {

    private UUID userId;
    private LocalDate date;
    private String content;
    private Double rating;
    private Book book;

}
