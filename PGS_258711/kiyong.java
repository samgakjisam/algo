import java.io.*;
import java.util.*;

class Solution {
    static Queue<Integer> q = new LinkedList<>();
    static int[][] graphOut;
    static int[][] graphIn;
    static boolean[] vis;
    static int outsiderNode;
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        // 어느 한 점에서만 나가는 선이 2개 이상, 들어오는 점 없음
        // 도넛 - 막대 - 8자
        graphOut = new int[1000001][2];
        graphIn = new int[1000001][2];
        vis = new boolean[1000001];
        
        for (int[] edge : edges) {
            if (graphOut[edge[0]][0] == 0) {
                graphOut[edge[0]][0] = edge[1];
            } else {
                if (graphOut[edge[0]][1] == 0) {
                    graphOut[edge[0]][1] = edge[1];
                } else {
                    continue;
                }
            }
            if (graphIn[edge[1]][0] == 0) {
                graphIn[edge[1]][0] = edge[0];
            } else {
                graphIn[edge[1]][1] = edge[0];
            }
        }
        
        for (int i = 1; i < 1000001; i++) {
            if (graphOut[i][1] != 0 && graphIn[i][0] == 0) {
                answer[0] = i;
                outsiderNode = i;
                vis[i] = true;
            }
        }
        
        for (int i = 1; i < 1000001; i++) {
            if (graphOut[i][0] == 0 && graphIn[i][0] != 0) {
                answer[2]++;
            }
            if (graphOut[i][1] != 0 && graphIn[i][1] != 0) {
                answer[3]++;
            }
        }
        

        return answer;
    }
    
    static void barBFS(int i) {
        vis[i] = true;
        for (int nextNode : graphIn[i]) {
            if (nextNode == outsiderNode) {
                continue;
            }
            q.offer(nextNode);
        }
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            vis[nowNode] = true;
            for (int nextNode : graphIn[nowNode]) {
                if (nextNode == outsiderNode) {
                    continue;
                }
                if (!vis[nextNode]) {
                    q.offer(nextNode);
                }
            }
        }
    }
    
    static void eightBFS(int i) {
        for (int nextNode : graphOut[i]) {
            q.offer(nextNode);
        }
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            vis[nowNode] = true;
            for (int nextNode : graphOut[nowNode]) {
                if (!vis[nextNode]) {
                    q.offer(nextNode);
                }
            }
        }
    }
    
    static void donutBFS(int i) {
        for (int nextNode : graphOut[i]) {
            q.offer(nextNode);
        }
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            vis[nowNode] = true;
            for (int nextNode : graphOut[nowNode]) {
                if (!vis[nextNode]) {
                    q.offer(nextNode);
                }
            }
        }
    }
}
