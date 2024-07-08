import java.util.*;

public class Main {
    static int[] numbers;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        numbers = new int[N];
        visited = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i+1;
        }

        duplication_comb(N, 0, M);
        System.out.println(sb);
    }

    static void duplication_comb(int n, int start, int r) {
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < visited[i]; j++) {
                    sb.append(numbers[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i]++;
            duplication_comb(n, i, r-1);
            visited[i]--;
        }
    }
}
