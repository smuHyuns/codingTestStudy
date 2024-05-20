import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    static int dp[][] = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));



        //입력
        int testcase = Integer.parseInt(bf.readLine());
        for(int i=0; i<testcase; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int R = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            System.out.println(findSol(N,R));
        }



    }

    public static int findSol(int N, int R){
        if(dp[N][R] >0){
            return dp[N][R];
        }

        else if(N == R || R == 0){
            return dp[N][R] = 1;
        }

        else{
            return dp[N][R] = findSol(N-1,R-1) + findSol(N-1,R);
        }
    }
}