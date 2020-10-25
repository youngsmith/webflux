package guru.springframework.spring5webfluxrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@RedisHash("Books")
public class Book implements Serializable {
    String name;
    @Id
    String uuid;
    int price;
    int page;
}
