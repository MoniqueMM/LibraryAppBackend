package libraryapp.mapper;

import libraryapp.dto.AuthorForBooksDtoOut;
import libraryapp.entity.Author;



public class AuthorMapper {

    public static AuthorForBooksDtoOut mapToAuthorForBooksDtoOut(Author author){
        return AuthorForBooksDtoOut.builder()
                .id(author.getId())
                .name(author.getName())
                .genres(author.getGenres())
                .dateOfBirth(author.getDateOfBirth())
                .rating(author.getRating())
                .build();
    }
}
