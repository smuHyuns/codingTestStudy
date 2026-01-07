import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[][] meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // start
            meetings[i][1] = Integer.parseInt(st.nextToken()); // end
        }

        // 끝나는 시간 오름차순, 같으면 시작 시간 오름차순
        Arrays.sort(meetings, (a, b) -> {
            int c = Integer.compare(a[1], b[1]);
            return (c != 0) ? c : Integer.compare(a[0], b[0]);
        });

        int count = 0;
        int endTime = 0;

        for (int i = 0; i < N; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            // 이전 회의가 끝난 시각과 동시에 다음 회의 시작 가능
            if (start >= endTime) {
                count++;
                endTime = end;
            }
        }

        System.out.println(count);
    }
}
