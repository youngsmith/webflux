package guru.springframework.spring5webfluxrest.dto;

import lombok.Data;

import java.util.List;

@Data
public class BoxOfficeResult {
    String boxofficeType;
    String showRange;
    List<Movie> dailyBoxOfficeList;
}
