import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //첫째줄 입력
        int N = Integer.parseInt(br.readLine());
        int []A = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        //둘째줄
        int M = Integer.parseInt(br.readLine());
        int []B = new int [M];
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<M; j++){
            B[j] = Integer.parseInt(st.nextToken());
        }

        //이분탐색을 위한 정렬
        Arrays.sort(A);

        //찾기
        for(int i=0; i<M; i++){
            bw.write(checkSol(B[i],A) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static int checkSol(int target, int []arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] < target){
                start = mid+1;
            }
            else if(arr[mid] > target){
                end = mid-1;
            }
            else return 1;
        }

        return 0;
    }
}