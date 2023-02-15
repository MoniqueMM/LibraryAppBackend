package libraryapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BorrowEventElement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    @ToString.Exclude
    private Book book;
    private Long bookAmount;
    private Boolean isReturned;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BorrowEventElement that)) return false;
        return getBookAmount() == that.getBookAmount() && getId().equals(that.getId()) && getStartDate().equals(that.getStartDate()) && Objects.equals(getEndDate(), that.getEndDate()) && getBook().equals(that.getBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStartDate(), getEndDate(), getBook(), getBookAmount());
    }
}
