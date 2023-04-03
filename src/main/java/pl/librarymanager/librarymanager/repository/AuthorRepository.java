package pl.librarymanager.librarymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.librarymanager.librarymanager.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
