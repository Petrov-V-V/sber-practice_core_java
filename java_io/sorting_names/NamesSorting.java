package java_io.sorting_names;

import java.io.*;
import java.util.Arrays;

public class NamesSorting {
    public static void sortNames(String inputFile, String outputFile) {
        try(BufferedReader buffReader = new BufferedReader(new FileReader(inputFile)); 
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(outputFile))){    
            String line = buffReader.readLine(); 
            String[] namesArr = line.split(", ");
            Arrays.sort(namesArr); 
            for (int i = 0; i < namesArr.length; i++) {
                buffWriter.write(namesArr[i] + "\n");
            }
        } catch (IOException exeption){
           System.out.println(exeption.getMessage());
        }
    }
}