package GraphQLAPIsUsingSpringBoot.service.Impl;

import GraphQLAPIsUsingSpringBoot.entity.Book;
import GraphQLAPIsUsingSpringBoot.repository.BookRepository;
import GraphQLAPIsUsingSpringBoot.service.BookService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBook(Long id) {
        Optional<Book> book = this.bookRepository.findById(id);
        return book;
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book foundedBook = this.bookRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found against id"));
        foundedBook.setName(book.getName());
        foundedBook.setCoverImage(book.getCoverImage());
        foundedBook.setType(book.getType());
        foundedBook.setDescription(book.getDescription());
        foundedBook.setAuthor(book.getAuthor());
        foundedBook.setPopularity(book.getPopularity());
        foundedBook.setBrand(book.getBrand());
        foundedBook.setPages(book.getPages());
        return this.bookRepository.save(foundedBook);
    }

    @Override
    public void deleteBook(Long id) {
        this.bookRepository.deleteById(id);
    }
}
