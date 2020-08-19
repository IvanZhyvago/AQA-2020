package Lesson_9;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;


public class Nio {
        Nio () {
        }

        private static final String home1 = System.getProperty("user.dir")+ File.separator + "txt.txt";
        private static final String home2 = System.getProperty("user.dir")+ File.separator + "txt2.txt";

        public Path getPath () {
        Path myFile = Paths.get(home1);
            return myFile;
        }


        public void writeToFile(String str, Path path, boolean append) throws IOException {
            if (append) {
                Files.write(path, str.getBytes(), StandardOpenOption.APPEND);
            }
            else {
                Files.write(path, str.getBytes());
            }
        }

        public String readFile() throws IOException {
            BufferedReader reader = Files.newBufferedReader(getPath(), StandardCharsets.US_ASCII);
            String forCheckNull;
            String currentLine = null;
            while((forCheckNull = reader.readLine()) != null){
                currentLine = forCheckNull;
            }
            return currentLine;
        }

        public ArrayList<String> readFile2(Path path) throws IOException {
             BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.US_ASCII);
             ArrayList<String> allLine = new ArrayList<>(1000);
             String forCheckNull;
             while((forCheckNull = reader.readLine()) != null){
                 allLine.add(forCheckNull);
             }
             return allLine;
    }


    public static void main(String[] args) throws IOException {
            Nio nio = new Nio ();


            System.out.println(nio.getPath ());



            String question = "Line #1\n Line #2 \n Line #3 \n Line #4\n " +
                    "Line #5\n Line #6 \n Line #7 \n Line #8\n " +
                    "Line #9\n Line #10 \n Line #11 \n Line #12\n " +
                    "Line #13\n Line #14 \n Line #15 \n Line #16\n ";
            nio.writeToFile (question, nio.getPath(), false);
            //System.out.println(nio.readFile ());
            //System.out.println(nio.readFile2(nio.getPath()));

            Path myFile2 = Paths.get(home2);;
            for (int i = nio.readFile2(nio.getPath ()).size() - 11; i< nio.readFile2(nio.getPath ()).size(); i++) {
                nio.writeToFile (nio.readFile2(nio.getPath ()).get(i), myFile2, true);
            }
            System.out.println(nio.readFile2(myFile2));



        }
}
