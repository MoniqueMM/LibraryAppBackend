package libraryapp.controller;

import libraryapp.dto.BookDto;
import libraryapp.entity.Book;
import libraryapp.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("")
    public ResponseEntity<Book> add( @RequestBody @Validated BookDto bookDto){
        final Book book = bookService.add(bookDto);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable UUID id){
        return ResponseEntity.of(bookService.findById(id));
    }
    @GetMapping("/{title}")
    public ResponseEntity<Book> findByTitle(@PathVariable String title){
        return ResponseEntity.of(bookService.findByTitle(title));
    }
    @GetMapping("")
    public List<Book> findByAuthorId(@RequestParam UUID authorId){
        return bookService.findByAuthorId(authorId);
    }
    @DeleteMapping("")
    public void deleteById (@RequestParam UUID bookId){
        bookService.deleteById(bookId);
    }
    @PatchMapping("/{bookId}")
    public void updateQuantity(@PathVariable UUID bookId, @RequestParam Long quantity){
        bookService.updateQuantity(bookId, quantity);
    }
    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }
}
