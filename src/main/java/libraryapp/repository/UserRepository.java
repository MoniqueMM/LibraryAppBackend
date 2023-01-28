package libraryapp.repository;

import libraryapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository< UserApp, Long> {

    Optional<UserApp> findById(UUID id);

    Optional<UserApp> findByUsername (String username);


}