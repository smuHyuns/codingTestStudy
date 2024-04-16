import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        /*입력구간*/
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(bf.readLine());
        for (int j=1; j<=TC; j++){
            bw.write("#"+j+" ");
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String S[] = new String[N+1];
            String T[] = new String[M+1];

            st = new StringTokenizer(bf.readLine());
            for(int i=1; i<=N; i++){
                S[i] = st.nextToken();
            }
            st = new StringTokenizer(bf.readLine());
            for(int i=1; i<=M; i++){
                T[i] = st.nextToken();
            }

            int Q = Integer.parseInt(bf.readLine());
            for(int i =0; i<Q;i ++){
                int Y = Integer.parseInt(bf.readLine());
                int SNum = Y%N;
                int YNum = Y%M;
                if(SNum == 0) SNum = N;
                if(YNum == 0) YNum = M;
                bw.write(S[SNum]+T[YNum]);
                bw.write(" ");
            }
            bw.write("\n");
            bw.flush();
        }
        bw.close();
    }
}