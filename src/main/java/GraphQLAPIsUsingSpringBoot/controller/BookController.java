package GraphQLAPIsUsingSpringBoot.controller;

import GraphQLAPIsUsingSpringBoot.entity.Book;
import GraphQLAPIsUsingSpringBoot.global.URI;
import GraphQLAPIsUsingSpringBoot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(URI.initial)
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        if (book == null) {
            return new ResponseEntity<>("Please provide date", HttpStatus.BAD_REQUEST);
        }
        this.bookService.createBook(book);
        return new ResponseEntity<>(this.bookService.createBook(book), HttpStatus.OK);
    }

}
