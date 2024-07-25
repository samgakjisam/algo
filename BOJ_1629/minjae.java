import java.util.*;

public class Main {
    static long C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        C = sc.nextLong();

        long ans = pow(A, B);
        System.out.println(ans % C);
    }

    static long pow(long num, long n) {
        if (n == 1) {
            return num % C;
        } else {
            long x = pow(num, n / 2) % C;
            if (n % 2 == 0) {
                return x * x % C;
            } else {
                return (x * x % C) * num % C;
            }
        }
    }
}
