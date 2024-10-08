package com.sg.booktracker;

import com.sg.booktracker.BookDao;
import com.sg.booktracker.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Kyle David Rudy
 */
@Component
public class BookService {
    
    private BookDao dao;

    @Autowired
    public BookService(BookDao dao) {
        this.dao = dao;
    }
    
    public Book getBookByTitle(String title) {
        return dao.getBookByTitle(title);
    }
    
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }
    
    public Book addBook(Book book) {
        return dao.addBook(book);
    }
    
    public void updateBook(Book book) {
        dao.updateBook(book);
    }
    
    public void deleteBookByTitle(String title) {
        dao.deleteBookByTitle(title);
    }
}
