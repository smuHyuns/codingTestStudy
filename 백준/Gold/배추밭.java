import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[][] map;
    public static int x, y;
    public static int[] xrr = {-1, 1, 0, 0}; // 상하좌우 탐색을 위한 배열
    public static int[] yrr = {0, 0, 1, -1};
    public static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        // 입력구간
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        map = new int[y][x];

        // 입력과 동시에 익은 토마토의 위치를 큐에 저장
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j}); // 익은 토마토의 좌표를 큐에 저장
                }
            }
        }

        // BFS 실행
        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[1];
            int curY = current[0];

            for (int k = 0; k < 4; k++) {
                int dx = curX + xrr[k];
                int dy = curY + yrr[k];

                if (isValid(dx, dy)) {
                    map[dy][dx] = map[curY][curX] + 1; // 며칠 차에 익었는지 표시
                    queue.offer(new int[]{dy, dx});
                }
            }
        }

        // 익히지 못한 토마토가 있는지 확인하고 최대 날짜 반환
        int maxDays = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 0) return -1; // 익지 않은 토마토가 있으면 -1 리턴
                maxDays = Math.max(maxDays, map[i][j]);
            }
        }

        // 처음부터 모든 토마토가 익어있던 경우 0을 출력해야 함
        return maxDays == 1 ? 0 : maxDays - 1;
    }

    // 범위 검사 및 익지 않은 토마토인지 확인
    public static boolean isValid(int curX, int curY) {
        return curX < x && curY < y && curX >= 0 && curY >= 0 && map[curY][curX] == 0;
    }
}
