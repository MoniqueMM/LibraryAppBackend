package libraryapp.repository;

import libraryapp.entity.Author;
import libraryapp.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
    Optional<Author> findByName(String name);

    Optional<Author>findById(UUID id);
    @Query("select a from Author a where :genre in elements(a.genres) ")
    List<Author> findAuthorByGenre(Genre genre);
}
