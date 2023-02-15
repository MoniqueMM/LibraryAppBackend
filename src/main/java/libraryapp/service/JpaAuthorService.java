package libraryapp.service;

import libraryapp.dto.AuthorDtoIn;
import libraryapp.entity.Author;
import libraryapp.entity.Genre;
import libraryapp.repository.AuthorRepository;
import libraryapp.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class JpaAuthorService implements AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public JpaAuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(UUID id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public List<Author> getAuthorByRating() {
        return bookRepository.getAuthorRating ;
    }

    @Override
    public List<Author> findByGenre(Genre genre) {
        return authorRepository.findAuthorByGenre(genre);
    }

    @Override
    public Author addAuthor(AuthorDtoIn authorDtoIn) {
        Author author = Author.builder()
                .name(authorDtoIn.getName())
                .dateOfBirth(authorDtoIn.getDateOfBirth())
                .books(Set.of())
                .genres(authorDtoIn.getGenres())
                .rating(0.0)
                .build();
        return authorRepository.save(author);
    }

    @Override// dodanie książek
    public Author updateAuthor(UUID id, AuthorDtoIn authorDtoIn) {
        Author author = authorRepository.findById(id).get();
        author.setName(authorDtoIn.getName());
        author.setGenres(authorDtoIn.getGenres());
        author.setDateOfBirth(authorDtoIn.getDateOfBirth());
        return authorRepository.save(author);
    }

    //TODO
    // zmiana raitingu autora

    @Override
    public void deleteById(UUID id) {
        authorRepository.deleteById(id);

    }
}
