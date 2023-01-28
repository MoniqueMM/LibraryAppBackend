package libraryapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;
import java.util.UUID;
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private LocalDate DateOfBirth;
    @OneToMany
    private Set<Book> books = new HashSet<>();
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Genre.class)
    private Set<Genre> genres = new HashSet<>();
    private Double rating;
}
