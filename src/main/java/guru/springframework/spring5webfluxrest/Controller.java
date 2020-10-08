package guru.springframework.spring5webfluxrest;

import guru.springframework.spring5webfluxrest.dto.ApiResult;
import guru.springframework.spring5webfluxrest.dto.BoxOfficeResult;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private final String uriTemplate = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=%s";
    private final String date = "20200901";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    @GetMapping("/")
    public String controller() {
        return "hello, home";
    }

    @GetMapping("/movie-mono")
    public Mono<List<ApiResult>> getMovie() {
        System.out.println("Starting NON-BLOCKING Controller!");

        System.out.println("Exiting NON-BLOCKING Controller!");
        return null;
    }

    @GetMapping("/movie-flux")
    @Cacheable
    public Flux<ApiResult> getMovie2() throws InterruptedException {
        System.out.println("Starting NON-BLOCKING Controller!");

        String ddate = date;
        LocalDate targetDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);

        Flux<ApiResult> ret = Flux.empty();

        for(int i = 0; i < 10; i++){
            System.out.println(targetDate.toString());
            Mono<ApiResult> d = WebClient.create()
                    .get()
                    .uri(String.format(uriTemplate, targetDate.format(formatter)))
                    .retrieve()
                    .bodyToMono(ApiResult.class).log();

            // ret.concatWith 는 구독시 순서 보장됨.
            // ret.mergeWith 는 구독시 순서 보장 안됨.
            // 클라이언트에서 결과를 받을 때는 둘 다 같은 순서로 옴.
            ret = ret.mergeWith(d);
            targetDate = targetDate.plusDays(1);
        }
        // ret.subscribe();
        // ret.subscribe(i -> System.out.println(i));
        ret.subscribe(System.out::println);

        System.out.println("Exiting NON-BLOCKING Controller!");
        return ret;
    }

    /**
     * 위 flux 로 처리했을 경우와 최대 5배 까지 response time 차이가 남.
     * 평균 2배 차이남.
     * @return
     */
    @GetMapping("/movie-normal")
    public List<ApiResult> getMovie3() {
        System.out.println("Starting NON-BLOCKING Controller!");

        List<ApiResult> ret = new ArrayList<>();
        String ddate = date;
        LocalDate targetDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
        RestTemplate restTemplate = new RestTemplate();

        for(int i = 0; i < 10; i++){
            ResponseEntity<ApiResult> response = restTemplate.exchange(
                    String.format(uriTemplate, targetDate.format(formatter)), HttpMethod.GET, null,
                    new ParameterizedTypeReference<ApiResult>(){});

            ret.add(response.getBody());
            targetDate = targetDate.plusDays(1);
        }

        System.out.println("Exiting NON-BLOCKING Controller!");
        return ret;
    }
}
