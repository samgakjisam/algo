package com.example.demo;

import java.util.Scanner;

public class Main {
    static int n, k;
    static long lt; // 기본형은 객체가 아닌 변수. 스택메모리에 직접 저장
    static long[] arr = new long[10000]; //배열은 참조형. 힙메모리에 인스턴스? 생성. 힙 메모리에 객체를 생성하고, 그 주소를 참조 변수에 저장

    public static void main(String[] args) {
        // Scanner 객체를 선언하므로 new 사용
        Scanner sc = new Scanner(System.in); // System.in - 자바 표준 입력 인스턴스

        k = sc.nextInt();
        n = sc.nextInt();

        lt = 0;

        for (int i = 0; i < k; i++) {
            long a = sc.nextLong();
            arr[i] = a;

            if (a > lt) {
                lt = a;
            }
        }

        if (lengthCheck(lt))
            System.out.println(lt);
        else
            System.out.println(findLength(1, lt));

        sc.close(); // 다쓰고나면 해제해서 메모리 누수 방지
    }

    static boolean lengthCheck(long l) {
        long cou = 0;
        for (int i = 0; i < k; i++) {
            cou += arr[i] / l;
        }
        return cou >= n;
    }

    static long findLength(long m, long l) {
        while (m < l) {
            long mid = (m + l) / 2;
            if (lengthCheck(mid)) {
                m = mid;
            } else {
                l = mid;
            }

            if (l == m + 1) {
                if (lengthCheck(l)) {
                    m = l;
                    break;
                } else {
                    l = m;
                    break;
                }
            }
        }
        return l;
    }
}
