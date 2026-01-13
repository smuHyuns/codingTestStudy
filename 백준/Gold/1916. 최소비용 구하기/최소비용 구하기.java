import java.util.*;
import java.io.*;

public class Main {

    public static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cities = Integer.parseInt(br.readLine());
        int buses = Integer.parseInt(br.readLine());

        List<List<int[]>> busMap = new ArrayList<>();
        for (int i = 0; i <= cities; i++) {
            busMap.add(new ArrayList<>());
        }

        for (int i = 0; i < buses; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            busMap.get(from).add(new int[]{to, dist});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] distMap = dijkstra(busMap, start);

        System.out.println(distMap[target]);
    }

    private static int[] dijkstra(List<List<int[]>> busMap, int start) {
        int[] dist = new int[busMap.size()];
        Arrays.fill(dist, MAX);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNo = cur[0];
            int curDist = cur[1];

            if (dist[curNo] != curDist) continue;

            List<int[]> links = busMap.get(curNo);
            for (int[] link : links) {
                int nextNo = link[0];
                int nextDist = curDist + link[1];

                if (dist[nextNo] > nextDist) {
                    dist[nextNo] = nextDist;
                    pq.offer(new int[]{nextNo, nextDist});
                }
            }
        }

        return dist;
    }

}
