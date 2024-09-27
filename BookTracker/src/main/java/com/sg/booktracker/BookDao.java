package com.sg.booktracker;

import com.sg.booktracker.Book;
import java.util.List;

/**
 *
 * @author Kyle David Rudy
 */
public interface BookDao {
    Book getBookByTitle(String title);
    List<Book> getAllBooks();
    Book addBook(Book book);
    void updateBook(Book book);
    void deleteBookByTitle(String title);
}
