package library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import library.dao.BooksByAuthorsDao;
import library.model.BooksByAuthors;

@Service
public class BooksByAuthorsServiceImpl implements BooksByAuthorService {
    private BooksByAuthorsDao booksByAuthorsDao;

    @Autowired
    public void setBooksByAuthorsDao(BooksByAuthorsDao booksByAuthorsDao) { this.booksByAuthorsDao = booksByAuthorsDao; }

    @Transactional
    @Override
    public void add(BooksByAuthors booksByAuthors) {
        booksByAuthorsDao.add(booksByAuthors);
    }

    @Transactional
    @Override
    public void delete(BooksByAuthors booksByAuthors) {
        booksByAuthorsDao.delete(booksByAuthors);
    }

    @Transactional
    @Override
    public void edit(BooksByAuthors booksByAuthors) {
        booksByAuthorsDao.edit(booksByAuthors);
    }

    @Transactional
    @Override
    public BooksByAuthors getByIsbn(String isbn) {
        return booksByAuthorsDao.getByIsbn(isbn);
    }
}
