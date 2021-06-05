package library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import library.dao.BookDao;
import library.model.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) { this.bookDao = bookDao; }

    @Transactional
    @Override
    public List<Book> allBooks(int page) {
        return bookDao.allBooks(page);
    }

    @Transactional
    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Transactional
    @Override
    public void delete(Book book) {
        bookDao.delete(book);
    }

    @Transactional
    @Override
    public void edit(Book book) {
        bookDao.edit(book);
    }

    @Transactional
    @Override
    public Book getByIsbn(String isbn) {
        return bookDao.getByIsbn(isbn);
    }

    @Override
    @Transactional
    public int booksCount() {
        return bookDao.booksCount();
    }

    @Override
    public boolean checkTitle(String bookTitle) {
        return bookDao.checkTitle(bookTitle);
    }
}
