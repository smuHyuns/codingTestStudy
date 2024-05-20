import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cost = Integer.parseInt(bf.readLine());
        int remain = 1000-cost; //남은돈
        int coins = 0; //개수
        int []arr = {500,100,50,10,5,1};
        for(int i=0; i<6; i++){
            coins += remain/arr[i];
            remain %= arr[i];
        }
        System.out.println(coins);
    }
}