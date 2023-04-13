package pl.librarymanager.librarymanager.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.librarymanager.librarymanager.model.Book;
import pl.librarymanager.librarymanager.model.User;
import pl.librarymanager.librarymanager.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserService {
    private UserRepository userRepository;


    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAll(){
        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{username}")
    public ResponseEntity getUserByUsername(@PathVariable("username") String username){
        Optional<User> user = userRepository.findByUsername(username);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/{email}")
    public ResponseEntity getUserByEmail(@PathVariable("email") String email){
        Optional<User> user = userRepository.findByEmail(email);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        Optional<User> userFromDB = userRepository.findByUsername(user.getUsername());
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            User newUser = userRepository.save(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);



    }
}
