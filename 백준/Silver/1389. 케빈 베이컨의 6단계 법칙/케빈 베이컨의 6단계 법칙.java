import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int [][] rel;
    static int []kbNum;
    static int INF = 999999999;

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //초기화
        rel = new int [N+1][N+1];
        kbNum = new int[N+1];

        for(int i=0; i<=N; i++){
            for(int j=0; j<=N; j++){
                if(i==j){ //자신한테 가는비용은 0이다.
                    rel[i][j] = 0;
                    continue;
                }
                //자기 자신으로 가는 경우를 제외하고 매우 큰 값
                rel[i][j] = INF;
            }
        }

        //그래프 입력받기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            rel[x][y] = 1;
            rel[y][x] = 1;
        }

        // 플로이드 워셜 알고리즘
        // 노드를 1개부터 N개까지 거쳐가는 경우를 모두 고려한다.
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    rel[i][j] = Math.min(rel[i][j], rel[i][k]+rel[k][j]);
                }
            }
        }

        //최대값 찾기
        int min = INF;
        int ans = 0;
        for(int i=1; i<=N; i++){
            int total = 0;
            for(int j=1; j<=N; j++){
                total += rel[i][j];
            }

            if(min > total){
                min = total;
                ans = i;
            }
        }

        System.out.println(ans);


    }


}