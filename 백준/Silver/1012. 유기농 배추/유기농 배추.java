import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[][] graph;
    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(bf.readLine());

        for (int t = 0; t < testcase; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int veg = Integer.parseInt(st.nextToken());

            graph = new int[y][x];
            visited = new boolean[y][x];

            for (int i = 0; i < veg; i++) {
                st = new StringTokenizer(bf.readLine());
                int vx = Integer.parseInt(st.nextToken());
                int vy = Integer.parseInt(st.nextToken());
                graph[vy][vx] = 1;
            }

            int count = 0;
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;

        // 상하좌우 이동
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && nx < y && ny >= 0 && ny < x && graph[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
