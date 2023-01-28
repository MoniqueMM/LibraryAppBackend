package libraryapp.entity;

import jakarta.persistence.*;
import libraryapp.role.Role;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name ="users")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@NoArgsConstructor

public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private UUID id;

    @NonNull
    private String username;

    @NonNull
    private String email;

    @NonNull
    private String password;
    @NonNull
    private Role role;


}


