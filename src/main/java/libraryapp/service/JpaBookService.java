package libraryapp.service;

import libraryapp.dto.BookDto;
import libraryapp.entity.Author;
import libraryapp.entity.Book;
import libraryapp.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                .rating(0.0)
                .genres(newBook.getGenres())
                .build();
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

    @Override
    public void updateQuantity(UUID bookId, Long quantity) {
        Optional<Book> bookToBeUpdated = bookRepository.findById(bookId);
        if(bookToBeUpdated.isPresent()){
            Book book = bookToBeUpdated.get();
            book.setQuantity(quantity);
            bookRepository.save(book);
        }
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

}
