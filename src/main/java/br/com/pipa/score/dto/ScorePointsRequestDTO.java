package br.com.pipa.score.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ScorePointsRequestDTO {

    private Integer userId = 0;

    private Integer scorePoints = 0;

}
