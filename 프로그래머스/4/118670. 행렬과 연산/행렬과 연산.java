import java.util.*;

class Solution {
    public int[][] solution(int[][] arr, String[] operations) {
        int xLEN = arr[0].length;
        int yLEN = arr.length;
        int[][] move = new int[yLEN][xLEN];

        for (String op : operations) {
            if (op.equals("ShiftRow")) {
                // ShiftRow: 모든 행을 아래로 한 칸씩 이동
                for (int y = 0; y < yLEN; y++) {
                    if (y == yLEN - 1) {
                        // 마지막 행은 첫 번째 행으로 이동
                        move[0] = Arrays.copyOf(arr[y], xLEN);
                    } else {
                        // 나머지 행은 한 행 아래로 이동
                        move[y + 1] = Arrays.copyOf(arr[y], xLEN);
                    }
                }
            } else {
                // Rotate: 바깥쪽 원소들을 시계 방향으로 한 칸 이동
                for (int y = 0; y < yLEN; y++) {
                    for (int x = 0; x < xLEN; x++) {
                        if (y == 0 && x < xLEN - 1) {
                            // 첫 행의 모든 원소는 오른쪽으로 한 칸 이동
                            move[y][x + 1] = arr[y][x];
                        } else if (x == xLEN - 1 && y < yLEN - 1) {
                            // 끝 열의 모든 원소는 아래로 한 칸 이동
                            move[y + 1][x] = arr[y][x];
                        } else if (y == yLEN - 1 && x > 0) {
                            // 끝 행의 모든 원소는 왼쪽으로 한 칸 이동
                            move[y][x - 1] = arr[y][x];
                        } else if (x == 0 && y > 0) {
                            // 첫 열의 모든 원소는 위로 한 칸 이동
                            move[y - 1][x] = arr[y][x];
                        }
                    }
                }
                // Rotate 작업에서 중앙 부분을 처리
                move[0][0] = arr[1][0];
                move[yLEN-1][xLEN-1] = arr[yLEN-1][xLEN-2];
            }

            // 복제: 현재 move 배열의 내용을 arr 배열로 복사
            for (int y = 0; y < yLEN; y++) {
                for (int x = 0; x < xLEN; x++) {
                    arr[y][x] = move[y][x];
                }
            }
        }

        return arr; // 최종 결과를 반환
    }
}
