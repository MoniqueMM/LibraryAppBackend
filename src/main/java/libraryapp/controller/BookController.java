package libraryapp.controller;

import libraryapp.dto.BookDto;
import libraryapp.entity.Book;
import libraryapp.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("")
    public ResponseEntity add( @RequestBody BookDto customerDto){
        final Book book = bookService.add(customerDto);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable UUID id){
        return ResponseEntity.of(bookService.findById(id));
    }


}
