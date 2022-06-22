package oop_1.Task3;

public class Matrix {
    private int[][] matrix;
    private int rows;
    private int columns;

    public Matrix(int[][] matrix){
        rows = matrix.length;
        columns = matrix[0].length;
        this.matrix = matrix;
    }

    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        matrix = new int[rows][columns]; 
    }

    public void setValue(int i, int j, int value){
        matrix[i][j] = value;
    }

    public int getValue(int i, int j){
        return matrix[i][j];
    }

    public int[][] addnMatrix(Matrix matrix){
        int[][] sumMatrix = new int[rows][columns];
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                sumMatrix [i][j] = this.matrix[i][j] + matrix.getValue(i, j);
        return sumMatrix;
    }

    public int[][] multMatrix(Matrix matrix){
        int[][] prodMatrix = new int[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                prodMatrix[i][j] = this.matrix[i][j] * matrix.getValue(i, j);
        return prodMatrix;
    }

    public void multValue(int value){
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] *= value;
    }

    public void printMatrix(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}