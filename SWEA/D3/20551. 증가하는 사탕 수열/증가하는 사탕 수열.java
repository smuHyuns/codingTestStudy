import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        /*입력구간*/
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int box = Integer.parseInt(bf.readLine());
        int arr[] = new int[3];
        int candy = 0;
        for(int i=0; i<box; i++){
            candy = 0;
            boolean flag = true;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            if(arr[2] < 3 || arr[1] <= 2 || arr[0] < 1){
                flag = false;
                candy = -1;
            }

            if(flag){
                if(arr[1] >= arr[2]){
                    candy += arr[1] - (arr[2]-1);
                    arr[1] = arr[2]-1;
                }
                if(arr[0] >= arr[1]){
                    candy += arr[0] - (arr[1]-1);
                    arr[0] = arr[1]-1;
                }
            }

            System.out.println("#"+(i+1)+" "+candy);

        }


    }

}
