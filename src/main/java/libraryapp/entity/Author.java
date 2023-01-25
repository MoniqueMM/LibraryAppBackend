package libraryapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;
import java.util.UUID;
@Builder
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private LocalDate DateOfBirth;
    private Set<Book> books = new HashSet<>();
    private Set<Genre> genres = new HashSet<>();
    private float rating;
}
