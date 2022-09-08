package GraphQLAPIsUsingSpringBoot.controller;

import GraphQLAPIsUsingSpringBoot.entity.Book;
import GraphQLAPIsUsingSpringBoot.service.BookService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@RequestMapping(URI.initial)
@Controller
public class BookController {
    @NotNull
    @Autowired
    private BookService bookService;

    //    @PostMapping("/book")
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        if (book == null) {
            return new ResponseEntity<>("Please provide date", HttpStatus.BAD_REQUEST);
        }
        this.bookService.createBook(book);
        return new ResponseEntity<>(this.bookService.createBook(book), HttpStatus.OK);
    }

    //    @GetMapping("/book")
    @QueryMapping("books")
    public List<Book> getBooks() {
//        return new ResponseEntity<>(this.bookService.getBooks(), HttpStatus.OK);
        return this.bookService.getBooks();
    }

    //    @GetMapping("/book/{id}")
    @QueryMapping("book")
    public Book getBook(@Argument Long id) {
//        return new ResponseEntity<>(this.bookService.getBook(id), HttpStatus.OK);
        return this.bookService.getBook(id);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {

        Book getBook = this.bookService.updateBook(id, book);
        return new ResponseEntity<>(getBook, HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> delBook(@PathVariable("id") Long id) {
        this.bookService.deleteBook(id);
        return ResponseEntity.ok().body("deleted");
    }
}
