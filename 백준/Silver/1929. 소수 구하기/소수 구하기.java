import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static boolean isPrime[];
    static void checkIsPrime(int N, int M){
        isPrime = new boolean[M+1];
        for(int i=0; i<=M; i++){
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i<=Math.sqrt(M); i++){
            if(isPrime[i]){
                for(int j= i*i; j<=M; j+=i){
                    isPrime[j] = false;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        checkIsPrime(N,M);
        for(int i=N; i<=M; i++){
            if (isPrime[i]){
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
        bf.close();
    }

}