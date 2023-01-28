package libraryapp.service;

import libraryapp.dto.AuthorDto;
import libraryapp.entity.Author;
import libraryapp.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthor() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(UUID id) {
        return authorRepository.findById(id);
    }

    public Optional<Author> getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    public Author addAuthor(AuthorDto authorDto) {
        Author author = Author.builder()
                .name(authorDto.getName())
                .dateOfBirth(authorDto.getDateOfBirth())
                .genres(authorDto.getGenres())
                .build();
        return authorRepository.save(author);
    }

    public Author updateAuthor(UUID id, AuthorDto authorDto) {
        Author author = authorRepository.findById(id).get();
        author.setName(authorDto.getName());
        author.setGenres(authorDto.getGenres());
        return authorRepository.save(author);
    }

    public void deleteById(UUID id) {
        authorRepository.deleteById(id);

    }
}
