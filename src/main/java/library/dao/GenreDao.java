package library.dao;

import library.model.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> allGenres(int page);
    void add(Genre genre);
    void delete(Genre genre);
    void edit(Genre genre);
    Genre getByIsbn(String isbn);
    int genresCount();
}
