import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int []list;
    static Integer S,N;
    static Integer count =0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        S = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        list = new int[S];
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<S; i++){
            int input = Integer.parseInt(st.nextToken());
            list[i] = input;
        }
        dfs(0,0);
        System.out.println(N == 0 ? count-1 : count); //0인경우는 -1
    }

    static void dfs(int seq, int sum){
        if(seq == S){
            if(sum == N){
                count++;
            }
            return;
        }
        //해당 리스트를 포함한경우와, 포함하지 않은경우 -> 총 경우의수는 2^n개 발생한다.
        dfs(seq + 1,sum + list[seq]);
        dfs(seq + 1, sum);

    }
}
