package guru.springframework.spring5webfluxrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring5WebfluxRestApplication {
	/**
	 * https://redis.io/topics/data-types-intro
	 * https://github.com/gunayus/reactive-redis-demo/blob/ead1e1488f59ed12892a873953a176d1ef8a4d9c/src/main/java/org/springmeetup/reactiveredis/Config.java
	 * https://redislabs.com/ebook/part-1-getting-started/chapter-1-getting-to-know-redis/1-2-what-redis-data-structures-look-like/1-2-4-hashes-in-redis/
	 */
	public static void main(String[] args) {
		SpringApplication.run(Spring5WebfluxRestApplication.class, args);
	}
}
