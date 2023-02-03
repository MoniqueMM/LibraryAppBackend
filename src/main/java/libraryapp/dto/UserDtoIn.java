package libraryapp.dto;

import libraryapp.entity.Role;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDtoIn {

    private String username;
    private String email;
    private String adress;
//password, role
}
