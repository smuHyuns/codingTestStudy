import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                if (o1[0] == o2[0]) return o1[2] - o2[2];
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int currentTime = 0, totalWaitTime = 0, index = 0, count = 0;

        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= currentTime) {
                pq.offer(new int[]{jobs[index][0], jobs[index][1], index});
                index++;
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                currentTime += job[1];
                totalWaitTime += (currentTime - job[0]);
                count++;
            } else {
                currentTime = jobs[index][0];
            }
        }

        return totalWaitTime / jobs.length;
    }
}
