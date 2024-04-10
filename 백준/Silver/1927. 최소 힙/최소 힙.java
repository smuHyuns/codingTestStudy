import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int input = Integer.parseInt(bf.readLine());
            if(input == 0){
                if(queue.isEmpty()) bw.write("0\n");
                else bw.write(queue.poll() + "\n");
            }
            else queue.add(input);
        }

        bw.flush();
        bw.close();

    }

}
