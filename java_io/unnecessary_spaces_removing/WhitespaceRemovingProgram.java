package java_io.unnecessary_spaces_removing;

public class WhitespaceRemovingProgram {
    public static void main(String[] args) {
        String inputFile = "java_io\\unnecessary_spaces_removing\\Borodino.txt";
        String outputFile = "java_io\\unnecessary_spaces_removing\\NewBorodino.txt";
        WhitespaceRemoving.deleteWhitespaces(inputFile, outputFile);
    }
}