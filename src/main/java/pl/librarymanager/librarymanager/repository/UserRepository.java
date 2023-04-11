package pl.librarymanager.librarymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.librarymanager.librarymanager.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserOrEmail(String username, String email);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
