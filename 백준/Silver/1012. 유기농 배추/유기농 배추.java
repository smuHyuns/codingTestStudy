import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int count;
    public static int X, Y;
    public static int[][] graph;
    public static int[] xrr = {-1, 1, 0, 0};
    public static int[] yrr = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int a = 0; a < N; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            int testcase = Integer.parseInt(st.nextToken());

            graph = new int[Y][X];
            count = 0;
            for (int i = 0; i < testcase; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }

            for (int j = 0; j < Y; j++) {
                for (int i = 0; i < X; i++) {
                    if (graph[j][i] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count + " \n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        graph[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int dx = x + xrr[i];
            int dy = y + yrr[i];
            if (dx >= 0 && dx <= X - 1 && dy >= 0 && dy <= Y - 1 && graph[dy][dx] == 1) {
                dfs(dx, dy);
            }
        }
    }


}
