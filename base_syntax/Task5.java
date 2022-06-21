package base_syntax;

public class Task5 {
    public static void main(String[] args) {
        double [] array = new double[100000];
        double max = 0, sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (Math.random()*98)+2;
            if(array[i] > max)
                max = array[i];
            sum+=array[i];
        }
        System.out.println("Max element - "+max);
        System.out.println("Arithmetic mean - "+(sum/array.length));
        
    }
}