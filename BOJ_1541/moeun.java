import java.util.Scanner;

public class Main {
    static int[] arr = new int[50];
    static int[] arr2 = new int[50];
    static int n = 0;
    static int m = 0;

    public static void main(String[] args) {
        int num = 0;
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        for(int i = 0; i < line.length(); i++){
            char c = line.charAt(i);

            if (Character.isDigit(c)){
                if (num == 0){
                    num = (c - 48);
                }
                else if (num != 0){
                    num = num * 10 + (c - 48);
                }
                arr[n] = num;
            }
            else if (!Character.isDigit(c)){
                if (c == '+') {
                    arr2[m] = 1;
                }
                else if (c == '-') {
                    arr2[m] = 0;
                }
                num = 0;
                n++;
                m++;
            }
        }
        n++;
        arr[n] = num;

        int st = arr[0];
        boolean flg = true;
        for (int i = 0; i < m; i++) {
            if (flg && arr2[i] == 1) {
                st += arr[i + 1];
            }
            else {
                flg = false;
                st -= arr[i + 1];
            }
        }

        System.out.println(st);
        
        sc.close();
    }
}
