import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int[][] graph;
    static int x, y;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        dfs(start);
        visited = new boolean[N+1];
        bfs(start);
        System.out.println(sb);
        System.out.println(sb2);

    }

    private static void dfs(int start) {
        if(!visited[start]) sb.append(start + " ");
        visited[start] = true;

        for(int i=1; i<=N; i++){
            if(graph[start][i] == 1 && !visited[i])
                dfs(i);
        }
    }

    private static void bfs(int start){
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(start);

        while(!myQueue.isEmpty()){
            int cur = myQueue.poll();
            if(!visited[cur]) sb2.append(cur + " ");
            visited[cur] = true;
            for(int i=1; i<=N; i++){
                if(graph[cur][i] == 1 && !visited[i]){
                    myQueue.add(i);
                }
            }
        }
    }


}
