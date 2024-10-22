import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, M, fuel;
    static Point[] passengers;
    static Point[] destinations;
    static Point taxi;
    static boolean[] takenPassengers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //스타트택시 복습!//
        /* 입력 구간 */

        // 맵의크기 N, 손님의 수 M, 연료의 양 fuel
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        //map 입력
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //택시의 위치를 나타낼 Point형 변수 taxi
        //입력순서는 행과 열순이므로 y부터 입력받는다 !! (중요)
        st = new StringTokenizer(br.readLine());
        taxi = new Point();
        taxi.y = Integer.parseInt(st.nextToken()) - 1;
        taxi.x = Integer.parseInt(st.nextToken()) - 1;

        //탑승객들의 위치(출발점) 을 나타낼 passengers와
        //탑승객들의 목적지를 나타낼 destinations
        //탑승객들의 탑승여부를 나타내기 위한 takenPassengers
        passengers = new Point[M];
        destinations = new Point[M];
        takenPassengers = new boolean[M];

        for (int i = 0; i < M; i++) {
            passengers[i] = new Point();
            destinations[i] = new Point();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            passengers[i].y = Integer.parseInt(st.nextToken()) - 1;
            passengers[i].x = Integer.parseInt(st.nextToken()) - 1;
            destinations[i].y = Integer.parseInt(st.nextToken()) - 1;
            destinations[i].x = Integer.parseInt(st.nextToken()) - 1;
        }

        /*입력구간 종료*/

        // 택시가 손님을 태우는 과정
        for (int i = 0; i < M; i++) {
            boolean[][] visited = new boolean[N][N]; //갈수있는곳인지 없는지를 체크하기 위한 visited
            int[][] route = makeRoute(visited); // 손님 찾기 전 & 손님 데려다 준 후 에 사용되는 최단 경로
            int target = findPassenger(route, visited);

            // 고객이 있지만 도달할 수 없는 경우
            if (target == -1) {
                fuel = -1;
                break;
            }

            //고객을 태우기 위한 과정
            Point cur = passengers[target];
            int distToPassengers = route[cur.y][cur.x];

            // 손님을 태우러 가는 연료 확인
            if (fuel < distToPassengers) {
                fuel = -1;
                break;
            }

            // 손님을 택시에 태움
            fuel -= distToPassengers;

            //택시의 위치를 갱신해준다
            taxi.x = cur.x;
            taxi.y = cur.y;

            //목적지 설정
            Point destination = destinations[target];
            visited = new boolean[N][N];
            route = makeRoute(visited); // 거리계산
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

            takenPassengers[target] = true;
        }

        System.out.println(fuel);
    }


    public static int findPassenger(int[][] route, boolean[][] visited) {

        int minDist = Integer.MAX_VALUE;
        int minIdx = -1;

        for (int i = 0; i < M; i++) {
            //방문했다면 pass
            if (takenPassengers[i]) continue;

            Point cur = passengers[i];
            int curDist = route[cur.y][cur.x];

            //방문할수 없다면 pass
            if (!visited[cur.y][cur.x]) continue;

            //백준이 태울 승객을 고를 때는 현재 위치에서 최단거리가 가장 짧은 승객을 고른다.
            if (curDist < minDist) {
                minDist = curDist;
                minIdx = i;
            }
            // 그런 승객이 여러 명이면 그중 행 번호가 가장 작은 승객을, 그런 승객도 여러 명이면 그중 열 번호가 가장 작은 승객을 고른다
            else if (curDist == minDist) {
                if (passengers[minIdx].y == passengers[i].y && passengers[minIdx].x > passengers[i].x) minIdx = i;
                else if (passengers[minIdx].y > passengers[i].y) minIdx = i;
            }
        }

        return minIdx; // 고객이 있다면 해당 인덱스를, 없다면 -1을 리턴하게 된다.
    }

    public static int[][] makeRoute(boolean[][] visited) {
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

                //범위계산, 방문여부, 벽이아닌지 검사
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
