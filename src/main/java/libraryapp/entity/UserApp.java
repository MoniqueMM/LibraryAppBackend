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
@NoArgsConstructor
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String username;
    private String password;
    private String email;
    private String adress;
    private Role role;


}


