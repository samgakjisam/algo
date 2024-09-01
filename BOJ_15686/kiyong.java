import java.util.*;
import java.io.*;

class Point {
    int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static ArrayList<Point[]> chickenCombList = new ArrayList<>();
    static int M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        ArrayList<Point> chickenList = new ArrayList<>();
        ArrayList<Point> homeList = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    homeList.add(new Point(i, j));
                }
                if (tmp == 2) {
                    chickenList.add(new Point(i, j));
                }
            }
        }

        Point[] chickenArray = chickenList.toArray(new Point[0]);
        Point[] homeArray = homeList.toArray(new Point[0]);
        int chickenCount = chickenArray.length;
        boolean[] visited = new boolean[chickenCount];
        
        comb(chickenArray, visited, 0, chickenCount, M);

        Point[][] chickenCombArray = chickenCombList.toArray(new Point[0][0]);

        int min_d = 1300;
        for (Point[] chickenComb : chickenCombArray) {
            int min_total = 0;
            for (Point home : homeArray) {
                int min_tmp = 100;
                for (Point chicken : chickenComb) {
                    int d_tmp = Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
                    if (min_tmp > d_tmp) {
                        min_tmp = d_tmp;
                    }
                }
                min_total += min_tmp;
            }
            if (min_d > min_total) {
                min_d = min_total;
            }
        }
        
        System.out.println(min_d);
    }

    static void comb(Point[] arr, boolean[] vis, int s, int n, int r) {
        if (r == 0) {
            Point[] tmp = new Point[M];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (vis[i]) {
                    tmp[idx] = arr[i];
                    idx++;
                }
            }
            chickenCombList.add(tmp);
            return;
        }
        for (int i = s; i < n; i++) {
            vis[i] = true;
            comb(arr, vis, i + 1, n, r - 1);
            vis[i] = false;
        }
    }
}
