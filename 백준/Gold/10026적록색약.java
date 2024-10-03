import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//룰루 맥북으로 처음풀어보는 코테문제~

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        //적록색약이란 = R == G 으로 느끼는사람이다. 즉 입력을 받을때 R == G 로 감안하고 입력을받는다
        //그렇다면 주어지는 경우의수는 B와 R뿐
        //입력을 받은 후 방문하지 않은 경우 cnt를 +1해주고 bfs혹은 dfs중 한경우의 수를 선택하여 실행하면 되는문제이다
        //+ 일반의 경우와 적록색약인경우를 분리하여 처리

        boolean[][] RG_visited = new boolean[N][N];
        boolean[][] visited = new boolean[N][N];

        char[][] RG_map = new char[N][N];
        char[][] map = new char[N][N];

        int RG_answer = 0;
        int answer = 0;

        //입력
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                if (input.charAt(j) == 'B') {
                    RG_map[i][j] = 'B';
                    map[i][j] = 'B';
                    continue;
                }
                RG_map[i][j] = 'R';
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(j, i, visited, map, map[i][j]);
                    answer++;
                }
                if (!RG_visited[i][j]) {
                    bfs(j, i, RG_visited, RG_map, RG_map[i][j]);
                    RG_answer++;
                }
            }
        }
        System.out.println(answer + " " + RG_answer);
    }

    public static void bfs(int startX, int startY, boolean[][] visited, char[][] map, char currentColor) {
        //초기화
        int[] xrr = {-1, 1, 0, 0};
        int[] yrr = {0, 0, -1, 1};
        Deque<int[]> q = new ArrayDeque<>();
        visited[startY][startX] = true;
        q.offer(new int[]{startX, startY});

        //탐색시작
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int dx = x + xrr[i];
                int dy = y + yrr[i];
                if (dx >= 0 && dx < N && dy >= 0 && dy < N && !visited[dy][dx] && map[dy][dx] == currentColor) {
                    visited[dy][dx] = true;
                    q.offer(new int[]{dx, dy});
                }
            }
        }
    }
}
