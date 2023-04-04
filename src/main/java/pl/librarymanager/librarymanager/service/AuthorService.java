package pl.librarymanager.librarymanager.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.librarymanager.librarymanager.model.Author;
import pl.librarymanager.librarymanager.repository.AuthorRepository;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorService {
    AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    @GetMapping("/list")
    public ResponseEntity getAuthors(){
        List<Author> authorList = authorRepository.findAll();
        return ResponseEntity.ok(authorList);
    }
}
