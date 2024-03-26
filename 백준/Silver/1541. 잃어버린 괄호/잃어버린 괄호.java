import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = new int[30];
    static char[] sign = new char[30];
    static int signIndex=0, arrIndex=0;
    static int min = 0;
    static int maxIndex = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        extract(str);
        min = arr[0];

        for(int i=1; i<arrIndex; i++){
            if(sign[i-1] == '+') min += arr[i];
            else{
                maxIndex = i;
                max = arr[i];
                dfs(i+1, arr[i]);
                i = maxIndex;
                min -= max;
            }
            maxIndex =0;
            max = 0;
        }
        System.out.println(min);
    }

    // 5 - 8 + 7 + 3 + 2 - 45 + 55
    // 쭉돌면서 어디까지가 더하는 것이 최대인지 구함
    // 최대값을 max, 최대 당시 index를 max로
    private static void dfs(int index, int sum) {
        if(index == arrIndex){
            return;
        }
        if(sign[index-1] == '+'){
            if(sum + arr[index] > max){
                max = sum + arr[index];
                maxIndex = index;
            }
            dfs(index+1, sum+arr[index]);
        }
        else if(sign[index-1] == '-'){
            dfs(arrIndex, sum-arr[index]);
        }

    }

    private static void extract(String str) {
        for(int i = 0; i< str.length(); i++){
            char A = str.charAt(i);
            if(A == '-' || A == '+'){
                sign[signIndex] = A;
                signIndex++;
            }
        }
        String intStr = str.replaceAll("[^0-9]"," ");
        StringTokenizer st = new StringTokenizer(intStr);
        while(st.hasMoreTokens()){
            arr[arrIndex] = Integer.parseInt(st.nextToken());
            arrIndex++;
        }
    }

}
