package br.com.pipa.score.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScorePointsDTO implements Comparable<ScorePointsDTO>{

    private Integer userId = 0;

    private Integer scorePoints = 0;

    @Override
    public int compareTo(ScorePointsDTO o) {
        if(this.getScorePoints() > o.getScorePoints()) {
            return 1;
        }

        if(this.getScorePoints() < o.getScorePoints()) {
            return -1;
        }
        return 0;
    }
}
