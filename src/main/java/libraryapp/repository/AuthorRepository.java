package libraryapp.repository;

import libraryapp.entity.Author;
import libraryapp.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
    Optional<Author> findByName(String name);

    //Query
    List<Author> findAuthorByGenres(Genre genre);
}
