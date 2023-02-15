package libraryapp.mapper;

import libraryapp.dto.UserDtoOut;
import libraryapp.entity.Role;
import libraryapp.entity.UserApp;

public class UserMapper {



    public static UserDtoOut mapUserDtoOut (UserApp userApp){
        return UserDtoOut.builder()
                .id(userApp.getUuid())
                .username(userApp.getUsername())
                .password(userApp.getPassword())
                .email(userApp.getEmail())
                .build();
    }
}
