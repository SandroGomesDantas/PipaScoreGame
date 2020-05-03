package br.com.pipa.score.dto;

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
public class UserPositionDTO implements Comparable<UserPositionDTO>{

    private Integer userId = 0;

    private Integer scorePoints = 0;

    private Integer position = 0;

    @Override
    public int compareTo(UserPositionDTO o) {
        if(this.getScorePoints() > o.getScorePoints()) {
            return 1;
        }

        if(this.getScorePoints() < o.getScorePoints()) {
            return -1;
        }
        return 0;
    }
}