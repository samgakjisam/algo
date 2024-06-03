import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] paper;
    static int white_paper = 0;
    static int blue_paper = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dac(0, N, 0, N);
        System.out.println(white_paper);
        System.out.println(blue_paper);
    }

    static void dac(int s_row, int e_row, int s_col, int e_col) {
        int white_cnt = 0;
        int blue_cnt = 0;

        // 체크
        for (int i = s_row; i < e_row; i++) {
            for (int j = s_col; j < e_col; j++) {
                if (paper[i][j] == 1) {
                    blue_cnt++;
                } else if (paper[i][j] == 0) {
                    white_cnt++;
                }
            }
        }

        if (white_cnt == 0) {
            blue_paper++;
        } else if (blue_cnt == 0) {
            white_paper++;
        } else {
            int m_row = (s_row + e_row) / 2;
            int m_col = (s_col + e_col) / 2;

            dac(s_row, m_row, s_col, m_col);
            dac(s_row, m_row, m_col, e_col);
            dac(m_row, e_row, s_col, m_col);
            dac(m_row, e_row, m_col, e_col);
        }
    }
}
