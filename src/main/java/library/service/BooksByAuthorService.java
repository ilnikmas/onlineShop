package library.service;

import library.model.BooksByAuthors;

public interface BooksByAuthorService {
    void add(BooksByAuthors booksByAuthors);
    void delete(BooksByAuthors booksByAuthors);
    void edit(BooksByAuthors booksByAuthors);
    BooksByAuthors getByIsbn(String isbn);
}
