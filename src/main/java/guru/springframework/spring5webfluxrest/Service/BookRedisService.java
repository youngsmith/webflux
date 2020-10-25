package guru.springframework.spring5webfluxrest.Service;

import guru.springframework.spring5webfluxrest.dto.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookRedisService {
    private final ReactiveRedisOperations<String, Book> redisTemplate;

    public Mono<Boolean> put(String key, Book val) {
        System.out.println("key : " + key + ", val : " + val);
        return redisTemplate.opsForValue().set(key, val);
    }

    public Mono<Book> get(String key) {
        System.out.println("key : " + key);
        return redisTemplate.opsForValue().get(key);
    }
}
