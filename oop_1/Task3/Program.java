package oop_1.Task3;

public class Program {
    public static void main(String[] args) {
        int[][] m1 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int[][] m2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Matrix matrix1 = new Matrix(m1);
        Matrix matrix2 = new Matrix(m2);
        
        Matrix matrix3 = new Matrix(matrix1.addnMatrix(matrix2));
        matrix3.printMatrix();
        matrix3 = new Matrix(matrix1.multMatrix(matrix2));
        matrix3.printMatrix();

        matrix1.multValue(2);
        matrix1.printMatrix();

        matrix1.setValue(1, 1, 99);
        matrix1.printMatrix();
    }
}