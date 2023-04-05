package pl.librarymanager.librarymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.librarymanager.librarymanager.model.Book;
import pl.librarymanager.librarymanager.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public ResponseEntity getAll(){
        List<Book> bookList = bookRepository.findAll();
        return ResponseEntity.ok(bookList);
    }
    @GetMapping("/{id}")
    public ResponseEntity getBookById(@PathVariable("id") Long id){
        Optional<Book> book = bookRepository.getBookById(id);
        return ResponseEntity.ok(book);
    }
}
