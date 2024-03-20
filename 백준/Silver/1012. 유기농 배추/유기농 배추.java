import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[][] graph;
    static int x, y;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(bf.readLine());

        for (int t = 0; t < testcase; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int veg = Integer.parseInt(st.nextToken());

            graph = new int[x][y];
            visited = new boolean[x][y];

            for (int i = 0; i < veg; i++) {
                st = new StringTokenizer(bf.readLine());
                int vx = Integer.parseInt(st.nextToken());
                int vy = Integer.parseInt(st.nextToken());
                graph[vx][vy] = 1;
            }

            int count = 0;
            for (int X = 0; X < x; X++) {
                for (int Y = 0; Y < y; Y++) {
                    if (graph[X][Y] == 1 && !visited[X][Y]) {
                        bfs(X, Y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int a, int b) {
        visited[a][b] = true;

        // 상하좌우 이동
        for (int k = 0; k < 4; k++) {
            int nx = a + dx[k];
            int ny = b + dy[k];

            if(isValid(nx,ny)) dfs(nx,ny);

        }
    }

    private static void bfs(int a, int b){
        Queue<int[]> myQueue = new LinkedList<int[]>();
        myQueue.add(new int[] {a,b});

        while(!myQueue.isEmpty()){
            int qx = myQueue.peek()[0];
            int qy = myQueue.peek()[1];
            visited[qx][qy] = true;
            myQueue.poll();
            for(int i=0; i<4; i++){
                int nx = qx + dx[i];
                int ny = qy + dy[i];
                if(isValid(nx,ny)){
                    visited[nx][ny] = true;
                    myQueue.add(new int[] {nx,ny});
                }
            }
        }

    }

    private static boolean isValid(int a, int b){
        if (a >= 0 && a < x && b >= 0 && b < y) {
            if (graph[a][b] == 1 && !visited[a][b]) {
                return true;
            }
        }
        return false;
    }

}
