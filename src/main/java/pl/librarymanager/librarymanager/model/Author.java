package pl.librarymanager.librarymanager.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.List;


import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Author")
@Entity
@RequiredArgsConstructor
@ToString
public class Author {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @NonNull
    @Column(nullable = false)
    private String firstName;
    @NonNull
    @Column(nullable = false)
    private String lastName;
    @OneToMany( cascade = CascadeType.ALL, targetEntity = Book.class)
    @JoinColumn(name = "author_id",nullable = false)
    private Set<Book> books;
}
