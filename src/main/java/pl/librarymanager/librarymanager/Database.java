package pl.librarymanager.librarymanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pl.librarymanager.librarymanager.model.Author;
import pl.librarymanager.librarymanager.model.Book;

import java.util.ArrayList;

public class Database {
    public void start(){
        HibernateSetup.setup();

    }
    public void fill(){
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;

        try{
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Author author1 = new Author();
            Author author2 = new Author();
            Book book1 = new Book();
            ArrayList<Book> bookSet = new ArrayList<>();
            bookSet.add(book1);
            author1.setFirstName("Adam");
            author1.setLastName("Kowalski");
            author2.setFirstName("Szymon");
            author2.setLastName("Nowak");
            book1.setAuthor(author1);
            book1.setTitle("ksiazka1");
            book1.setCategory("comedy");

            session.save(author1);
            session.save(book1);
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
        finally {
            if(sessionFactory != null){
                sessionFactory.close();
            }
        }
    }
}
