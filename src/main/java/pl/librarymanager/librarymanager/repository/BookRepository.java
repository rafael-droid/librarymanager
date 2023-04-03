package pl.librarymanager.librarymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.librarymanager.librarymanager.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
