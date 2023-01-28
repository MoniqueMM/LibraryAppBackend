package libraryapp.repository;

import libraryapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    List<Book> findBookByAuthor_Id(UUID authorId);
    Optional<Book> findBookByTitle(String title);

}
