import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    static int row, col;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][col];
        int emptyCount = 0;

        for (int y = 0; y < row; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < col; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 0) emptyCount++;
            }
        }

        int answer = search(map, emptyCount);
        System.out.println(answer);
    }

    static int search(int[][] map, int emptyCount) {
        int maxSafe = 0;
        int total = row * col;

        for (int i = 0; i < total - 2; i++) {
            int y1 = i / col, x1 = i % col;
            if (map[y1][x1] != 0) continue;

            for (int j = i + 1; j < total - 1; j++) {
                int y2 = j / col, x2 = j % col;
                if (map[y2][x2] != 0) continue;

                for (int k = j + 1; k < total; k++) {
                    int y3 = k / col, x3 = k % col;
                    if (map[y3][x3] != 0) continue;

                    int[][] copy = copyMap(map);

                    copy[y1][x1] = 1;
                    copy[y2][x2] = 1;
                    copy[y3][x3] = 1;

                    int infected = bfs(copy);
                    int safe = emptyCount - 3 - infected;

                    maxSafe = Math.max(maxSafe, safe);
                }
            }
        }

        return maxSafe;
    }

    static int bfs(int[][] map) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        int infected = 0;

        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                if (map[y][x] == 2) {
                    q.offer(new Point(x, y));
                    visited[y][x] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= col || ny >= row) continue;
                if (visited[ny][nx] || map[ny][nx] != 0) continue;

                visited[ny][nx] = true;
                infected++;
                q.offer(new Point(nx, ny));
            }
        }

        return infected;
    }

    static int[][] copyMap(int[][] map) {
        int[][] copy = new int[row][col];
        for (int i = 0; i < row; i++) {
            System.arraycopy(map[i], 0, copy[i], 0, col);
        }
        return copy;
    }
}
