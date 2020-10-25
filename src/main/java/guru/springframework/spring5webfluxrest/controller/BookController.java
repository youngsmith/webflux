package guru.springframework.spring5webfluxrest.controller;

import guru.springframework.spring5webfluxrest.Service.BookRedisService;
import guru.springframework.spring5webfluxrest.dto.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookRedisService bookRedisService;
    //private final Faker faker;

    @GetMapping("/add/{key}")
    public Mono<Boolean> addBook(@PathVariable("key") String key) {
        UUID uuid = UUID.randomUUID();
        double dValue = Math.random();
        int random_price = (int)(dValue * 1000);

        Book book = new Book();
        book.setName("faker");
        book.setPage(300);
        book.setPrice(random_price);
        book.setUuid(uuid.toString());

        return bookRedisService.put(key, book);
    }

    @GetMapping("/get/{key}")
    public Mono<Book> getBook(@PathVariable("key") String key) {
        return bookRedisService.get(key);
    }
}
