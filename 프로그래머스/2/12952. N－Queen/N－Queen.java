import java.util.*;

class Solution {
    int[] xrr = {-1, 1, 1, 1, -1, -1, 0, 0};
    int[] yrr = {0, 0, 1, -1, 1, -1, 1, -1};
    
    public int solution(int n) {
        int answer = 0;

        // 가능한 모든 퀸의 배치를 생성
        List<List<Integer>> list = new ArrayList<>();
        combination(list, new ArrayList<>(), n, 0);

        // 모든 경우의 수를 확인
        for (List<Integer> queen : list) {
            boolean[][] board = new boolean[n][n];

            // 퀸 배치
            for (int i = 0; i < queen.size(); i++) {
                int x = queen.get(i) % n;
                int y = queen.get(i) / n;
                board[y][x] = true;
            }

            // 퀸 검사
            boolean isValid = true;
            outerLoop:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] && !dfs(i, j, board)) {
                        isValid = false;
                        break outerLoop;
                    }
                }
            }

            if (isValid) answer++;
        }

        return answer;
    }

    public boolean dfs(int x, int y, boolean[][] board) {
        int N = board.length;
        for (int i = 0; i < 8; i++) {
            int mx = x;
            int my = y;
            while (true) {
                mx += xrr[i];
                my += yrr[i];
                if (mx >= 0 && mx < N && my >= 0 && my < N) {
                    if (board[my][mx]) return false;
                } else {
                    break;
                }
            }
        }
        return true;
    }

    public void combination(List<List<Integer>> list, List<Integer> path, int target, int start) {
        if (path.size() == target) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < target * target; i++) {
            if (!path.contains(i)) {
                path.add(i);
                combination(list, path, target, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
