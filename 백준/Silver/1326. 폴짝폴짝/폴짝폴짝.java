import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int arr[];
    static int min=0;
    static int N;
    static int A, B;
    public static void main(String[] args) throws IOException {
        /*입력구간*/
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[N+1];
        arr[0] = 0;

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        /*찾기*/
        System.out.println(findSol());
    }

    private static int findSol() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(A);
        int sum = 0;
        boolean visited[] = new boolean[N+1];
        while(!q.isEmpty()){
            int size = q.size();
            for(int a=0; a<size; a++){
                int start = q.poll();
                if(start == B){
                    return sum;
                }

                for(int i=1; start + i*arr[start] <= N || start - i*arr[start] >=1 ; i++ ){
                    int next = start + i*arr[start];
                    if(next <= N && !visited[next]){
                        q.add(next);
                        visited[next] = true;
                    }

                    next = start - i*arr[start];
                    if(next >= 1 && !visited[next]){
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
            sum ++;
        }
        return -1;
    }
}
