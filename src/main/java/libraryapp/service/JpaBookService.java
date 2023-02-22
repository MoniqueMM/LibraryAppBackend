package libraryapp.service;

import libraryapp.dto.BookDtoIn;
import libraryapp.entity.Author;
import libraryapp.entity.Book;
import libraryapp.entity.Genre;
import libraryapp.repository.BookRepository;
import libraryapp.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JpaBookService implements BookService{

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book add(BookDtoIn newBook) {
        Book book = Book.builder()
                .title(newBook.getTitle())
                .author(Set.of())
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
        return bookRepository.findBookByAuthor(authorId);
    }

    @Override
    public void deleteById(UUID bookId) {
        bookRepository.deleteById(bookId);
    }


    @Override
    public List<Book> findByGenre(Genre genre) {
        return bookRepository.findBookByGenre(genre);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    @Override
    public List<Book> topThreeBook (){
        List<Book> list=bookRepository.findAll();
        return   list.stream()
                .sorted(Comparator.comparing(Book::getRating).reversed())
                .limit(3)
                .collect(Collectors.toList());

    }
}
