package library.service;

import library.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> allGenres(int page);
    void add(Genre genre);
    void delete(Genre genre);
    void edit(Genre genre);
    Genre getByIsbn(String isbn);
    int genresCount();
}
