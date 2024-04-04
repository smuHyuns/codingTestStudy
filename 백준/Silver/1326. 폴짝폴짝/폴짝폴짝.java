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
        Set<Integer> visited = new HashSet<>();

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int now = q.poll();
                if(now == B){
                    return sum;
                }

                for(int j=1; now + j * arr[now] <= N || now-j*arr[now] >= 1 ; j++){
                    int next = now + j * arr[now];
                    if(next <= N && !visited.contains(next)){
                        q.offer(next);
                        visited.add(next);
                    }
                    next = now - j *arr[now];
                    if(next >= 1 && !visited.contains(next)){
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            sum ++;
        }
        return -1;
    }
}
