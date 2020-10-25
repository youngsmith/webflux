package guru.springframework.spring5webfluxrest.config;

import guru.springframework.spring5webfluxrest.dto.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class BookRedisConfig {
    @Bean
    ReactiveRedisOperations<String, Book> redisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<Book> serializer = new Jackson2JsonRedisSerializer<>(Book.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, Book> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, Book> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}
