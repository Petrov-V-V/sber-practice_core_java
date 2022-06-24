package java_io.sorting_names;

public class NamesSortingProgram {
    public static void main(String[] args) {
        String inputFile = "java_io\\sorting_names\\listNames.txt";
        String outputFile = "java_io\\sorting_names\\NewlistNames.txt";
        NamesSorting.sortNames(inputFile, outputFile);
    }
}