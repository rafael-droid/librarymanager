package pl.librarymanager.librarymanager.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

}
