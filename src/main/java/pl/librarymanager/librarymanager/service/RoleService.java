package pl.librarymanager.librarymanager.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.librarymanager.librarymanager.model.Role;
import pl.librarymanager.librarymanager.model.User;
import pl.librarymanager.librarymanager.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Role>> getAll(){
        List<Role> roleList = roleRepository.findAll();
        return ResponseEntity.ok(roleList);
    }
    @GetMapping("/{name}")
    public ResponseEntity getRoleByName(@PathVariable("name") String name){
        Optional<Role> role = roleRepository.findByName(name);

        return ResponseEntity.ok(role);
    }
    @PostMapping("/add")
    public ResponseEntity addRole(@RequestBody Role role){
        Optional<Role> oldRole = roleRepository.findByName(role.getName());
        if(oldRole!=null){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }else {
            Role newRole = roleRepository.save(role);
            return new ResponseEntity<>(newRole, HttpStatus.CREATED);
        }
    }
}
