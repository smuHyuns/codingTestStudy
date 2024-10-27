import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case=1; test_case<=10; test_case++){
            int T;
            T=sc.nextInt();

            int[] height = new int[T];
            // 값 입력받아 저장
            for(int t = 0; t < T; t++){
                height[t] = sc.nextInt();
            }

            // 값 계산하기
            int sum = 0;
            int[] arr = {-2,-1,1,2};
            for(int i=0; i<T; i++){
                // 유효한 범위인지 계산
                int max = 0;
                for(int j=0; j<4; j++){
                    int range = i + arr[j];
                    if(range >= 0 && range<T){
                        max = Math.max(max, height[range]);
                    }
                }
                if(max < height[i]) sum += height[i] - max;
            }
            System.out.println("#"+test_case+" "+sum);
        }


    }
}