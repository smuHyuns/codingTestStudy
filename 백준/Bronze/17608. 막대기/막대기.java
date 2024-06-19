import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            stack.add(Integer.valueOf(br.readLine()));
        }
        int max = 0;
        int count =0;
        while(!stack.isEmpty()){
            int top = stack.pop();
            if( top> max){
                max = top;
                count++;
            }
        }
        System.out.println(count);
    }
}