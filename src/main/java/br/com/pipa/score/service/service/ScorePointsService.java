package br.com.pipa.score.service.service;

import br.com.pipa.score.service.dto.HighScoreDTO;
import br.com.pipa.score.service.dto.ScorePointsDTO;
import br.com.pipa.score.service.dto.UserPositionDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.*;
import java.util.stream.Collectors;

@Component
@ApplicationScope
public class ScorePointsService {

    private List<UserPositionDTO> scorePointsList = new ArrayList<UserPositionDTO>();

    public ScorePointsDTO addPoints(Integer userId, Integer points) {

        ScorePointsDTO scorePointsDTO = new ScorePointsDTO();
        UserPositionDTO dto = getSortedScorePointsByUserId(userId);

        if(dto != null) {
            scorePointsList.remove(dto);
            dto.setScorePoints(dto.getScorePoints() + points);
        } else {
            dto = new UserPositionDTO();
            dto.setUserId(userId);
            dto.setScorePoints(points);
        }

        scorePointsList.add(dto);

        scorePointsDTO.setUserId(dto.getUserId());
        scorePointsDTO.setScorePoints(dto.getScorePoints());

        return scorePointsDTO;
    }

    public UserPositionDTO getUserPositionByUserId(Integer userId) {
        UserPositionDTO userPositionDTO = getSortedScorePointsByUserId(userId);

        if(userPositionDTO != null) {
            userPositionDTO.setPosition(scorePointsList.indexOf(userPositionDTO) + 1);
        } else {
            userPositionDTO = new UserPositionDTO();
        }

        return userPositionDTO;
    }

    public HighScoreDTO getHighScoreList() {
        if(scorePointsList.isEmpty()) {
            UserPositionDTO userDTO = new UserPositionDTO();
            List<UserPositionDTO> list = new ArrayList<UserPositionDTO>();
            list.add(userDTO);

            return new HighScoreDTO(list);
        } else {
            if(scorePointsList.size() > 20000) {
                return new HighScoreDTO(scorePointsList.subList(0, 20000));
            } else {
                return new HighScoreDTO(scorePointsList);
            }
        }
    }

    private UserPositionDTO getSortedScorePointsByUserId(Integer userId) {

        scorePointsList = scorePointsList.stream()
                .sorted(Comparator.comparingInt(UserPositionDTO::getScorePoints))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        Optional<UserPositionDTO> filteredScore = scorePointsList.stream()
                .filter(s -> s.getUserId() == userId)
                .findFirst();

        if(filteredScore.isPresent()) {
            return filteredScore.get();
        } else {
            return null;
        }
    }
}
