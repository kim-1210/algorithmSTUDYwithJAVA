import java.util.*;

public class minShort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = scan.nextInt() - 1;
            int to = scan.nextInt() - 1;
            int cost = scan.nextInt();
            graph.get(from).add(new int[]{to, cost});
            graph.get(to).add(new int[]{from, cost});
        }

        int[] distance = dijkstra(graph, n);
        System.out.println(distance[n - 1]);
    }

    public static int[] dijkstra(List<List<int[]>> graph, int n) {
        int inf = Integer.MAX_VALUE;
        int[] distance = new int[n];
        Arrays.fill(distance, inf);
        distance[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // 오름차순으로 정렬
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currNode = current[0];
            int currDist = current[1];
            if (currDist > distance[currNode]) continue; //현재 처리중인 노드보다 크다면 무시

            for (int[] edge : graph.get(currNode)) {
                int nextNode = edge[0];
                int weight = edge[1];
                if (distance[currNode] + weight < distance[nextNode]) {
                    distance[nextNode] = distance[currNode] + weight;
                    pq.add(new int[]{nextNode, distance[nextNode]});
                }
            }
        }
        return distance;
    }
}
