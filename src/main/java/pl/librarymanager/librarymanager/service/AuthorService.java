package pl.librarymanager.librarymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.librarymanager.librarymanager.model.Author;
import pl.librarymanager.librarymanager.model.Book;
import pl.librarymanager.librarymanager.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    @GetMapping("/")
    public ResponseEntity getAuthors(){
        List<Author> authorList = authorRepository.findAll();
        return ResponseEntity.ok(authorList);
    }
    @GetMapping("/{id}")
    public ResponseEntity getAuthorById(@PathVariable("id") Long id){
        Optional<Author> author = authorRepository.getAuthorById(id);
        return ResponseEntity.ok(author);
    }
}
