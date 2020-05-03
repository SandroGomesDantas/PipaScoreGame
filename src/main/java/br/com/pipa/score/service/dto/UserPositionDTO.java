package br.com.pipa.score.service.dto;

import lombok.*;

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
