import java.util.*;

class Solution {
    static int[] answer = {0, 0, 0, 0};
    static int max_node;
    static boolean[] visited;
    
    public int[] solution(int[][] edges) {
        // 간선 오름차순 정렬
        Arrays.sort(edges, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        
        // 정점 최댓값
        max_node = edges[edges.length-1][1];
        for (int i = 0; i < edges.length; i++) {
            max_node = Math.max(max_node, edges[i][0]);
        }
        
        // 정점 중 새롭게 추가가 가능한 정점 판별(false가 새롭게 추가된 정점 후보)
        boolean[] nodes = new boolean[max_node+1];
        visited = new boolean[max_node+1];
        nodes[0] = visited[0] = true;
        for (int i = 0; i < edges.length; i++) {
            nodes[edges[i][1]] = true;
        }
        
        // 그래프 찾기
        for (int i = 1; i <= max_node; i++) {
            if (!nodes[i]) {
                graph(i, edges);
            }
        }
        
        return answer;
    }
    
    static void graph(int node_num, int[][] edges) {
        // 후보 정점을 제외한 각 정점의 io 갯수 파악
        int[][] io_relation = new int[max_node+1][2];
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= max_node; i++) {
            list.add(i, new LinkedList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] != node_num && edges[i][1] != node_num) {
                list.get(edges[i][0]).add(edges[i][1]);
                io_relation[edges[i][0]][0]++;
                io_relation[edges[i][1]][1]++;
            }
        }
        
        Stack<Integer> stack = new Stack<>();
        // 후보 정점이 맞는지?
        for (int i = 1; i <= max_node; i++) {
            if (io_relation[i][0] == 0 || io_relation[i][0] == 1) {
                if (io_relation[i][1] >= 2) {
                    return;
                }
            } else if (io_relation[i][0] == 2) {
                if (io_relation[i][1] == 2) {
                    stack.push(i);
                } else {
                    return;
                }
            }
        }
        answer[0] = node_num;
        visited[node_num] = true;
        
        // 8자 그래프 찾기
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            
            while (true) {
                cur = list.get(cur).poll();
                if (visited[cur]) {
                    break;
                }
                visited[cur] = true;
            }
            answer[3]++;
        }
        
        // 막대 찾기
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= max_node; i++) {
            if (!visited[i] && io_relation[i][1] == 0) {
                q.add(i);
                visited[i] = true;
            }
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            while (true) {
                if (list.get(cur).isEmpty()) {
                    break;
                } else {
                    cur = list.get(cur).poll();
                    visited[cur] = true;
                }
            }
            answer[2]++;
        }
        
        // 도넛 찾기
        for (int i = 1; i <= max_node; i++) {
            if (!visited[i]) {
                q.add(i);
                visited[i] = true;
                
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    
                    while (true) {
                        cur = list.get(cur).poll();
                        if (visited[cur]) {
                            break;
                        }
                        visited[cur] = true;
                    }
                    answer[1]++;
                }
            }
        }
    }
}