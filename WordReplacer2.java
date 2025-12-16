import java.io.*;
import java.util.Scanner;

public class WordReplacer2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input file path: ");
        String inputPath = scanner.nextLine();

        System.out.print("Word to be replaced: ");
        String oldWord = scanner.nextLine();

        System.out.print("Replacement word: ");
        String newWord = scanner.nextLine();

        System.out.print("Output file path: ");
        String outputPath = scanner.nextLine();

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputPath));
                PrintWriter writer = new PrintWriter(new FileWriter(outputPath))
        ) {

            String line;

            while ((line = reader.readLine()) != null) {
                line = line.replace(oldWord, newWord);
                writer.println(line);
            }

            System.out.println(
                    "Replaced '" + oldWord + "' with '" + newWord + "' in "
                            + inputPath + " → " + outputPath
            );

        } catch (IOException e) {
            System.out.println("File error!");
        }


    }
}
