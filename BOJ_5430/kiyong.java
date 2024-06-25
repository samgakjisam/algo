import java.io.*;
import java.util.*;

public class kiyong{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++){
            String func = br.readLine();
            int M = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] li = str.substring(1, str.length()-1).split(",");
            ArrayDeque<Integer> deq = new ArrayDeque<>();
            if (li[0] != "") {
                for (String tmp : li){
                    deq.offerLast(Integer.parseInt(tmp));
                }
            }
            int seq = 1;
            boolean isErr = false;
            for (int j=0; j<func.length(); j++){
                if (func.charAt(j) == 'R'){
                    seq *= -1;
                } else {
                    if (deq.isEmpty()) {
                        isErr = true;
                        break;
                    } else {
                        if ( seq == 1 ){
                            deq.pollFirst();
                        } else {
                            deq.pollLast();
                        }
                    }
                }
            }
            if (isErr) {sb.append("error");}
            else {
                sb.append("[");
                while (!deq.isEmpty()){
                    if (seq==1){
                        sb.append(deq.pollFirst());
                        if (!deq.isEmpty()) {
                            sb.append(",");
                        }
                    } else {
                        sb.append(deq.pollLast());
                        if (!deq.isEmpty()) {
                            sb.append(",");
                        }
                    }
                }
                sb.append("]");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
