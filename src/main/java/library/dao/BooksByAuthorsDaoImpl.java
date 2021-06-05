package library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import library.model.BooksByAuthors;

@Repository
public class BooksByAuthorsDaoImpl implements BooksByAuthorsDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Override
    public void add(BooksByAuthors booksByAuthors) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(booksByAuthors);
    }

    @Override
    public void delete(BooksByAuthors booksByAuthors) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(booksByAuthors);
    }

    @Override
    public void edit(BooksByAuthors booksByAuthors) {
        Session session = sessionFactory.getCurrentSession();
        session.update(booksByAuthors);
    }

    @Override
    public BooksByAuthors getByIsbn(String isbn) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(BooksByAuthors.class, isbn);
    }
}
