import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.util.Collections.sort;


public class Main {
    public static void main(String[] args) throws IOException {
        //1. 입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int [] A = new int[N];
        int [] B = new int[N];
        int [] C = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = A[i];
        }

        Arrays.sort(B);

        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(B[i] == A[j]){
                    A[j] = -1;
                    C[j] = count;
                    count++;
                }
            }
        }

        for(int i=0; i<N; i++){
            System.out.print(C[i] + " ");
        }

    }
}


