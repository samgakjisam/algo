import java.io.*;
import java.util.*;

public class boj_2477 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        int prev_dir = 0;
        int prev_length = 0;
        HashMap<Integer, Integer> farm_info = new HashMap<>();
        farm_info.put(5, 0);
        int start = 0;
        int last = 0;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if (i == 0) {
                start = length;
            } else if (i == 5) {
                last = length;
            }

            farm_info.put(dir, length);

            switch (dir) {
                case 1:
                    if (prev_dir == 4) {
                        farm_info.put(5, prev_length * length);
                    }
                    break;
                case 2:
                    if (prev_dir == 3) {
                        farm_info.put(5, prev_length * length);
                    }
                    break;
                case 3:
                    if (prev_dir == 1) {
                        farm_info.put(5, prev_length * length);
                    }
                    break;
                case 4:
                    if (prev_dir == 2) {
                        farm_info.put(5, prev_length * length);
                    }
                    break;
            }

            prev_dir = dir;
            prev_length = length;
        }

        if (farm_info.get(5) == 0) {
            farm_info.put(5, start * last);
        }

        int row_length = Math.max(farm_info.get(3), farm_info.get(4));
        int col_length = Math.max(farm_info.get(1), farm_info.get(2));
        int area = row_length * col_length - farm_info.get(5);

        System.out.println(area * K);
    }
}
