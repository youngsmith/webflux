package guru.springframework.spring5webfluxrest.controller;

import guru.springframework.spring5webfluxrest.Service.BookRedisService;
import guru.springframework.spring5webfluxrest.util.BookUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookRedisService bookRedisService;

    @GetMapping("/add/{key}")
    public Mono<Boolean> addBook(@PathVariable("key") String key) {
        return bookRedisService.put(key, BookUtil.makeBook());
    }

    @GetMapping("/get/{key}")
    public Mono<Object> getBook(@PathVariable("key") String key) {
        return bookRedisService.get(key);
    }

    @GetMapping("/hash/add-all/{key}")
    public Mono<Boolean> addBookAllHashData(@PathVariable("key") String key) {
        return bookRedisService.putAllHashData(key, BookUtil.makeBook());
    }

    @GetMapping("/hash/get/{redisKey}/{hashKey}")
    public Mono<Object> getHashData(@PathVariable("redisKey") String redisKey,
                                    @PathVariable("hashKey") String hashKey) {
        return bookRedisService.getHashData(redisKey, hashKey);
    }

    @GetMapping("/hash/modify/{redisKey}/{hashKey}/{hashVal}")
    public Mono<Boolean> modifyHashData(@PathVariable("redisKey") String redisKey,
                                        @PathVariable("hashKey") String hashKey,
                                        @PathVariable("hashVal") String hashVal) {
        return bookRedisService.modifyHashData(redisKey, hashKey, hashVal);
    }

}
