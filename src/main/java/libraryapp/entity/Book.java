package libraryapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String title;
    private Author author;
    private Long isbn;
    private Long quantity;
    private Set<Review> reviews= new HashSet<>();
    private LocalDate releaseDate;
    private Set<Genre> genres = new HashSet<>();
    private Double rating;
}
