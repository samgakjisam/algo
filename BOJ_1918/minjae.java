import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<Character> stack = new Stack<>();
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp >= 'A' && temp <= 'Z') {
                ans += temp;
            } else {
                if (temp == '(') {
                    stack.push(temp);
                } else if (temp == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        ans += stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    if (temp == '*' || temp == '/') {
                        while (!stack.isEmpty()) {
                            char s = stack.peek();
                            if (s == '*' || s == '/') {
                                ans += stack.pop();
                            } else {
                                break;
                            }
                        }
                        stack.push(temp);
                    } else {
                        while (!stack.isEmpty()) {
                            char s = stack.peek();
                            if (s != '(') {
                                ans += stack.pop();
                            } else {
                                break;
                            }
                        }
                        stack.push(temp);
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        System.out.println(ans);
    }
}
