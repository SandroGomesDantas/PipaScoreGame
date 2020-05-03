package br.com.pipa.score.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class HighScoreDTO {

    private List<UserPositionDTO> highScore;

    public HighScoreDTO() {
        UserPositionDTO dto = new UserPositionDTO();
        List<UserPositionDTO> list = new ArrayList<>();

        list.add(dto);
        this.highScore = list;
    }
}