package libraryapp.dto;

import libraryapp.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserDtoOut {

    private UUID id;
    private String username;
    private String password;
    private String email;
    private String adress;
    private Double rating;
    private Role role;

}
