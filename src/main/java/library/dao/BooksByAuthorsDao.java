package library.dao;

import library.model.BooksByAuthors;

public interface BooksByAuthorsDao {
    void add(BooksByAuthors booksByAuthors);
    void delete(BooksByAuthors booksByAuthors);
    void edit(BooksByAuthors booksByAuthors);
    BooksByAuthors getByIsbn(String isbn);

}
