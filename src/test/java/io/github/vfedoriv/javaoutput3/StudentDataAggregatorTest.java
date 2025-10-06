package io.github.vfedoriv.javaoutput3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class StudentDataAggregatorTest {

    @Test
    public void testAddScores() {
        List<Integer> scores = Arrays.asList(90, 80, 70);
        int expectedSum = 240;
        int result = StudentDataAggregator.addScores(scores);
        Assertions.assertEquals(expectedSum, result);
    }

    @Test
    public void testCalculateAverage() {
        List<Integer> scores = Arrays.asList(90, 80, 70);
        double expectedAverage = 80.0;
        double result = StudentDataAggregator.calculateAverage(scores);
        Assertions.assertEquals(expectedAverage, result);
    }

    @Test
    public void testAddScoresEmptyList() {
        List<Integer> scores = Arrays.asList();
        int expectedSum = 0;
        int result = StudentDataAggregator.addScores(scores);
        Assertions.assertEquals(expectedSum, result);
    }

    @Test
    public void testCalculateAverageEmptyList() {
        List<Integer> scores = Arrays.asList();
        double expectedAverage = 0.0;
        double result = StudentDataAggregator.calculateAverage(scores);
        Assertions.assertEquals(expectedAverage, result);
    }

    @Test
    public void testCalculateAverageSingleScore() {
        List<Integer> scores = Arrays.asList(100);
        double expectedAverage = 100.0;
        double result = StudentDataAggregator.calculateAverage(scores);
        Assertions.assertEquals(expectedAverage, result);
    }
}