import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


public class Main {
    public static int N, M, H;

    public static void main(String[] args) throws IOException {
        /*
        창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의
        인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
        여섯 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
        철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.

       토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
       며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.


       입력
       첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다.
       M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다.
       둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다.
       즉, 둘째 줄부터 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가 주어진다.
       각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다.
       정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
       러한 N개의 줄이 H번 반복하여 주어진다.

       토마토가 하나 이상 있는 경우만 입력으로 주어진다.
        * */

        // 가로 M 세로 N 높이 H
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][][] tomato = new int[M][N][H]; // 가로 세로 높이

        List<int[]> list = new ArrayList<>();

        // 입력 처리
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int cur = Integer.parseInt(st.nextToken());
                    tomato[k][j][i] = cur;
                    if (cur == 1) list.add(new int[]{k, j, i});
                }
            }
        }

        // 해야할 것
        Deque<int[]> q = new ArrayDeque<>();
        for (int[] c : list) {
            q.offer(new int[]{c[0], c[1], c[2]});
        }

        //탐색
        int[] xrr = {1, -1, 0, 0, 0, 0};
        int[] yrr = {0, 0, 1, -1, 0, 0};
        int[] zrr = {0, 0, 0, 0, -1, 1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int z = cur[2];

            for (int i = 0; i < 6; i++) {
                int dx = x + xrr[i];
                int dy = y + yrr[i];
                int dz = z + zrr[i];

                if (isValid(dx, dy, dz, tomato)) {
                    tomato[dx][dy][dz] = tomato[x][y][z] + 1;
                    q.offer(new int[]{dx, dy, dz});
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    ans = Math.max(ans, tomato[k][j][i]);
                    if (tomato[k][j][i] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(ans-1);

    }

    public static boolean isValid(int x, int y, int z, int[][][] tomato) {
        return x >= 0 && y >= 0 && z >= 0 && x < M && y < N && z < H && tomato[x][y][z] == 0;
    }
}