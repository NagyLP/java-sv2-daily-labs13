package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileReaderTest {

    @Test
    void readFileTest() {

        FileReader fileReader = new FileReader();
        Path path = Path.of("src/test/resources/result.txt");

        fileReader.readFile(path);

        assertTrue(fileReader.getAnswers().keySet().contains("AH2"));
    }

    @Test
    void isRightAnswerTest() {
        FileReader fileReader = new FileReader();
        Path path = Path.of("src/test/resources/result.txt");

        fileReader.readFile(path);

        assertTrue(fileReader.isRightAnswer("AH2", 2));
    }

    @Test
    void getWinnerTest() {
        FileReader fileReader = new FileReader();
        Path path = Path.of("src/test/resources/result.txt");

        fileReader.readFile(path);

        assertEquals("AH2", fileReader.getWinner());
    }
}
