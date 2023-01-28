package libraryapp.controller;


import libraryapp.dto.AuthorDto;
import libraryapp.entity.Author;
import libraryapp.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/author")
public class AuthorApiController {
    private final AuthorService authorService;


    public AuthorApiController(AuthorService authorService) {
        this.authorService = authorService;
    }



    @GetMapping
    List<Author> getAuthors(){
        return authorService.getAuthor();
    }

    @GetMapping("{id}")
    public Optional<Author> getAuthorById( @PathVariable UUID id){
        return authorService.getAuthorById(id);
    }

    @GetMapping("{name}")
    public Optional<Author>getAuthorByName(@PathVariable String name){
        return authorService.getAuthorByName(name);
    }

    @PostMapping
    public Author addAuthor(@RequestBody AuthorDto authorDto){
        return authorService.addAuthor(authorDto);
    }


    @PutMapping("{id}")
    public Author updateAuthor(@PathVariable UUID id, @RequestBody AuthorDto authorDto){
        return authorService.updateAuthor(id, authorDto);
    }


    @DeleteMapping
    public void deleteAuthor(@RequestParam UUID id){
        authorService.deleteById(id);
    }


}
