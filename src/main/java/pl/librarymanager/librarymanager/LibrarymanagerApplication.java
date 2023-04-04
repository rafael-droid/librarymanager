package pl.librarymanager.librarymanager;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LibrarymanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarymanagerApplication.class, args);
		Database database = new Database();
		database.start();
		//database.fill();

	}



}
