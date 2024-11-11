import java.util.Scanner;
import java.io.FileInputStream;

import java.util.*;

class Solution {

    public static String[] numbers = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String intro = sc.next();
            int N = sc.nextInt();
            int[] arr = new int[10];
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < N; j++) {
                String input = sc.next();
                int num = defineNum(input);
                arr[num]++;
            }

            sb.append(intro).append('\n');
            for (int i = 0; i < 10; i++) {
                appendNum(i, arr[i], sb);
            }
            System.out.println(sb);
        }
    }

    public static void appendNum(int index, int num, StringBuilder sb) {
        String str = numbers[index];
        for (int j = 0; j < num; j++) {
            sb.append(str).append(" ");
        }
    }


    public static int defineNum(String input) {
        for (int i = 0; i < 10; i++) {
            if (input.equals(numbers[i])) {
                return i;
            }
        }
        return -1;
    }
}