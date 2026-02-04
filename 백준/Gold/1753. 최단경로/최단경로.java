import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        // 최단경로값, 경로가 존재하지않는 경우 INF 출력
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            list.get(from).add(new int[]{to, dist});
        }

        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[1], b[1])));
        pq.offer(new int[]{start, 0});

        // 탐색
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int vertex = now[0];
            int dist = now[1];

            List<int[]> connect = list.get(vertex);
            for (int[] c : connect) {
                int next = c[0];
                int nextDist = dist + c[1];

                if (distance[next] > nextDist) {
                    distance[next] = nextDist;
                    pq.offer(new int[]{next, nextDist});
                }
            }
        }

        // 출력
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }
}