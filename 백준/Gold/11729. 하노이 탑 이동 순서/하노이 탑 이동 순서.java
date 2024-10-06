import java.io.*;

public class Main {
    public static int count;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 하노이의 탑 알고리즘 - 재귀를 사용
        int N = Integer.parseInt(br.readLine());
        hanoi(N, 1, 3, 2);
        System.out.println(count);
        System.out.print(sb);
    }

    public static void hanoi(int n, int from, int to, int aux) {
        // 원판 하나이면 바로 이동
        if (n == 1) {
            count++;
            sb.append(from + " " + to + "\n");
            return;
        }
        // 1. n-1개의 원판을 보조 기둥으로 옮김 (to를 보조로 사용)
        hanoi(n - 1, from, aux, to);
        // 2. 가장 큰 원판을 목적지로 옮김
        sb.append(from + " " + to + "\n");
        count++;
        // 3. n-1개의 원판을 목적지로 옮김 (from을 보조로 사용)
        hanoi(n - 1, aux, to, from);
    }
}