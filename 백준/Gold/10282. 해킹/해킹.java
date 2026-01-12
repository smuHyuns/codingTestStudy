import java.io.*;
import java.util.*;

public class Main {

    /**
     * BOJ 10282 - 해킹
     *
     * 입력: a b s
     * 의미: "a는 b에 의존" => b가 감염되면 s초 후 a도 감염된다.
     * 따라서 그래프 간선은 b -> a (가중치 s)
     *
     * 구해야 하는 것:
     * 1) 감염되는 컴퓨터 수 (시작점 c에서 도달 가능한 노드 수)
     * 2) 마지막 컴퓨터가 감염되기까지 걸린 시간 (도달 노드들의 최단 감염 시간 중 최댓값)
     *
     * 해결:
     * - c를 시작점으로 다익스트라 수행 (가중치가 있으므로 BFS 불가)
     * - dist[x] = "x가 감염되기까지 걸리는 최소 시간"
     * - 결과: dist가 INF가 아닌 노드 개수 = 감염 수, dist의 최대값 = 마지막 감염 시간
     */

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 시작(해킹 당한) 컴퓨터

            // graph[u] : u가 감염되면 전파되는 (v, time) 목록
            List<List<int[]>> graph = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

            // 입력 a b s => b -> a 로 저장
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph.get(b).add(new int[]{a, s});
            }

            int[] dist = dijkstra(n, c, graph);

            int infectedCount = 0;
            int lastTime = 0;

            for (int i = 1; i <= n; i++) {
                if (dist[i] != INF) {
                    infectedCount++;
                    if (dist[i] > lastTime) lastTime = dist[i];
                }
            }

            sb.append(infectedCount).append(' ').append(lastTime);
            if (tc != T - 1) sb.append('\n');
        }

        System.out.print(sb);
    }

    private static int[] dijkstra(int n, int start, List<List<int[]>> graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // pq 요소: {node, time}  time 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int nowTime = cur[1];

            // 이미 더 좋은(짧은) 시간이 dist[now]에 들어있으면 이 항목은 버림
            if (nowTime != dist[now]) continue;

            for (int[] edge : graph.get(now)) {
                int next = edge[0];
                int w = edge[1];

                int nextTime = nowTime + w;
                if (nextTime < dist[next]) {
                    dist[next] = nextTime;
                    pq.offer(new int[]{next, nextTime});
                }
            }
        }

        return dist;
    }
}
