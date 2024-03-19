import java.io.IOException;
import java.util.*;


public class Main {
    static Integer dp[];
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;
        System.out.println(getSol(N));
    }
    /*
    * dp[3] = dp[1] + dp[2]
    * */



    private static int getSol(int N) {

        if(dp[N] == null){
            if (N % 6 == 0) {
                dp[N] = Math.min(getSol(N - 1), Math.min(getSol(N / 3), getSol(N / 2))) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (N % 3 == 0) {
                dp[N] = Math.min(getSol(N / 3), getSol(N - 1)) + 1;
            }
            // 2로만 나눠지는 경우
            else if (N % 2 == 0) {
                dp[N] = Math.min(getSol(N / 2), getSol(N - 1)) + 1;
            }
            // 2와 3으로 나누어지지 않는 경우
            else {
                dp[N] = getSol(N - 1) + 1;
            }
        }


        return dp[N];
    }
}


