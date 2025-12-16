import java.io.*;
import java.util.Scanner;

public class WordReplacer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter input file path: ");
        String inputPath = scanner.nextLine();

        System.out.print("Enter word to be replaced: ");
        String oldWord = scanner.nextLine();

        System.out.print("Enter replacement word: ");
        String newWord = scanner.nextLine();

        System.out.print("Enter output file path: ");
        String outputPath = scanner.nextLine();

        try (
                BufferedReader br = new BufferedReader(new FileReader(inputPath));
                PrintWriter writer = new PrintWriter(new FileWriter(outputPath))
        ) {

            String line;

            while ((line = br.readLine()) != null) {
                String modifiedLine = line.replace(oldWord, newWord);
                writer.println(modifiedLine);
            }

        } catch (IOException e) {
            System.out.println("File error!");
            return;
        }

        System.out.println(
                "Replaced '" + oldWord + "' with '" + newWord +
                        "' in " + inputPath + " → " + outputPath
        );


    }
}

