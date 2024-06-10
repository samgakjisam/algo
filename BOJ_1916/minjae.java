import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static ArrayList<Node>[] bus_info;
    static boolean[] visited;
    static int[] bus_cost;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점 갯수, 간선 갯수, 버스 노선의 정보 배열 생성
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        bus_info = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            bus_info[i] = new ArrayList<>();
        }

        // 버스 노선의 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start_idx = Integer.parseInt(st.nextToken());
            int end_idx = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            bus_info[start_idx].add(new Node(end_idx, cost));
        }

        visited = new boolean[N+1];
        bus_cost = new int[N+1];
        Arrays.fill(bus_cost, INF);

        // 출발지와 도착지 입력
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bus_cost[start] = 0;
        Dijkstra(start);
        System.out.println(bus_cost[end]);
    }

    static void Dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            int now_idx = pq.poll().node;

            if (visited[now_idx]) {
                continue;
            }
            visited[now_idx] = true;

            for(Node next_node : bus_info[now_idx]) {
                if (bus_cost[next_node.node] > bus_cost[now_idx] + next_node.cost) {
                    bus_cost[next_node.node] = bus_cost[now_idx] + next_node.cost;
                    pq.add(new Node(next_node.node, bus_cost[next_node.node]));
                }
            }
        }
    }
}

// 도착 정점번호와 비용을 담는 클래스(비용이 작은 순서로 정렬)
class Node implements Comparable<Node> {
    int node;
    int cost;

    // 정점번호, 가중치 저장
    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
