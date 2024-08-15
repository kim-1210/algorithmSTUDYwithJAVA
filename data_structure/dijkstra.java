package data_structure;
//한 정점에서의 최단거리
public class dijkstra {
    public static int INF = 10000000;
    public static void main(String[] args) {
        int[][] field = {{0, 7, INF, INF, 3, 10, INF}, 
        {7, 0, 4 ,10, 2, 6, INF}, 
        {INF, 4, 0, 2, INF, INF, INF}, 
        {INF, 10, 2, 0, 11, 9, 4}, 
        {3, 2, INF, 11, 0, INF, 5}, 
        {10, 6, INF, 9, INF, 0, INF}, 
        {INF, INF, INF, 4, 5, INF, 0}};
        shortest_path(field, 0);
    }

    public static void shortest_path(int[][] field, int start){
        int[] distance = new int[field.length];
        boolean[] found = new boolean[field.length];
        for(int i=0;i<field.length; i++){
            distance[i] = field[start][i];
            found[i] = false;
        }
        found[start] = true;
        distance[start] = 0;
        for(int i=0;i<field.length - 1; i++){
            int u = choose(distance, field.length, found);
            found[u] = true;
            for(int w = 0; w < field.length; w++){
                if(!found[w]){
                    if(distance[u] + field[u][w] < distance[w]){
                        distance[w] = distance[u] + field[u][w];
                    }
                }
            }
        }
        System.out.println(start + " 에서 다른 모든 정점의 최단거리");
        for(int i=0;i<field.length; i++){
            System.out.print(distance[i] + " ");
        }
    }

    public static int choose(int[] distance, int n, boolean[] found){
        int min = INF, minpos = -1;
        for(int i=0;i<n; i++){
            if(distance[i] < min && !found[i]){
                min = distance[i];
                minpos = i;
            }
        }
        return minpos;
    }
}
