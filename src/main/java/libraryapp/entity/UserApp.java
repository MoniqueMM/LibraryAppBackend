package libraryapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name ="users")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private  String username;
    private String password;
    private String email;
    private String address;
//    private final Role role;


}


