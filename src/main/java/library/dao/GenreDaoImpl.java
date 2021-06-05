package library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import library.model.Genre;

import java.util.List;

@Repository
public class GenreDaoImpl implements GenreDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Override
    @SuppressWarnings("unchecked")
    public List<Genre> allGenres(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Genre").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    public void add(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(genre);
    }

    @Override
    public void delete(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(genre);
    }

    @Override
    public void edit(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        session.update(genre);
    }

    @Override
    public Genre getByIsbn(String isbn) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Genre.class, isbn);
    }

    @Override
    public int genresCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Genre", Number.class).getSingleResult().intValue();
    }
}
