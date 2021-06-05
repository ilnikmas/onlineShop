package library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import library.model.Author;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    @Override
    @SuppressWarnings("unchecked")
    public List<Author> allAuthors(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Author").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    public void add(Author authorName) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(authorName);
    }

    @Override
    public void delete(Author authorName) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(authorName);
    }

    @Override
    public void edit(Author authorName) {
        Session session = sessionFactory.getCurrentSession();
        session.update(authorName);
    }

    @Override
    public Author getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Author.class, id);
    }

    @Override
    public int authorsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Author", Number.class).getSingleResult().intValue();
    }
}
