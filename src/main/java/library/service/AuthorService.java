package library.service;

import library.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> allAuthors(int page);
    void add(Author authorName);
    void delete(Author authorName);
    void edit(Author authorName);
    Author getById(int id);
    int authorsCount();
}
