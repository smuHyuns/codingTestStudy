import java.sql.Array;
import java.util.*;

public class Main {

    public static Set<List<Integer>> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();


        search(new ArrayList<>(), N, M, 0);

        List<List<Integer>> list = new ArrayList<>(set);

        list.sort((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return Integer.compare(o1.get(i), o2.get(i));
                }
            }
            return 0;
        });


        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

    //재귀
    public static void search(List<Integer> cur, int N, int M, int before) {
        // M개만큼 모두고른 경우
        if (cur.size() == M) {
            set.add(cur);
            return;
        }

        //탐색
        for (int i = before+1; i <= N; i++) {
            List<Integer> next = new ArrayList<>(cur);
            next.add(i);
            search(next, N, M, i);
        }
    }
}