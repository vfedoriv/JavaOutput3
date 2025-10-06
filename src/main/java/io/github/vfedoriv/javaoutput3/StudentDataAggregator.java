package io.github.vfedoriv.javaoutput3;

import java.util.List;

public class StudentDataAggregator {

    public int addScores(List<Integer> scores) {
        if (scores == null || scores.isEmpty()) {
            throw new IllegalArgumentException("Scores list cannot be null or empty.");
        }
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    public double calculateAverage(List<Integer> scores) {
        if (scores == null || scores.isEmpty()) {
            throw new IllegalArgumentException("Scores list cannot be null or empty.");
        }
        int total = addScores(scores);
        return total / (double) scores.size();
    }
}