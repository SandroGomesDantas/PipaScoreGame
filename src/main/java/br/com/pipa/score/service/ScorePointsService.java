package br.com.pipa.score.service;

import br.com.pipa.score.dto.HighScoreDTO;
import br.com.pipa.score.dto.ScorePointsDTO;
import br.com.pipa.score.dto.UserPositionDTO;
import br.com.pipa.score.exception.NullParamException;
import br.com.pipa.score.exception.ZeroOrNegativeParamException;
import br.com.pipa.score.repository.UserScoreData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScorePointsService {

    @Autowired
    private UserScoreData data;

    public ScorePointsDTO addPoints(Integer userId, Integer points) throws ZeroOrNegativeParamException, NullParamException {

        try {
            validate(userId, "userID");
            validate(points, "points");
        } catch (ZeroOrNegativeParamException e) {
            e.printStackTrace();
            throw new ZeroOrNegativeParamException(e.getMessage());
        } catch (NullParamException e) {
            e.printStackTrace();
            throw new NullParamException(e.getMessage());
        }

        UserPositionDTO dto = data.getScorePointsByUserId(userId);

        if(dto != null) {
            dto.setScorePoints(dto.getScorePoints() + points);
        } else {
            dto = new UserPositionDTO();
            dto.setUserId(userId);
            dto.setScorePoints(points);
        }

        data.save(dto);

        ScorePointsDTO scorePointsDTO = new ScorePointsDTO(userId, points);

        return scorePointsDTO;
    }

    public UserPositionDTO getUserPositionByUserId(Integer userId)  throws ZeroOrNegativeParamException, NullParamException {

        try {
            validate(userId, "userID");
        } catch (ZeroOrNegativeParamException e) {
            e.printStackTrace();
            throw new ZeroOrNegativeParamException(e.getMessage());
        } catch (NullParamException e) {
            e.printStackTrace();
            throw new NullParamException(e.getMessage());
        }

        UserPositionDTO userPositionDTO = data.getScorePointsByUserId(userId);

        if(userPositionDTO == null) {
            userPositionDTO = new UserPositionDTO();
        }

        return userPositionDTO;
    }

    public HighScoreDTO getHighScoreList() {
        List<UserPositionDTO> list = data.getTopScores(20000);

        if(list.isEmpty()) {
            UserPositionDTO userDTO = new UserPositionDTO();
            List<UserPositionDTO> returnList = new ArrayList<UserPositionDTO>();
            list.add(userDTO);
        }

        return new HighScoreDTO(list);
    }

    private boolean validate(Integer param, String paramName) throws NullParamException, ZeroOrNegativeParamException {

        if(param == null) {
            throw new NullParamException("parametro_nao_nulo");
        }

        if(param <= 0) {
            throw new ZeroOrNegativeParamException("parametro_positivo");
        }

        return true;
    }
}