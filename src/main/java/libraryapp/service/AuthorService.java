package libraryapp.service;

import libraryapp.dto.AuthorDtoIn;
import libraryapp.entity.Author;
import libraryapp.entity.Genre;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorService {

    List<Author> getAuthors();
    Optional<Author> getAuthorById(UUID id);
    Optional<Author> getAuthorByName(String name);
    List<Author> findByGenres(Genre genre);
    Author addAuthor(AuthorDtoIn authorDtoIn);
    Author updateAuthor(UUID id, AuthorDtoIn authorDtoIn);
    void deleteById(UUID id);

    // update author rating


}
