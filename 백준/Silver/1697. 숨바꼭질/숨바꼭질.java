import java.io.*;
import java.util.*;

public class Main {

    /**
     * 범위는 0~100000
     * 수빈 : n / 동생 : k
     * 움직일수 있는것은 수빈이만임.
     * 걷는것은 x+1 혹은 x-1 / 순간이동을 하는경우는 2*x
     */
    private static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수빈
        int k = Integer.parseInt(st.nextToken()); // 동생

        solution2(n, k);
    }

    public static void solution2(int start, int target) {
        // 뒤로가는건 -1 뿐
        if (start >= target) {
            System.out.println(start - target);
            return;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[MAX + 1];

        // 현재위치 / 이동횟수
        q.offer(new int[]{start, 0});
        while (!q.isEmpty()) {
            int[] current = q.poll();

            int nowIdx = current[0];
            int moveCount = current[1];

            visited[nowIdx] = true;

            // 발견시 종료
            if (nowIdx == target) {
                System.out.println(moveCount);
                return;
            }

            int plus = nowIdx + 1;
            int minus = nowIdx - 1;
            int multi = nowIdx * 2;
            int nextMoveCount = moveCount + 1;

            if (isValidMove(plus) && !visited[plus]) {
                q.offer(new int[]{plus, nextMoveCount});
            }
            if (isValidMove(minus) && !visited[minus]) {
                q.offer(new int[]{minus, nextMoveCount});
            }
            if (isValidMove(multi) && !visited[multi]) {
                q.offer(new int[]{multi, nextMoveCount});
            }
        }
    }


    public static void solution(int start, int target) {
        int[] dp = new int[MAX + 1];
        dp[start] = 0;

        for (int now = 0; now <= MAX; now++) {
            if (now <= start) {
                dp[now] = start - now;
                continue;
            }

            dp[now] = 1000000; // 겁나큰값으로 초기화
        }

        for (int now = 0; now <= MAX; now++) {
            int plus = now + 1;
            int multi = now * 2;

            if (isValidMove(plus)) {
                dp[plus] = Math.min(dp[now] + 1, dp[plus]);
            }
            if (isValidMove(multi)) {
                dp[multi] = Math.min(dp[now] + 1, dp[multi]);
            }
        }

        System.out.println(dp[target]);
    }

    public static boolean isValidMove(int next) {
        return 0 <= next && next <= MAX;
    }
}