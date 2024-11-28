import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //입력구간
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String delim = ",[]";

        for (int i = 0; i < T; i++) {
            //초기값 P, N, deque 설정
            String P = br.readLine(); // 명령어
            int N = Integer.parseInt(br.readLine()); // 숫자개수
            StringTokenizer st = new StringTokenizer(br.readLine(), delim);
            Deque<Integer> deque = new ArrayDeque<>(); // 원소들
            boolean direction = true; // true면 정방향, false면 역방향
            boolean isBreak = false; // 빈칸에 D한 여부 출력
            while (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            //만약에 명령어가 D인데 길이가 0이면 테스트케이스 생략
            if (P.equals("D") && N == 0) {
                sb.append("error").append('\n');
                continue;
            }

            //탐색
            for (int j = 0; j < P.length(); j++) {
                char order = P.charAt(j);
                if (order == 'R') {
                    direction = !direction;
                    continue;
                }
                if (order == 'D') {
                    if (deque.isEmpty()) {
                        isBreak = true;
                        break;
                    }
                    if (direction) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (isBreak) {
                sb.append("error").append('\n');
                continue;
            }

            sb.append("[");
            while (!deque.isEmpty()) {
                if (direction) {
                    sb.append(deque.pollFirst());
                } else {
                    sb.append(deque.pollLast());
                }
                if (!deque.isEmpty()) {
                    sb.append(",");
                }
            }
            sb.append("]").append('\n');
        }
        System.out.print(sb);
    }


}
