import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    static Stack<Character> myStack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String input = br.readLine();
            bw.write(findSol(input) + "\n");
            myStack.clear();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static String findSol(String input) {

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(')
                myStack.push('(');
            else {
                if (myStack.isEmpty()) return "NO";
                myStack.pop();
            }
        }

        if (myStack.isEmpty()) return "YES";
        else return "NO";
    }

}