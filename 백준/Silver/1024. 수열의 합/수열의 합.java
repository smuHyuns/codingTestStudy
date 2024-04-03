import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        while(true){
            int min = N/L - ((L-1)/2);
            if( min <0 || L >100){
                System.out.println("-1");
                break;
            }

            int sum = L*(2*min+L-1)/2;
            if(sum == N){
                for(int i=0; i<L; i++){
                    System.out.print(min+i +" ");
                }
                break;
            }
            L++;
        }
    }

}