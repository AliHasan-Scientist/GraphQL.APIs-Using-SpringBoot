package GraphQLAPIsUsingSpringBoot.model;

import lombok.Data;

@Data
public class BookDto {
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
