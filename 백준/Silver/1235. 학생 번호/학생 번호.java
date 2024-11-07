import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] list = new String[N];

        for (int i = 0; i < N; i++) {
            list[i] = sc.next();
        }

        int len = list[0].length();
        for (int i = 1; i <= len; i++) {
            Set<String> set = new HashSet<>();
            for (String l : list) {
                String slice = l.substring(len - i);
                set.add(slice);
            }
            if (set.size() == N) {
                System.out.println(i);
                break;
            }
        }

    }
}
