package libraryapp.service;

import libraryapp.entity.UserApp;
import libraryapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin

public class UserService {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/users")
    public ResponseEntity<List<UserApp>> getUserApp() {
        List<UserApp> users = userRepository.findAll();
        return ResponseEntity.ok(users);

    }


    @PostMapping("/users")
    public ResponseEntity addUserApp(@RequestBody UserApp userApp) {
        Optional<UserApp> userDataBase = userRepository.findByUsername(userApp.getUsername());

        if (userDataBase.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        }
        UserApp savedUser = userRepository.save(userApp);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")

    public ResponseEntity login(@RequestBody UserApp userApp) {
        Optional<UserApp> userDataBase = userRepository.findByUsername(userApp.getUsername());
        if (userDataBase.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok().build();

    }

    private boolean wrongPassword(Optional<UserApp> userDataBase, UserApp userApp) {
        return !userDataBase.get().getPassword().equals(userApp.getPassword());
    }
}

