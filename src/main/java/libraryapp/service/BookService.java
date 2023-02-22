package libraryapp.service;

import libraryapp.dto.BookDtoIn;
import libraryapp.entity.Book;
import libraryapp.entity.Genre;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {

    Book add(BookDtoIn newBook);
    Optional<Book> findByTitle(String title);
    Optional<Book> findById(UUID bookId);
    List<Book> findByAuthorId(UUID authorId);
    void deleteById(UUID bookId);
//    void updateQuantity(UUID bookId,Long quantity);
    List<Book> findByGenre(Genre genre);
    List<Book> findAll();

    List<Book> topThreeBook();

}
