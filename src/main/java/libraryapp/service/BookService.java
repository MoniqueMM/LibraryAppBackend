package libraryapp.service;

import libraryapp.dto.BookDto;
import libraryapp.entity.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {

    Book add(BookDto newBook);
    Optional<Book> findByTitle(String title);
    Optional<Book> findById(UUID bookId);
    List<Book> findByAuthorId(UUID authorId);
    void deleteById(UUID bookId);


}
