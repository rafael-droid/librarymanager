package pl.librarymanager.librarymanager;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class LibrarymanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarymanagerApplication.class, args);
		Database database = new Database();
		//database.start();
		//database.fill();

	}



}
