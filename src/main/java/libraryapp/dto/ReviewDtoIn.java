package libraryapp.dto;

import libraryapp.entity.Book;
import libraryapp.entity.UserApp;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDtoIn {

    private UserApp user;
    private String content;
    private Double rating;
    private Book book;

}
