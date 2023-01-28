package libraryapp.entity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
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
    @Column(nullable = false)
    private String title;
    @ManyToOne
    private Author author;
    @Column(nullable = false)
    private Long isbn;
    private Long quantity;
    private LocalDate releaseDate;
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Genre.class)
    private Set<Genre> genres = new HashSet<>();
    private Double rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getIsbn() == book.getIsbn() && getQuantity() == book.getQuantity() && Double.compare(book.getRating(),
                getRating()) == 0 && getId().equals(book.getId()) && getTitle().equals(book.getTitle())
                && Objects.equals(getAuthor(), book.getAuthor()) && getReleaseDate().equals(book.getReleaseDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getIsbn(), getQuantity(), getReleaseDate(), getRating());
    }
}
