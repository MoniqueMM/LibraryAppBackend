package libraryapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table (name="users")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserApp implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String username;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private List<Role> role = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(getRole().toString());
        return List.of(authority);
    }

    public UserApp (String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password =password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<Role> getRoles() {
        return role;
    }
}
