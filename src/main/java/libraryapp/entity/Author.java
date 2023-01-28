package libraryapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
import java.util.UUID;
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private LocalDate dateOfBirth;

    @OneToMany // tu nie jestem pewna tej relacji, nie powinno być ManyToMany?
    private Set<Book> books = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Genre.class)
    private Set<Genre> genres = new HashSet<>();
    private Double rating;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(dateOfBirth, author.dateOfBirth) && Objects.equals(books, author.books) && Objects.equals(genres, author.genres) && Objects.equals(rating, author.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, books, genres, rating);
    }

}
