package BOJ_2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class kiyong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<int[]> Q = new LinkedList<>();
        int[] sideNum = new int[4];
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            Q.add(new int[] {dir, dis});
            sideNum[dir-1]++;
        }

        int i = 0;
        int bigSquare = 1;
        int smallSquare = 1;
        int cnt = 0;
        while (true) {
            int[] q = Q.poll();
            Q.add(q);
            if (sideNum[q[0]-1] == 1) {
                cnt++;
                if (cnt > 2) {
                    break;
                }
                bigSquare *= q[1];
            } else if (cnt >= 1 && i==0 && sideNum[q[0]-1] == 2) {
                i++;
            } else if (cnt >= 1 && i==1 && sideNum[q[0]-1] == 2) {
                i++;
                smallSquare *= q[1];
            } else if (cnt >= 1 && i==2 && sideNum[q[0]-1] == 2) {
                i++;
                smallSquare *= q[1];
            }
        }
        System.out.println((bigSquare-smallSquare)*N);
    }
}
