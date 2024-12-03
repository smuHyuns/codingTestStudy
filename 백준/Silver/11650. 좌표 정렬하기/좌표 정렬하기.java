import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new int[]{a, b});
        }

        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        for (int[] ints : list) {
            System.out.println(ints[0] + " " + ints[1]);
        }


    }

}
