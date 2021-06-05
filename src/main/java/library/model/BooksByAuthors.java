package library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "books_by_authors")
public class BooksByAuthors implements Serializable {
    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    @Id
    @Column(name = "isbn")
    private String isbn;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooksByAuthors that = (BooksByAuthors) o;
        return authorId == that.authorId && isbn.equals(that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, isbn);
    }

    @Override
    public String toString() {
        return "BooksByAuthors{" +
                "authorId=" + authorId +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
