import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int MAX = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                MAX = Math.max(MAX, map[i][j]);
            }
        }

        int answer = 0;

        for (int height = 0; height <= MAX; height++) {
            boolean[][] visited = new boolean[N][N];
            int count = 0;

            // height보다 높은것들을 만나면 영역 표시 및 개수증가
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (!visited[y][x] && map[y][x] > height) {
                        bfs(visited, map, height, x, y);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    public static void bfs(boolean[][] visited, int[][] map, int height, int startX, int startY) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY});
        visited[startY][startX] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int mx = curX + dx[i];
                int my = curY + dy[i];
                if (isValid(mx, my, height, visited, map)) {
                    visited[my][mx] = true;
                    q.offer(new int[]{mx, my});
                }
            }
        }
    }

    public static boolean isValid(int x, int y, int height, boolean[][] visited, int[][] map) {
        int N = visited[0].length;
        return x >= 0 && y >= 0 && x < N && y < N && !visited[y][x] && map[y][x] > height;
    }
}
