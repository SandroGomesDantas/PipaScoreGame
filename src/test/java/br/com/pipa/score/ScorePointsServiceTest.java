package br.com.pipa.score;

import br.com.pipa.score.service.ScorePointsService;
import br.com.pipa.score.dto.ScorePointsDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ScorePointsService.class})
public class ScorePointsServiceTest {

    @Autowired
    private ScorePointsService service;

    @Test
    public void testarSaveScorePointsUserIdZero() {

        ScorePointsDTO dto = service.addPoints(1, 1000);

        Assert.assertNotNull(dto);
    }
}
