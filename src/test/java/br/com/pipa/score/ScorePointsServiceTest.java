package br.com.pipa.score;

import br.com.pipa.score.exception.NullParamException;
import br.com.pipa.score.exception.ZeroOrNegativeParamException;
import br.com.pipa.score.repository.UserScoreData;
import br.com.pipa.score.service.ScorePointsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ScorePointsService.class})
public class ScorePointsServiceTest {

    @Autowired
    private ScorePointsService service;

    @MockBean
    private UserScoreData data;

    @Test
    public void addPointsSucessfull() {
        Assert.assertNotNull(service.addPoints(1, 1000));
    }

    @Test(expected = NullParamException.class)
    public void addPointsUserIdNull() {
        Assert.assertNotNull(service.addPoints(null, 1000));
    }

    @Test(expected = NullParamException.class)
    public void addPointsPointsNull() {
        Assert.assertNotNull(service.addPoints(1, null));
    }

    @Test(expected = ZeroOrNegativeParamException.class)
    public void addPointsPointsZero() {
        Assert.assertNotNull(service.addPoints(1, 0));
    }

    @Test(expected = ZeroOrNegativeParamException.class)
    public void addPointsUserIdZero() {
        Assert.assertNotNull(service.addPoints(0, 1000));
    }

    @Test(expected = ZeroOrNegativeParamException.class)
    public void addPointsUserIdNegative() {
        Assert.assertNotNull(service.addPoints(-1, 1000));
    }

    @Test(expected = ZeroOrNegativeParamException.class)
    public void addPointsPointsNegative() {
        Assert.assertNotNull(service.addPoints(1, -1000));
    }

    @Test
    public void getUserPositionByUserIdSucessfull() {
        Assert.assertNotNull(service.getUserPositionByUserId(1));
    }

    @Test(expected = NullParamException.class)
    public void getUserPositionByUserIdUserIdNull() {
        Assert.assertNotNull(service.getUserPositionByUserId(null));
    }

    @Test(expected = ZeroOrNegativeParamException.class)
    public void getUserPositionByUserIdUserIdZero() {
        Assert.assertNotNull(service.getUserPositionByUserId(0));
    }

    @Test(expected = ZeroOrNegativeParamException.class)
    public void getUserPositionByUserIdUserIdNegative() {
        Assert.assertNotNull(service.getUserPositionByUserId(-1));
    }

    @Test
    public void getHighScoreListTest() {
        Assert.assertNotNull(service.getHighScoreList());
    }

}
