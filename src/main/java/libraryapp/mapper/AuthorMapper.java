package libraryapp.mapper;

import libraryapp.dto.AuthorDtoOut;
import libraryapp.dto.AuthorWithoutBooksDtoOut;
import libraryapp.entity.Author;

import java.util.HashSet;


public class AuthorMapper {

    public static AuthorWithoutBooksDtoOut mapToAuthorForBooksDtoOut(Author author){
        return AuthorWithoutBooksDtoOut.builder()
                .id(author.getId())
                .name(author.getName())
                .genres(author.getGenres())
                .dateOfBirth(author.getDateOfBirth())
                .rating(author.getRating())
                .build();
    }

    public static AuthorDtoOut mapAuthorDtoOut (Author author){
        return AuthorDtoOut.builder()
                .id(author.getId())
                .name(author.getName())
                .dateOfBirth(author.getDateOfBirth())
                .books(author.getBooks())
                .genres(new HashSet<>(author.getGenres()))
                .rating(author.getRating())
                .build();
    }
}
