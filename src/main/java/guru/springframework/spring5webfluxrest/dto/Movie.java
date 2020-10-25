package guru.springframework.spring5webfluxrest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    String rnum;
    String rank;
    String rankInten;
    String rankOldAndNew;
    String movieCd;
    String movieNm;
    String openDt;
    String salesAmt;
    String salesShare;
    String salesInten;
    String salesChange;
    String salesAcc;
    String audiCnt;
    String audiInten;
    String audiChange;
    String audiAcc;
    String scrnCnt;
    String showCnt;
}
