import java.util.*;

public class Main {
    static final long MOD = 1000000007;
    static long[][] origin = {{1, 1}, {1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[][] A = {{1, 1}, {1, 0}};

        System.out.println(pow(A, n-1)[0][0]);
    }

    static long[][] pow(long[][] A, long exp) {
        if (exp == 1 || exp == 0) {
            return A;
        }

        long[][] ret = pow(A, exp/2);
        ret = multiply(ret, ret);

        if (exp % 2 == 1) {
            ret = multiply(ret, origin);
        }

        return ret;
    }

    // o1과 o2 행렬을 곱해주는 메서드
    static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] ret = new long[2][2];
        ret[0][0] = (o1[0][0] * o2[0][0] + o1[0][1] * o2[1][0]) % MOD;
        ret[0][1] = (o1[0][0] * o2[0][1] + o1[0][1] * o2[1][1]) % MOD;
        ret[1][0] = (o1[1][0] * o2[0][0] + o1[1][1] * o2[1][0]) % MOD;
        ret[1][1] = (o1[1][0] * o2[0][1] + o1[1][1] * o2[1][1]) % MOD;

        return ret;
    }
}
