import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    static int node;
    static int testcase;
    static int[][] graph;
    static boolean []visit;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        node = Integer.parseInt(bf.readLine());
        testcase = Integer.parseInt(bf.readLine());
        graph = new int[node+1][node+1];
        visit = new boolean[node+1];
        for(int i=0; i<testcase; i++){
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A][B] = graph[B][A] = 1;
        }

        bfs(1);
        System.out.println(count);
    }

    private static void bfs(int start) {
        Queue<Integer> myQ = new LinkedList<>();
        myQ.add(start);
        visit[start] = true;

        while(!myQ.isEmpty()){
            int cur = myQ.poll();

            for(int i=1; i<=node; i++){
                if(graph[cur][i] == 1 && !visit[i]){
                    myQ.add(i);
                    visit[i] = true;
                    count++;
                }
            }
        }
    }

    private static void dfsStack(int start) {
        Stack<Integer> myS = new Stack<>();
        myS.push(start);
        visit[start] = true;

        while (!myS.isEmpty()) {
            for (int i = 1; i <= node; i++) {
                if (graph[start][i] == 1 && !visit[i]) {
                    myS.push(i);
                    visit[i] = true;
                    count++;
                    dfsStack(i);
                }
            }
            myS.pop();
        }
    }
    private static void dfs(int start) {
        visit[start] = true;

        for(int i=1; i<=node; i++){
            if(graph[start][i] == 1 && !visit[i]){
                count++;
                dfs(i);
            }
        }
    }
}


