package pl.librarymanager.librarymanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.provider.HibernateUtils;
import pl.librarymanager.librarymanager.model.Author;
import pl.librarymanager.librarymanager.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.springframework.data.jpa.provider.HibernateUtils.*;

@SpringBootApplication
public class LibrarymanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarymanagerApplication.class, args);
		Author author1 = new Author();
		Book  book1 = new Book();
		ArrayList<Book> bookSet = new ArrayList<>();
		bookSet.add(book1);
		author1.setFirstName("Adam");
		author1.setLastName("Kowalski");
		book1.setTitle("ksiazka1");
		book1.setCategory("comedy");

	}



}
