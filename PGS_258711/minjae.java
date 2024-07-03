import java.util.*;

class Solution {
    static int[] answer = {0, 0, 0, 0};
    static int max_node = 0;
    static boolean[] visited;
    static int[][] io_info;
    static int total_graph = 0;
    static ArrayList<Queue<Integer>> list = new ArrayList<>();
    
    public int[] solution(int[][] edges) {
        // 정점 최댓값
        for (int i = 0; i < edges.length; i++) {
            max_node = Math.max(max_node, edges[i][0]);
            max_node = Math.max(max_node, edges[i][1]);
        }
        
        // 입출력 그래프 만들기
        for (int i = 0; i <= max_node; i++) {
            list.add(i, new LinkedList<>());
        }
        
        // 정점 방문처리 초기 세팅
        visited = new boolean[max_node+1];
        for (int i = 0; i <= max_node; i++) {
            visited[i] = true;
        }
        
        for (int i = 0; i < edges.length; i++) {
            visited[edges[i][0]] = false;
            visited[edges[i][1]] = false;
        }
        
        // 각 정점의 입,출력 갯수 파악
        io_info = new int[max_node+1][2];
        for (int i = 0; i < edges.length; i++) {
            io_info[edges[i][0]][0]++;
            io_info[edges[i][1]][1]++;
            list.get(edges[i][0]).add(edges[i][1]);
        }
        
        // 새롭게 추가된 정점
        for (int i = 1; i <= max_node; i++) {
            if (io_info[i][0] >= 2 && io_info[i][1] == 0) {
                answer[0] = i;
                visited[i] = true;
                total_graph = io_info[i][0];
            }
        }
        
        for (int n : list.get(answer[0])) {
            io_info[n][1]--;
        }
        
        // 8자 그래프의 센터, 막대 그래프의 시작점
        Queue<Integer> eight_q = new LinkedList<>();
        Queue<Integer> line_q = new LinkedList<>();
        for (int i = 1; i <= max_node; i++) {
            if (io_info[i][0] == 2 && io_info[i][1] >= 2) {
                int next = list.get(i).poll();
                eight_q.add(next);
                visited[next] = true;
            } else if (io_info[i][0] == 1 && io_info[i][1] == 0) {
                line_q.add(i);
                visited[i] = true;
            }
        }
        
        // 그래프 찾기
        while (!eight_q.isEmpty()) {
            eight_search(eight_q.poll());
        }
        
        while (!line_q.isEmpty()) {
            line_search(line_q.poll());
        }
        
        for (int i = 1; i <= max_node; i++) {
            if (!visited[i] && io_info[i][0] == 0) {
                answer[2]++;
            }
        }
        
        answer[1] = total_graph - answer[2] - answer[3];
        return answer;
    }
    
    static void eight_search(int node) {
        int next_node = list.get(node).poll();
        visited[next_node] = true;
        
        while (true) {
            if (list.get(next_node).isEmpty()) {
                answer[3]++;
                break;
            }
            
            next_node = list.get(next_node).poll();
            visited[next_node] = true;
        }
    }
    
    static void line_search(int node) {
        int next_node = list.get(node).poll();
        visited[next_node] = true;
        
        while (true) {
            if (list.get(next_node).isEmpty()) {
                answer[2]++;
                break;
            }
            
            next_node = list.get(next_node).poll();
            visited[next_node] = true;
        }
    }
}