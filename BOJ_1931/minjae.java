import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] meetings;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, (o1, o2) -> (o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]));
        Stack<Integer> stack = new Stack<>();

        stack.add(meetings[0][1]);
        for (int i = 1; i < N; i++) {
            if (meetings[i][0] >= stack.peek()) {
                stack.add(meetings[i][1]);
            }
        }

        System.out.println(stack.size());
    }
}
