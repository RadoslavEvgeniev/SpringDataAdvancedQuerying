package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(
            "SELECT a " +
            "FROM bookshopsystemapp.domain.entities.Author AS a " +
            "WHERE a.firstName " +
            "LIKE :wildCard"
    )
    List<Author> authorsFirstNameEndsWith(@Param("wildCard") String wildCard);
}
