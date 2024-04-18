import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(bf.readLine());

        for(int a=1; a<=TC; a++){
            bw.write("#"+a + " ");
            int N = Integer.parseInt(bf.readLine());
            long price[] = new long[N*2];
            boolean isSale[] = new boolean[N*2];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i=0; i<2*N; i++){
                price[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<2*N; i++){
                long salePrice = (long) (price[i] * 0.75);
                for(int j=0; j<2*N; j++){
                    if(isSale[j]) continue;

                    if(price[j] == salePrice && !isSale[i] && !isSale[j]){
                        bw.write(salePrice + " ");
                        isSale[i] = true;
                        isSale[j] = true;
                    }
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }

}

