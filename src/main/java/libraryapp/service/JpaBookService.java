package libraryapp.service;

import libraryapp.dto.BookDto;
import libraryapp.entity.Author;
import libraryapp.entity.Book;
import libraryapp.entity.Genre;
import libraryapp.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
@Service
public class JpaBookService implements BookService{

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book add(BookDto newBook) {
        Book book = Book.builder()
                .author(Author.builder()
                        .id(newBook.getAuthorId())
                        .build())
                .title(newBook.getTitle())
                .isbn(newBook.getIsbn())
                .releaseDate(newBook.getReleaseDate())
                .quantity(newBook.getQuantity())
                .rating(0)
                .genres(newBook.getGenres())
                .build();
        //TODO
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }

    @Override
    public Optional<Book> findById(UUID bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public List<Book> findByAuthorId(UUID authorId) {
        return bookRepository.findBookByAuthor_Id(authorId);
    }

    @Override
    public void deleteById(UUID bookId) {
        bookRepository.deleteById(bookId);
    }
}
