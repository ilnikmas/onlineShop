package library.dao;

import library.model.Author;

import java.util.List;

public interface AuthorDao {
    List<Author> allAuthors(int page);
    void add(Author authorName);
    void delete(Author authorName);
    void edit(Author authorName);
    Author getById(int id);
    int authorsCount();
}
