package br.com.pipa.score.repository;

import br.com.pipa.score.dto.UserPositionDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@ApplicationScope
public class UserScoreData {

    private List<UserPositionDTO> scorePointsList = new ArrayList<UserPositionDTO>();

    public void save(UserPositionDTO dto) {
        removeScorePointsByUserId(dto.getUserId());
        scorePointsList.add(dto);
        sortScoreList();
    }

    public UserPositionDTO getScorePointsByUserId(Integer userID) {
        Optional<UserPositionDTO> op = scorePointsList.stream()
                                                    .filter(user -> user.getUserId().equals(userID))
                                                    .findFirst();

        if(op.isPresent()) {
            return op.get();
        } else {
            return null;
        }
    }

    public List<UserPositionDTO> getTopScores(int limit) {
        return scorePointsList.stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    private void removeScorePointsByUserId(Integer userID) {
        UserPositionDTO dto = getScorePointsByUserId(userID);

        if(dto != null) {
            scorePointsList.remove(dto);
        }
    }

    private void sortScoreList() {
        scorePointsList = scorePointsList.stream()
                .sorted(Comparator.comparingInt(UserPositionDTO::getScorePoints))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        IntStream.range(0, scorePointsList.size())
                .forEach(index -> scorePointsList.get(index).setPosition(index + 1));
    }
}
