import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // NxN의 크기
        int M = sc.nextInt(); // M개

        // 큐를 두 개 만듬
        // 1개는 1저장용(집)
        // 1개는 2저장용(치킨집)
        // 그래서 집에서 하나를 꺼낼 때마다 치킨집과의 거리를 구할 거임 (for 문을 이용해 queue 탐색)
        // 그래서 int[]형 배열을 만들어서 거기에다가 값이 생길 때마다 저장

        Deque<int[]> house = new ArrayDeque<>(); // 집 좌표 저장용 큐
        List<int[]> shop = new ArrayList<>(); // 치킨집 좌표 저장용 리스트

        // 입력받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int input = sc.nextInt();
                if (input == 1) {
                    house.offer(new int[]{i, j});
                } else if (input == 2) {
                    shop.add(new int[]{i, j});
                }
            }
        }

        // 최소 도시 치킨 거리 초기화
        int answer = Integer.MAX_VALUE;

        // 치킨집 조합 생성 및 최소 거리 계산
        answer = findSol(house, shop, M);

        // 결과 출력
        System.out.println(answer);
    }

    // M개의 치킨집을 선택한 후, 도시 치킨 거리 계산
    public static int findSol(Deque<int[]> houses, List<int[]> chickenShops, int M) {
        List<List<int[]>> combinations = new ArrayList<>();
        findCombinations(chickenShops, new ArrayList<>(), combinations, M, 0);

        int minDistance = Integer.MAX_VALUE;

        // 각 조합에 대해 도시 치킨 거리 계산
        for (List<int[]> combination : combinations) {
            int cityDistance = 0;
            for (int[] house : houses) {
                int houseDistance = Integer.MAX_VALUE;
                for (int[] shop : combination) {
                    houseDistance = Math.min(houseDistance, absDistance(house[0], house[1], shop[0], shop[1]));
                }
                cityDistance += houseDistance;
            }
            minDistance = Math.min(minDistance, cityDistance);
        }

        return minDistance;
    }

    // 치킨집 조합 구하기
    public static void findCombinations(List<int[]> q2, List<int[]> current, List<List<int[]>> result, int M, int index) {
        if (current.size() == M) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < q2.size(); i++) {
            current.add(q2.get(i));
            findCombinations(q2, current, result, M, i + 1);
            current.remove(current.size() - 1);
        }
    }

    // 두 좌표 사이의 거리 계산 (맨해튼 거리)
    public static int absDistance(int x, int y, int dx, int dy) {
        return Math.abs(x - dx) + Math.abs(y - dy);
    }
}
