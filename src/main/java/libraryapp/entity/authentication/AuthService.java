package libraryapp.entity.authentication;


import libraryapp.configuration.JwtService;
import libraryapp.entity.Role;
import libraryapp.entity.UserApp;
import libraryapp.repository.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserAppRepository repository;

    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String register(RegisterRequest request) {
        UserApp userApp = UserApp.builder()
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.ADMIN)
                .build();
        repository.save(userApp);

        return jwtService.generateToken(userApp);
    }


    public String authenticate(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        UserApp userApp = repository.findByUsername(authRequest.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return jwtService.generateToken(userApp);

    }

}
