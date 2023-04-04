package pl.librarymanager.librarymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.librarymanager.librarymanager.model.Author;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
