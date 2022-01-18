package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileReader {

    private Map<String, String> answers = new HashMap<>();
    private String rightAnswers;

    public Map<String, String> getAnswers() {
        return answers;
    }

    public void readFile(Path path) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found");
        }

        rightAnswers = lines.get(0);
        lines.remove(lines.get(0));

        for (String actual : lines) {
            String[] parts = actual.split(" ");

            if (answers.keySet().contains(parts[0])) {
                answers.put(parts[0], answers.get(parts[0]) + parts[1]);
            } else {
                answers.put(parts[0], parts[1]);
            }
        }
    }

    public boolean isRightAnswer(String userName, int numberOfQuestion) {

        for (Map.Entry<String, String> actual : answers.entrySet()) {
            if (userName.equals(actual.getKey())) {
                return rightAnswers.substring(numberOfQuestion - 1, numberOfQuestion).equals(actual.getValue().substring(numberOfQuestion - 1, numberOfQuestion));
            }
        }
        return false;
    }

    public String getWinner() {

        Map<String, Integer> pointsOfUser = new TreeMap<>();
        String winner = "";
        for (Map.Entry<String, String> actual : answers.entrySet()) {

            int maxPoints = 0;
            int points = 0;
            for (int i = 1; i <= rightAnswers.length(); i++) {
                if (isRightAnswer(actual.getKey(), i)) {
                    points += i;
                }
                if (!isRightAnswer(actual.getKey(), i) && actual.getValue().charAt(i - 1) == 'X') {
                    points -= 2;
                }
                if (points > maxPoints) {
                    maxPoints = points;
                    winner = actual.getKey();
                }
            }
            pointsOfUser.put(actual.getKey(), points);
        }
        return winner;
    }
}
