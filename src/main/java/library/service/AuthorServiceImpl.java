package library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import library.dao.AuthorDao;
import library.model.Author;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorDao authorDao;

    @Autowired
    public void setAuthorDao(AuthorDao authorDao) { this.authorDao = authorDao; }

    @Transactional
    @Override
    public List<Author> allAuthors(int page) {
        return authorDao.allAuthors(page);
    }

    @Transactional
    @Override
    public void add(Author authorName) {
        authorDao.add(authorName);
    }

    @Transactional
    @Override
    public void delete(Author authorName) {
        authorDao.delete(authorName);
    }

    @Transactional
    @Override
    public void edit(Author authorName) {
        authorDao.edit(authorName);
    }

    @Transactional
    @Override
    public Author getById(int id) {
        return authorDao.getById(id);
    }

    @Transactional
    @Override
    public int authorsCount() {
        return authorDao.authorsCount();
    }
}
