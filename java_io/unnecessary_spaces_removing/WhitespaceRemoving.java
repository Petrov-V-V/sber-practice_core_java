package java_io.unnecessary_spaces_removing;

import java.io.*;

public class WhitespaceRemoving {
    public static void deleteWhitespaces(String inputFile, String outputFile) {
        try (BufferedReader buffReader = new BufferedReader(new FileReader(inputFile)); 
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(outputFile))){
                String line;
                while((line = buffReader.readLine()) != null){
                    buffWriter.write(line.replaceAll("\s{2,}", " ") + "\n");
                }
        } catch(IOException exeption) {
            System.out.println(exeption.getMessage());
        }
    }
}