import java.io.*;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static char[][] board;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int max = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        dfs();
        System.out.println(max);
    }

    static class Node_1987 {
        int row;
        int col;
        String str;

        Node_1987(int row, int col, String str) {
            this.row = row;
            this.col = col;
            this.str = str;
        }
    }

    static void dfs() {
        Stack<Node_1987> stack = new Stack<>();
        String temp = "" + board[0][0];
        stack.push(new Node_1987(0, 0, temp));

        while (!stack.isEmpty()) {
            if (max == 26) {
                break;
            }

            Node_1987 node = stack.pop();
            for (int i = 0; i < 4; i++) {
                int nr = node.row + dr[i];
                int nc = node.col + dc[i];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (node.str.contains("" + board[nr][nc])) {
                        if (max < node.str.length()) {
                            max = node.str.length();
                        }
                    } else {
                        stack.push(new Node_1987(nr, nc, node.str + board[nr][nc]));
                    }
                }
            }
        }
    }
}
