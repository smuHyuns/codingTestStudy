import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int [][]graph;
    static boolean []visited;
    static int N,M;
    static int cnt =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        //입력받기
        for(int i=0;i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] =1;
            graph[y][x] =1;
        }
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    public static void dfs(int start){
        if(!visited[start]) {
            visited[start] = true;
            for (int i = 1; i <= N; i++) {
                if (graph[start][i] == 1 && !visited[i]) {
                    dfs(i);
                }
            }
        }
    }


}