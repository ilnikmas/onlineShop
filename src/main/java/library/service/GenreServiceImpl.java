package library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import library.dao.GenreDao;
import library.model.Genre;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private GenreDao genreDao;

    @Autowired
    public void setGenreDao(GenreDao genreDao) { this.genreDao = genreDao; }

    @Transactional
    @Override
    public List<Genre> allGenres(int page) {
        return genreDao.allGenres(page);
    }

    @Transactional
    @Override
    public void add(Genre genre) {
        genreDao.add(genre);
    }

    @Transactional
    @Override
    public void delete(Genre genre) {
        genreDao.delete(genre);
    }

    @Transactional
    @Override
    public void edit(Genre genre) {
        genreDao.edit(genre);
    }

    @Transactional
    @Override
    public Genre getByIsbn(String isbn) {
        return genreDao.getByIsbn(isbn);
    }

    @Transactional
    @Override
    public int genresCount() {
        return genreDao.genresCount();
    }
}
