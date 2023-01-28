package libraryapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name ="users")
@RequiredArgsConstructor
@EqualsAndHashCode
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID ID;
    private String username;
    private String password;
    private String email;
    private String adress;
    private Role role;


}


