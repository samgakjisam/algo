import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr = new int[9];

    public static void sol(int l, int r) {
        if (r == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = l; i <= n; i++) {
            arr[r] = i;
            sol(i, r + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        sol(1, 0);

        sc.close();
    }
}
