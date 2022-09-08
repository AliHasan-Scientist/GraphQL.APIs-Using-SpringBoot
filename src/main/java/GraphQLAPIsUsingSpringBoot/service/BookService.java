package GraphQLAPIsUsingSpringBoot.service;

import GraphQLAPIsUsingSpringBoot.entity.Book;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface BookService {
    // Create a new Book
    Book createBook(Book book);

    //get All Books
    List<Book> getBooks();

    // get Single Book
    Book getBook(Long id);

    // update Book
    Book updateBook(Long id, Book book);

    // delete Book
    void deleteBook(Long id);

}
