package library.controller;

import library.model.Book;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    private int page;

    private BookService bookService;

    @Autowired
    public void setFilmService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/")
    public ModelAndView allBooks(@RequestParam(defaultValue = "1") int page) {
        List<Book> books = bookService.allBooks(page);
        int booksCount = bookService.booksCount();
        int pagesCount = (booksCount + 9)/10;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books");
        modelAndView.addObject("page", page);
        modelAndView.addObject("booksList", books);
        modelAndView.addObject("booksCount", booksCount);
        modelAndView.addObject("pagesCount", pagesCount);
        this.page = page;
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView addPage(@ModelAttribute("message") String message) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView addBook(@ModelAttribute("book") Book book) {
        ModelAndView modelAndView = new ModelAndView();
        if (bookService.checkTitle(book.getBookTitle())) {
            modelAndView.setViewName("redirect:/");
            modelAndView.addObject("page", page);
            bookService.add(book);
        } else {
            modelAndView.addObject("message","part with title \"" + book.getBookTitle() + "\" already exists");
            modelAndView.setViewName("redirect:/add");
        }
        return modelAndView;
    }

    @GetMapping(value = "/edit/{isbn}")
    public ModelAndView editPage(@PathVariable("isbn") String isbn,
                                 @ModelAttribute("message") String message) {
        Book book = bookService.getByIsbn(isbn);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editBook(@ModelAttribute("book") Book book) {
        ModelAndView modelAndView = new ModelAndView();
        if (bookService.checkTitle(book.getBookTitle()) || bookService.getByIsbn(book.getBookTitle()).getBookTitle().equals(book.getBookTitle())) {
            modelAndView.setViewName("redirect:/");
            modelAndView.addObject("page", page);
            bookService.edit(book);
        } else {
            modelAndView.addObject("message","part with title \"" + book.getBookTitle() + "\" already exists");
            modelAndView.setViewName("redirect:/edit/" +  book.getIsbn());
        }
        return modelAndView;
    }

    @GetMapping(value="/delete/{isbn}")
    public ModelAndView deleteFilm(@PathVariable("isbn") String isbn) {
        ModelAndView modelAndView = new ModelAndView();
        int booksCount = bookService.booksCount();
        int page = ((booksCount - 1) % 10 == 0 && booksCount > 10 && this.page == (booksCount + 9)/10) ?
                this.page - 1 : this.page;
        modelAndView.setViewName("redirect:/");
        modelAndView.addObject("page", page);
        Book book = bookService.getByIsbn(isbn);
        bookService.delete(book);
        return modelAndView;
    }
}
