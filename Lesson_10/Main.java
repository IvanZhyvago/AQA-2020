package Lesson_10;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    private static final String pathToFile = System.getProperty("user.dir") + File.separator + "alice.txt";

    public Set<String> readFileSet(Path path) throws IOException {
        BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.US_ASCII);
        Set<String> result = new TreeSet<>();
        String forCheckNull;
        while ((forCheckNull = reader.readLine()) != null) {
            result.addAll(Arrays.asList(forCheckNull.split("\\W+")));
        }
        return result;
    }

    public LinkedList<String> readFileMap(Path path) throws IOException {
        BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.US_ASCII);
        LinkedList<String> result = new LinkedList <>();
        String forCheckNull;
        while ((forCheckNull = reader.readLine()) != null) {
            result.addAll(Arrays.asList(forCheckNull.split("\\W+")));
        }
        return result;
    }




    public static void main(String[] args) throws IOException {
        Main main = new Main () ;
        Path file = Paths.get (pathToFile);

        Set<String> uniqueWords = main.readFileSet (file);
        //System.out.println("Unique words in file: " + uniqueWords);
        System.out.println("Unique words in file: " + uniqueWords.size());
        //System.out.println(main.readFileMap(file));
        LinkedList<String> allWords = main.readFileMap(file);
        Map <String, Integer> occurrences = new HashMap <String, Integer>();
        int i = 0;
        for (String words : uniqueWords ) {
            System.out.print(words + " : ");
            i =0;
            for (String words2 :allWords){
                if (words.equals(words2)){
                    occurrences.put(words2,i);
                    i++;

            }
            }
            System.out.println(i + " times"); // starts with 1 first number
            System.out.println("Counting with MAP: " + words + " " + occurrences.get(words) + " times" ); // starts with 0 first number
        }

    }
}

