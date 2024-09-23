import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 범위는 0 ~ 100000
        int[] time = new int[100001];
        int[] ways = new int[100001];
        Arrays.fill(time, Integer.MAX_VALUE);

        time[N] = 0;
        ways[N] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 세 가지 경우: X-1, X+1, 2*X
            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next >= 0 && next <= 100000) {
                    // 다음 위치에 처음 도달하는 경우
                    if (time[next] > time[cur] + 1) {
                        time[next] = time[cur] + 1;
                        ways[next] = ways[cur];
                        q.offer(next);
                    }
                    // 다음 위치에 동일한 시간에 도달하는 경우
                    else if (time[next] == time[cur] + 1) {
                        ways[next] += ways[cur];
                    }
                }
            }
        }

        System.out.println(time[K]); // 가장 빠른 시간
        System.out.println(ways[K]); // 방법의 수
    }
}
