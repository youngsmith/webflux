package guru.springframework.spring5webfluxrest.repository;

import guru.springframework.spring5webfluxrest.dto.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRedisRepository extends CrudRepository<Book, String> {
}
