package libraryapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BorrowEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @ManyToOne
    private UserApp user;
    private LocalDate startingDate;
    private LocalDate endDate;
    @OneToMany
    @ToString.Exclude
    private Set<BorrowEventElement> borrowEventElements;
    private boolean isActive;

}
