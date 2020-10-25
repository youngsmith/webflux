package guru.springframework.spring5webfluxrest.util;

import guru.springframework.spring5webfluxrest.dto.Book;

import java.util.UUID;

public class BookUtil {
    public static Book makeBook() {
        UUID uuid = UUID.randomUUID();
        double dValue = Math.random();
        int random_price = (int)(dValue * 1000);

        Book book = new Book();
        book.setName("faker");
        book.setPage(300);
        book.setPrice(random_price);
        book.setUuid(uuid.toString());
        return book;
    }
}
