package jp.ac.uryukyu.ie.e235712;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
 
public class ScoreCalculationTest {

    @Test
    public void testQuestionBWithPinfu() {
        String[] args = {};
        int ork = 0; // 親
        String expectedPoints = "2000"; // 一飜平和の場合の期待される得点

        String actualPoints = ScoreCalculation.questionB(args, ork);

        assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testQuestionBWithTitoi() {
        String[] args = {};
        int ork = 1; // 子
        // 一飜の場合の得点
        String expectedPoints = "1300";

        String actualPoints = ScoreCalculation.questionB(args, ork);

        assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testQuestionBWithMinkan() {
        String[] args = {};
        int ork = 0; // 親
        // 四飜の場合の得点
        String expectedPoints = "満貫12000";

        String actualPoints = ScoreCalculation.questionB(args, ork);

        assertEquals(expectedPoints, actualPoints);
    }
}