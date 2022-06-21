package base_syntax;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Что это такое: синий, большой, с усами и полностью набит зайцами?");
        int i = 0;
        while(i < 3){
            String answer = in.next();
            i++;
            if (answer.equals("Троллейбус") || answer.equals("троллейбус")){
                System.out.println("Правильно");
                break;
            } else if (answer.equals("Сдаюсь") || answer.equals("сдаюсь")){
                System.out.println("Правильный ответ: троллейбус");
                break;
            } else if (i != 3){
                System.out.println("Подумай ещё");
            } else {
                System.out.println("Правильный ответ: троллейбус");
            }
        }
        in.close();
    }
}