package pl.librarymanager.librarymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.librarymanager.librarymanager.Exception.AuthorNotFoundException;
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
        Author author = authorRepository.getAuthorById(id);
        return ResponseEntity.ok(author);
    }
    @PostMapping("/add")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        Author authorFromDB = authorRepository.getAuthorById(author.getId());

        if(authorFromDB == null){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        }else {
            Author newAuthor = authorRepository.save(author);
            return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
        }

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable("id") String id){
        Author authorFromDB = authorRepository.getAuthorById(author.getId());

        if(authorFromDB == null) {
            throw new AuthorNotFoundException("Author with this id is not exist in database");
        }else {
            Author updateAuthor = authorRepository.save(author);
            return new ResponseEntity<>(updateAuthor, HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deteleEmployee(@PathVariable("id") Long id){
        authorRepository.deleteAuthorById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Author> partialUpdateAuthor(@RequestBody Author author, @PathVariable("id") Long id){
        Author oldAuthor = authorRepository.getAuthorById(id);
        if(oldAuthor != null) {
            if (oldAuthor.getFirstName() != author.getFirstName()) {
                oldAuthor.setFirstName(author.getFirstName());
            }
            else if (oldAuthor.getLastName() != author.getLastName()) {
                oldAuthor.setLastName(author.getLastName());
            }
             else if (oldAuthor.getBooks() != author.getBooks()) {
                oldAuthor.setBooks(author.getBooks());
            }
             authorRepository.save(oldAuthor);
        }

        return new ResponseEntity<>(oldAuthor, HttpStatus.OK);
    }
}
