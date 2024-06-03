import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int bringTrees = Integer.parseInt(st.nextToken());
        int []trees = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = Arrays.stream(trees).max().getAsInt();
        long sol = 0;

        while(start <= end){
            int mid = (start+end)/2;
            if( bringTrees <= calTrees(trees,mid)) {
                sol = mid;
                start = mid+1;
            }
            else { //calTrees(trees,mid) > bringTrees)
                end = mid-1;
            }
        }

        System.out.println(sol);

    }

    public static long calTrees(int []trees, int len) {
        long cnt = 0;

        for (int tree : trees) {
            if (tree > len) {
                cnt += tree - len;
            }
        }
        return cnt;
    }




}