package bookshopsystemapp.service;

import java.io.IOException;

public interface AuthorService {

    void seedAuthors() throws IOException;

    String authorsSearch(String endsWith);
}
