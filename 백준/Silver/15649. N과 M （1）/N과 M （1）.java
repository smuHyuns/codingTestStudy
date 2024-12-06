import java.util.*;

public class Main {

    public static Set<List<Integer>> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();


        permutation(new ArrayList<>(), N, M, new boolean[N+1]);


        List<List<Integer>> list = new ArrayList<>(set);

        list.sort((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return Integer.compare(o1.get(i), o2.get(i));
                }
            }
            return 0;
        });

        StringBuilder sb = new StringBuilder();

        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                sb.append(integer + " ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    //순열
    public static void permutation(List<Integer> cur, int N, int M, boolean[] visited) {
        if (cur.size() == M) {
            set.add(cur);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                List<Integer> next = new ArrayList<>(cur);
                next.add(i);
                permutation(next, N, M, visited);
                visited[i] = false;
            }
        }
    }
}
