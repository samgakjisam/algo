import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int cnt = 0;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            board[0][i]++;
            visit(0, i);
            backtracking(N, 1);
            board[0][i]--;
            unvisit(0, i);
        }
        System.out.println(cnt);
    }

    static void backtracking(int n, int row) {
        if (n == 1) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (board[row][i] == 0) {
                board[row][i]++;
                visit(row, i);
                backtracking(n-1, row+1);
                board[row][i]--;
                unvisit(row, i);
            }
        }
    }

    static void visit(int row, int col) {
        int k = 1;
        while (k < N) {
            for (int i = 0; i < 8; i++) {
                int nr = row + dr[i] * k;
                int nc = col + dc[i] * k;

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    board[nr][nc]++;
                }
            }
            k++;
        }
    }

    static void unvisit(int row, int col) {
        int k = 1;
        while (k < N) {
            for (int i = 0; i < 8; i++) {
                int nr = row + dr[i] * k;
                int nc = col + dc[i] * k;

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    board[nr][nc]--;
                }
            }
            k++;
        }
    }
}
