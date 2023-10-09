import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "D:\\marklum\\qwertyuiop\\src\\24_demo.txt"; // Укажите путь к вашему файлу

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int maxSequenceLength = 0;
            int currentSequenceLength = 0;
            boolean foundX = false;

            int character;
            while ((character = reader.read()) != -1) {
                char c = (char) character;
                if (c == 'X') {
                    currentSequenceLength++;
                    foundX = true;
                } else {
                    if (foundX) {
                        maxSequenceLength = Math.max(maxSequenceLength, currentSequenceLength);
                        currentSequenceLength = 0;
                        foundX = false;
                    }
                }
            }

            // Учтите, что последовательность 'X' может заканчиваться в конце файла.
            if (foundX) {
                maxSequenceLength = Math.max(maxSequenceLength, currentSequenceLength);
            }

            if (maxSequenceLength > 0) {
                System.out.println("Длина самой длинной последовательности 'X': " + maxSequenceLength);
            } else {
                System.out.println("Символ 'X' не найден в файле.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}