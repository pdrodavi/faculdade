package questao01;

public class Fatorial {
    
    public static long fatorial(long num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * fatorial(num - 1);
        }
    }
    
}
