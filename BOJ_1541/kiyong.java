package BOJ_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kiyong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strList = new String[str.length()+1];
        int i = 0;
        for (String e : str.split("")) {
            if ("+-".contains(e)) {
                i++;
                strList[i] = e;
                i++;
            } else {
                if (strList[i] == null) {
                    strList[i] = e;
                } else {
                    strList[i] += e;
                }
            }
        }
        int ans = 0;
        int j = 0;
        while (true) {
            String s = strList[j];
            if (s == null) {
                break;
            }
            if (s.equals("-")) {
                int tmpInt = 0;
                while (true) {
                    j++;
                    String tmp = strList[j];
                    if (tmp == null || tmp.equals("-")) {
                        break;
                    } else if (!tmp.equals("+")) {
                        tmpInt += Integer.parseInt(tmp);
                    }
                }
                ans -= tmpInt;
                j--;
            } else if (!s.equals("+")) {
                ans += Integer.parseInt(s);
            }
            j++;
        }
        System.out.println(ans);
    }
}
