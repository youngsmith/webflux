package guru.springframework.spring5webfluxrest.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.spring5webfluxrest.dto.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookRedisService {
    private final ReactiveRedisOperations<String, Book> redisTemplate;

    /**
     * 레디스의 string 타입을 사용하여, 이를 삽입한다.
     */
    public Mono<Boolean> put(String key, Book val) {
        System.out.println("key : " + key + ", val : " + val);
        return redisTemplate.opsForValue().set(key, val);
    }

    public Mono<Object> get(String key) {
        System.out.println("key : " + key);
        return redisTemplate.opsForHash().get("Book", key);
    }

    /**
     * hvals (key)
     * redis 의 hash 데이터 타입은 자바에서 HashMap<String, String> 타입의 키, 값으로 삽입해야 함.
     * <redis key, hashMap<Key,Value>>
     * 하나의 객체에서 필요한 값만을 뽑을 필요가 있을 때, 필요한 필드의 값만을 교체할 필요가 있을 때 사용하기 좋을 듯.
     */
    public Mono<Boolean> putAllHashData(String key, Book val) {
        Map<String, String> result = new HashMap<>();
        result.put("a","b");
        result.put("c","d");
        System.out.println("key : " + key + ", val : " + result);
        return redisTemplate.opsForHash().putAll(key, result);
    }

    /**
     * 리턴값이 false 인 것이 특이하지만, 값 수정은 제대로 됨
     */
    public Mono<Boolean> modifyHashData(String key, String hashKey, String hashVal) {
        System.out.println(String.format("key:%s hashKey:%s hashVal:%s", key, hashKey, hashVal));
        return redisTemplate.opsForHash().put(key, hashKey, hashVal);
    }

    public Mono<Object> getHashData(String key, String hashKey) {
        System.out.println(String.format("key:%s hashKey:%s", key, hashKey));
        return redisTemplate.opsForHash().get(key, hashKey);
    }





}
