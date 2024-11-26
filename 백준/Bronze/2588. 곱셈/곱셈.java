import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b= sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int sum = a*b;
        for(int i=0; i<3; i++){
            int add = a * (b%10);
            sb.append(add).append('\n');
            b /= 10;
        }
        sb.append(sum);

        System.out.println(sb);
    }
}
