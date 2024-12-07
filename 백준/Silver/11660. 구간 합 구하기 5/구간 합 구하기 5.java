import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][N + 1];

        // 누적 합 배열 생성
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken())
                         + dp[i - 1][j]
                         + dp[i][j - 1]
                         - dp[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();

        // 쿼리 처리
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = dp[x2][y2]
                       - (x1 > 1 ? dp[x1 - 1][y2] : 0)
                       - (y1 > 1 ? dp[x2][y1 - 1] : 0)
                       + (x1 > 1 && y1 > 1 ? dp[x1 - 1][y1 - 1] : 0);

            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}
