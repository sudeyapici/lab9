import java.io.*;
import java.util.Scanner;

public class WordAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();


        String[] words = new String[1000];
        int[] counts = new int[1000];
        int uniqueCount = 0;
        int totalWords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] lineWords = line.toLowerCase().split("\\W+");

                for (String w : lineWords) {

                    if (!w.isEmpty()) {
                        totalWords++;

                        int index = -1;


                        for (int i = 0; i < uniqueCount; i++) {
                            if (words[i].equals(w)) {
                                index = i;
                                break;
                            }
                        }

                        if (index == -1) {

                            words[uniqueCount] = w;
                            counts[uniqueCount] = 1;
                            uniqueCount++;
                        } else {

                            counts[index]++;
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file!");
            return;
        }


        System.out.println("Total Words: " + totalWords);
        System.out.println("Unique Words: " + uniqueCount);

        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(words[i] + ": " + counts[i]);
        }


        try (PrintWriter writer = new PrintWriter(new FileWriter("word_stats.txt"))) {

            writer.println("Total Words: " + totalWords);
            writer.println("Unique Words: " + uniqueCount);

            for (int i = 0; i < uniqueCount; i++) {
                writer.println(words[i] + ": " + counts[i]);
            }

        } catch (IOException e) {
            System.out.println("Error writing file!");
        }


    }
}

