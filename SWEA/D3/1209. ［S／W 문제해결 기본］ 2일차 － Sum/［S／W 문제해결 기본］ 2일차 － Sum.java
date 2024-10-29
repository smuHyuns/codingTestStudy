import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
       Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int T;
            T=sc.nextInt();
            /*
            100x100 배열 선언한 후
            각줄마다 구하면됨
            */
            int[][] arr = new int[100][100];
            for(int i =0; i<100; i++){
                for(int j=0; j<100; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            //sum = 비교수 / max = 정답(최대값)
            int sum = 0;
            int max = 0;

            //가로
            for(int i=0; i<100; i++){
                sum = 0;
                for(int j=0; j<100; j++){
                    sum+= arr[i][j];
                }
                max = Math.max(max, sum);
            }

            //세로
            for(int i=0; i<100; i++){
                sum = 0;
                for(int j=0; j<100; j++){
                    sum+= arr[j][i];
                }
                max = Math.max(max, sum);
            }

            //대각선
            sum = 0;
            int sum2 = 0;
            for(int i=0; i<100; i++){
                sum += arr[i][i];
                sum2 += arr[99-i][i];
                max = Math.max(max,sum);
                max = Math.max(max,sum2);
            }

            System.out.println("#"+test_case+" "+max);
            
		}
	}
}