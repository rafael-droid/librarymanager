package pl.librarymanager.librarymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.librarymanager.librarymanager.model.Author;
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
        Book book = bookRepository.getBookById(id);
        return ResponseEntity.ok(book);
    }
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book newBook = bookRepository.save(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") String id){
        Book updateBook = bookRepository.save(book);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deteleBook(@PathVariable("id") Long id){
        bookRepository.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Book> partialUpdateBook(@RequestBody Book book, @PathVariable("id") Long id){
        Book oldbook = bookRepository.getBookById(id);
        if(book != null) {
            if (oldbook.getTitle() != book.getTitle()) {
                oldbook.setTitle(book.getTitle());
            }
            else if (oldbook.getCategory() != book.getCategory()) {
                oldbook.setCategory(book.getCategory());
            }
            else if (oldbook.getAuthor() != oldbook.getAuthor()) {
                oldbook.setAuthor(book.getAuthor());
            }
            bookRepository.save(oldbook);
        }

        return new ResponseEntity<>(oldbook, HttpStatus.OK);
    }
}
