package libraryapp.service;

import libraryapp.dto.UserDtoIn;
import libraryapp.entity.UserApp;
import libraryapp.repository.UserAppRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin

public class JpaUserService implements UserAppService {

    private final UserAppRepository userAppRepository;

    public JpaUserService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }


    @Override
    public List<UserApp> getAllUsers() {
        return userAppRepository.findAll();
    }

    @Override
    public Optional<UserApp> getUsersById(UUID id) {
        return userAppRepository.findById(id);
    }

    @Override
    public UserApp addUser(UserDtoIn userDtoIn) {
        return null;// czy to potrzebne?
    }

    @Override
    public UserApp updateUser(UUID id, UserDtoIn userDtoIn) {
        UserApp userApp = userAppRepository.findById(id).get();
        userApp.setUserName(userDtoIn.getUsername());
        userApp.setAdress(userDtoIn.getAdress());
        userApp.setEmail(userDtoIn.getEmail());
        return userAppRepository.save(userApp);
    }

    @Override
    public void deleteUser(UUID id) {
        userAppRepository.deleteById(id);
    }


//    @Autowired
//    UserRepository userRepository;
//
//
//    @GetMapping("/users")
//    public ResponseEntity<List<UserApp>> getUserApp() {
//        List<UserApp> users = userRepository.findAll();
//        return ResponseEntity.ok(users);
//
//    }
//
//
//    @PostMapping("/users")
//    public ResponseEntity addUserApp(@RequestBody UserApp userApp) {
//        Optional<UserApp> userDataBase = userRepository.findByUsername(userApp.getUsername());
//
//        if (userDataBase.isPresent()) {
//            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
//
//        }
//        UserApp savedUser = userRepository.save(userApp);
//        return ResponseEntity.ok(savedUser);
//    }
//
//    @PostMapping("/login")
//
//    public ResponseEntity login(@RequestBody UserApp userApp) {
//        Optional<UserApp> userDataBase = userRepository.findByUsername(userApp.getUsername());
//        if (userDataBase.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        return ResponseEntity.ok().build();
//
//    }
//
//    private boolean wrongPassword(Optional<UserApp> userDataBase, UserApp userApp) {
//        return !userDataBase.get().getPassword().equals(userApp.getPassword());
//    }
}

