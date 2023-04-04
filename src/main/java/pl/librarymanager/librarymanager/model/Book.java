package pl.librarymanager.librarymanager.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Book")
@RequiredArgsConstructor
@ToString
@Table(name = "Book")
public class Book {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String category;
    @ManyToOne
    @JoinColumn
    private Author author;

}
