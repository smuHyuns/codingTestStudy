import java.util.*;

class Solution {
    static ArrayDeque<Integer> col1, col2;
    static LinkedList<ArrayDeque<Integer>> rows;

    public int[][] solution(int[][] rc, String[] operations) {
        col1 = new ArrayDeque<>();
        col2 = new ArrayDeque<>();
        rows = new LinkedList<>();
        int M = rc.length;     // 행의 개수
        int N = rc[0].length;  // 열의 개수

        // Initialize columns and rows
        for (int i = 0; i < M; i++) {
            col1.offer(rc[i][0]);
            col2.offer(rc[i][N - 1]);
            ArrayDeque<Integer> row = new ArrayDeque<>();
            for (int j = 1; j < N - 1; j++) {
                row.offer(rc[i][j]);
            }
            rows.add(row);
        }

        // Process operations
        for (String o : operations) {
            if (o.equals("ShiftRow")) {
                // ShiftRow
                col1.offerFirst(col1.pollLast());
                col2.offerFirst(col2.pollLast());
                rows.offerFirst(rows.pollLast());
            } else if (o.equals("Rotate")) {
                // Rotate
                rows.getFirst().offerFirst(col1.pollFirst());
                col2.offerFirst(rows.getFirst().pollLast());
                rows.getLast().offerLast(col2.pollLast());
                col1.offerLast(rows.getLast().pollFirst());
            }
        }

        // Prepare the result matrix
        int[][] sol = new int[M][N];
        for (int i = 0; i < M; i++) {
            sol[i][0] = col1.pollFirst();
            int j = 1;
            for (int value : rows.pollFirst()) {
                sol[i][j++] = value;
            }
            sol[i][N - 1] = col2.pollFirst();
        }

        return sol;
    }
}
