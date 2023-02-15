package libraryapp.repository;

import libraryapp.entity.Author;
import libraryapp.entity.Book;
import libraryapp.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    Optional<Book> findBookByTitle(String title);
    @Query("select b from Book b where :genre in elements(b.genres)")
    List<Book> findBookByGenre(@Param("genre") Genre genre);
    @Query("select b from Book b where :authorId in elements(b.author)")
    List<Book> findBookByAuthor(@Param("authorId") UUID authorId);

    @Query("select avg(r.rating) from Book as r where :authorId in elements(r.author)")
    List<Author> getAuthorRating (@Param("id") UUID authorId);
}
