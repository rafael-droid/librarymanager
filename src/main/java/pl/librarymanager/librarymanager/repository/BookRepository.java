package pl.librarymanager.librarymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.librarymanager.librarymanager.model.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book getBookById(Long id);
    void deleteBookById(Long id);
}
