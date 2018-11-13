package bookshopsystemapp.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> getAllBooksTitlesAfter();

    Set<String> getAllAuthorsWithBookBefore();

    List<String> bookTitlesByAgeRestriction(String ageRestrictionStr);

    String booksByPrice();

    String notReleasedBooks(String yearAsString);

    String booksReleasedBeforeDate(String dateAsString);


}
