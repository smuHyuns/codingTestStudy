import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int [][] graph;
    static boolean[] Visited;
    static int node, testcase;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        node = Integer.parseInt(bf.readLine());
        testcase =  Integer.parseInt(bf.readLine());
        graph = new int[node+1][node+1];
        Visited = new boolean[node+1];

        for(int i=0; i<testcase; i++){
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A][B] = graph[B][A] = 1;
        }
        dfs(1);
        System.out.println(count-1);

    }

    static void dfs(int start) {
        Visited[start] = true;
        count++;
        for (int i =0; i<=node; i++){
            if(!Visited[i] && graph[start][i] == 1){
                dfs(i);
            }
        }
    }
}
