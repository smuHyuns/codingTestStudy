import java.util.*;
import java.io.*;

public class Main {

    static class Tower {
        int idx;  
        int height;

        Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        Deque<Tower> stack = new ArrayDeque<>(); 

        for (int i = 1; i <= N; i++) {
            int h = Integer.parseInt(st.nextToken());

            // 나보다 낮거나 같은 탑은 앞으로도 수신 탑이 될 수 없으니 제거
            while (!stack.isEmpty() && stack.peekLast().height <= h) {
                stack.pollLast();
            }

            // 남아있으면 가장 가까운 왼쪽의 더 높은 탑
            if (stack.isEmpty()) sb.append(0);
            else sb.append(stack.peekLast().idx);

            if (i < N) sb.append(' ');

            // 현재 탑을 후보로 추가
            stack.addLast(new Tower(i, h));
        }

        System.out.print(sb);
    }

}
