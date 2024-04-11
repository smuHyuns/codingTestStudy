import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        int rgb[][] = new int[N+1][3];
        for (int i = 1; i <=N; i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            rgb[i][0] = Math.min(rgb[i-1][1], rgb[i-1][2]) + r;
            rgb[i][1] = Math.min(rgb[i-1][0], rgb[i-1][2]) + g;
            rgb[i][2] = Math.min(rgb[i-1][0], rgb[i-1][1]) + b;
        }

        System.out.println(Math.min(rgb[N][0], Math.min(rgb[N][1], rgb[N][2])));
    }


}
