import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
				//✅ 인풋을 본인이 쓰기 편한 구조로 바꾸기 => 무향 그래프 만들기
        Arrays.sort(summits);
        Set<Integer> summitSet = IntStream.of(summits).boxed().collect(Collectors.toSet());
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] path : paths) {
            graph.putIfAbsent(path[0], new LinkedList<>());
            graph.putIfAbsent(path[1], new LinkedList<>());
            
            graph.get(path[0]).add(new Edge(path[1], path[2]));
            graph.get(path[1]).add(new Edge(path[0], path[2]));
        }
        
				//✅ 모든 출입구를 우선순위큐에 삽입한다.
        Queue<Entry> hq = new PriorityQueue<>();
        int[] visited = new int[n + 1];
				// 초기값으로 Integer.MAX_VALUE를 사용해도 된다.
        Arrays.fill(visited, 10000001);
        for (int gate : gates) {
            hq.add(new Entry(0, gate));
            visited[gate] = 0;
        }

        //✅ intensity를 기준으로 다익스트라를 진행한다.
        while (!hq.isEmpty()) {
            Entry e = hq.remove();
            if (e.intensity > visited[e.node] || summitSet.contains(e.node)) {
                continue;
            }
            
            for (Edge edge : graph.get(e.node)) {
                int nextIntensity = Math.max(edge.weight, e.intensity);
                if (nextIntensity < visited[edge.node]) {
										//✅ 다익스트라 진행 중 각 노드에 도달하는 과정의 최대 intensity값을 저장한다.
                    visited[edge.node] = nextIntensity;
                    hq.add(new Entry(nextIntensity, edge.node));
                }
            }
        }
        
				//✅ 다익스트라 완료 후 산봉우리들을 순회하며 정답을 찾는다.
        int[] minIntensity = {0, 10000001};
        for (int summit : summits) {
            if (minIntensity[1] > visited[summit]) {
                minIntensity[0] = summit;
                minIntensity[1] = visited[summit];
            }
        }
        
        return minIntensity;
    }
    
    static class Entry implements Comparable<Entry> {
        int intensity;
        int node;
        
        public Entry(int intensity, int node) {
            this.intensity = intensity;
            this.node = node;
        }
        
        @Override
        public int compareTo(Entry o) {
            return this.intensity - o.intensity;
        }
    }
    
    static class Edge {
        int node;
        int weight;
        
        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}