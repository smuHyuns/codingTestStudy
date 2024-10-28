import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        // 가로는 언제나 100
        // 상자의 높이는 1이상 100 이하
        // 덤프횟수는 1이상 1000 이하
        // 평탄화 완료되면 최고점과 최저점의 높이 차를 반환

        for(int test_case = 1; test_case <= 10; test_case++){
            int T=sc.nextInt();
            int[] box = new int[100];
            for(int i=0; i<100; i++){
                box[i] = sc.nextInt();
            }
            int max=0, min=0, maxIdx, minIdx;
            for(int i=0; i<T; i++){
                max = box[0];
                min = box[0];
                maxIdx = 0;
                minIdx = 0;
                for(int j=0; j<100; j++){
                    if(max < box[j]){
                        max = box[j];
                        maxIdx = j;
                    }
                    if(min > box[j]){
                        min = box[j];
                        minIdx = j;
                    }
                }
                if(max == min || max - min == 1){
                    break;
                }
                box[maxIdx] --;
                box[minIdx] ++;
            }

            max = box[0];
            min = box[0];

            for(int i=0; i<100; i++){
                max = Math.max(max,box[i]);
                min = Math.min(min,box[i]);
            }

            System.out.println("#"+test_case+" "+(max-min));
        }
    }
}