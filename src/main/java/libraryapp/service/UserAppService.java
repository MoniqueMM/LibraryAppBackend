package libraryapp.service;

import libraryapp.dto.UserDtoIn;
import libraryapp.entity.UserApp;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserAppService {
    List<UserApp> getAllUsers();
    Optional<UserApp> getUsersById (UUID id);
    UserApp addUser (UserDtoIn userDtoIn);
    UserApp updateUser (UUID id, UserDtoIn userDtoIn);
    void deleteUser (UUID id);



}
