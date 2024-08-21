import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, M, fuel;
    static Point[] customers;
    static Point[] destinations;
    static Point taxi;
    static boolean[] takenCustomer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        taxi = new Point();
        taxi.y = Integer.parseInt(st.nextToken()) - 1;
        taxi.x = Integer.parseInt(st.nextToken()) - 1;

        customers = new Point[M];
        destinations = new Point[M];

        for (int i = 0; i < M; i++) {
            customers[i] = new Point();
            destinations[i] = new Point();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            customers[i].y = Integer.parseInt(st.nextToken()) - 1;
            customers[i].x = Integer.parseInt(st.nextToken()) - 1;
            destinations[i].y = Integer.parseInt(st.nextToken()) - 1;
            destinations[i].x = Integer.parseInt(st.nextToken()) - 1;
        }

        takenCustomer = new boolean[M];
        int count = 0;

        // 택시가 손님을 태우는 과정
        for (int i = 0; i < M; i++) {
            boolean[][] visited = new boolean[N][N];
            int[][] route = makeRoute(visited); // 손님 찾기 전 & 손님 데려다 준 후
            int target = findTaxi(route, visited);

            // 더 이상 태울 고객이 없거나 도달할 수 없는 경우
            if (target == -1) {
                fuel = -1;
                break;
            }

            Point cur = customers[target];
            int distToCustomer = route[cur.y][cur.x];
            if (fuel < distToCustomer || !visited[cur.y][cur.x]) { // 손님을 태우러 가는 연료 확인
                fuel = -1;
                break;
            }

            // 손님을 택시에 태움
            fuel -= distToCustomer;
            taxi.x = cur.x;
            taxi.y = cur.y;

            Point destination = destinations[target];
            visited = new boolean[N][N];
            route = makeRoute(visited);
            int distToDestination = route[destination.y][destination.x];
            if (fuel < distToDestination || !visited[destination.y][destination.x]) { // 목적지로 가는 연료 확인
                fuel = -1;
                break;
            }

            // 목적지에 도착하고 연료 충전
            fuel -= distToDestination;
            fuel += distToDestination * 2; // 도착 후 연료 보충
            taxi.x = destination.x;
            taxi.y = destination.y;

            count++;
            takenCustomer[target] = true;
        }

        System.out.println(fuel);
    }

    private static int findTaxi(int[][] route, boolean[][] visited) {

        int minDist = Integer.MAX_VALUE;
        int minIdx = -1;

        for (int i = 0; i < M; i++) {
            if (takenCustomer[i]) continue;

            Point cur = customers[i];
            int curDist = route[cur.y][cur.x];

            if (!visited[cur.y][cur.x]) continue;
            //백준이 태울 승객을 고를 때는 현재 위치에서 최단거리가 가장 짧은 승객을 고른다.
            if (curDist < minDist) {
                minDist = curDist;
                minIdx = i;
            }
            // 그런 승객이 여러 명이면 그중 행 번호가 가장 작은 승객을, 그런 승객도 여러 명이면 그중 열 번호가 가장 작은 승객을 고른다
            else if (curDist == minDist){
                if(customers[minIdx].y == customers[i].y && customers[minIdx].x > customers[i].x) minIdx = i;
                else if(customers[minIdx].y > customers[i].y) minIdx = i;
            }
        }

        return minIdx;
    }

    private static int[][] makeRoute(boolean[][] visited) {
        int[][] route = new int[N][N];
        int[] xrr = {-1, 1, 0, 0};
        int[] yrr = {0, 0, 1, -1};

        Deque<Point> q = new ArrayDeque<>();
        visited[taxi.y][taxi.x] = true;
        route[taxi.y][taxi.x] = 0;
        q.offer(new Point(taxi.x, taxi.y));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int mx = cur.x + xrr[i];
                int my = cur.y + yrr[i];

                if (mx >= 0 && mx < N && my >= 0 && my < N && !visited[my][mx] && map[my][mx] == 0) {
                    route[my][mx] = route[cur.y][cur.x] + 1;
                    visited[my][mx] = true;
                    q.offer(new Point(mx, my));
                }
            }
        }

        return route;
    }
}
