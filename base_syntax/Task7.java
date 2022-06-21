package base_syntax;

public class Task7 {
    static public void fibonacci(int num){
        int a = 1, b = 1;
        System.out.print(a+" "+b+" ");
        for(int i=2; i < num; i++){
            int tmp = b;
            b+=a;
            a=tmp;
            System.out.print(b+" ");
        }
    }
    public static void main(String[] args) {
        int num = 11;
        fibonacci(num);
    }
}