package GraphQLAPIsUsingSpringBoot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String coverImage;
    private String type;
    private String description;
    private String author;
    private String popularity;
    private String brand;
    private Long pages;

}