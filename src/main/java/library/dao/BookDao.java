package library.dao;


import library.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> allBooks(int page);
    void add(Book book);
    void delete(Book book);
    void edit(Book book);
    Book getByIsbn(String isbn);
    int booksCount();
    boolean checkTitle(String bookTitle);
}
