package libraryapp.entity;

import jakarta.persistence.*;
import libraryapp.role.Role;
import lombok.*;

@Entity
@Table(name ="users")
@RequiredArgsConstructor
@EqualsAndHashCode
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor

public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private final String username;
    private final String password;
    private final String email;
    private final String adress;
    private final Role role;


}


