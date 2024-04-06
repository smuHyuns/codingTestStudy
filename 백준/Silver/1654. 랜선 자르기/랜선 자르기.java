import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K;
    static long arr[];
    public static void main(String[] args) throws IOException {
        /*입력구간*/
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new long[K];
        long max = 0;
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(bf.readLine());
            if(i == 0) max = arr[0];
            if(max <= arr[i]) max = arr[i];
        }
        long sol = binarySearch(1, max, N);
        System.out.println(sol);

    }

    public static long binarySearch(long low, long high, int target){
        long mid, sum;
        while(low <= high){
            sum = 0;
            mid = (low+high)/2;

            for(int i=0; i<K; i++){
                sum += arr[i]/mid;
            }

            if(sum >= target){
                low = mid + 1;
            }

            else{
                high = mid -1;
            }
        }

        return high;
    }

}
