package bookshopsystemapp.controller;

import bookshopsystemapp.service.AuthorService;
import bookshopsystemapp.service.BookService;
import bookshopsystemapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Controller
public class BookshopController implements CommandLineRunner {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public BookshopController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... strings) throws Exception {
//        this.authorService.seedAuthors();
//        this.categoryService.seedCategories();
//        this.bookService.seedBooks();

        this.authorsSearch();
    }

    private void bookTitlesByAgeRestriction() {
        Scanner scanner = new Scanner(System.in);
        String ageRestrictionStr = scanner.nextLine();

        this.bookService.bookTitlesByAgeRestriction(ageRestrictionStr).forEach(b -> System.out.println(b));
    }

    private void booksByPrice() {
        System.out.println(this.bookService.booksByPrice());
    }

    private void notReleasedBooks() {
        Scanner scanner = new Scanner(System.in);
        String yearAsString = scanner.nextLine();

        String result = this.bookService.notReleasedBooks(yearAsString);

        System.out.println(result);
    }

    private void booksReleasedBeforeDate() {
        Scanner scanner = new Scanner(System.in);

        String dateAsString = scanner.nextLine();

        String result = this.bookService.booksReleasedBeforeDate(dateAsString);

        System.out.println(result);
    }

    private void authorsSearch() {
        Scanner scanner = new Scanner(System.in);

        String endsWith = scanner.nextLine();

        String result = this.authorService.authorsSearch(endsWith);

        System.out.println(result);
    }
}
