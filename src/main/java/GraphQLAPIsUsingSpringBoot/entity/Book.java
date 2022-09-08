package GraphQLAPIsUsingSpringBoot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id", nullable = false)
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