package libraryapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    @ManyToOne
    private Author author;
    private long isbn;
    private long quantity;
    private LocalDate releaseDate;
    private Set<Genre> genres = new HashSet<>();
    private float rating;
}
