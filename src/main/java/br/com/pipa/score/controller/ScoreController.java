package br.com.pipa.score.controller;

import br.com.pipa.score.dto.HighScoreDTO;
import br.com.pipa.score.dto.ScorePointsDTO;
import br.com.pipa.score.dto.ScorePointsRequestDTO;
import br.com.pipa.score.dto.UserPositionDTO;
import br.com.pipa.score.service.ScorePointsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/scoreControl")
@Api(description = "[ /scoreControl ] - Score Control API", tags = {"Score Control"})
public class ScoreController {

    @Autowired
    private ScorePointsService score;

    @PostMapping(params = "apiVersion=1")
    @ApiOperation(value = "AddUserScorePoints", response = ScorePointsDTO.class, responseContainer = "ScorePointsDTO")
    public ResponseEntity<ScorePointsDTO> addUserScorePoints(@RequestBody ScorePointsRequestDTO request) {

        log.debug(" ");
        log.debug(" ScoreController.saveScorePoints ");
        log.debug(" Request: " + request);
        log.debug(" ");

        ScorePointsDTO result = score.addPoints(request.getUserId(), request.getScorePoints());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(params = "apiVersion=1", value = "{userId}")
    @ApiOperation(value = "GetUserScore", response = ScorePointsDTO.class, responseContainer = "ScorePointsDTO")
    public ResponseEntity<UserPositionDTO> getUsersScore(@PathVariable Integer userId) {

        log.debug(" ");
        log.debug(" ScoreController.getUsersScore ");
        log.debug(" userId: " + userId);
        log.debug(" ");

        UserPositionDTO result = score.getUserPositionByUserId(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(params = "apiVersion=1")
    @ApiOperation(value = "GetHighScoreList", response = HighScoreDTO.class, responseContainer = "HighScoreDTO")
    public ResponseEntity<HighScoreDTO> getHighScoreList() {

        log.debug(" ");
        log.debug(" ScoreController.getHighScoreList ");
        log.debug(" ");

        HighScoreDTO result = score.getHighScoreList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}