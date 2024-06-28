import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = 0;
        for (String friend : friends) {
            N++;
        }
        int [][] sends = new int[N][N];
        int[] points = new int[N];
        int[] results = new int[N];
        for (String gift : gifts) {
            String[] tmp = gift.split(" ");
            int from = 0;
            int to = 0;
            while (!friends[from].equals(tmp[0])) {
                from++;
            }
            while (!friends[to].equals(tmp[1])) {
                to++;
            }
            sends[from][to]++;
            points[from]++;
            points[to]--;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (sends[i][j] > sends[j][i]) {
                    results[i]++;
                } else if (sends[i][j] < sends[j][i]) {
                    results[j]++;
                } else {
                    if (points[i] > points[j]) {
                        results[i]++;
                    } else if (points[i] < points[j]) {
                        results[j]++;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (answer < results[i]) {
                answer = results[i];
            }
        }
        return answer;
    }
}
