package data_structure;

public class floyd {
    public static int INF = 10000000;
    public static void main(String[] args) {
        int[][] field = {{0, 7, INF, INF, 3, 10, INF}, 
        {7, 0, 4 ,10, 2, 6, INF}, 
        {INF, 4, 0, 2, INF, INF, INF}, 
        {INF, 10, 2, 0, 11, 9, 4}, 
        {3, 2, INF, 11, 0, INF, 5}, 
        {10, 6, INF, 9, INF, 0, INF}, 
        {INF, INF, INF, 4, 5, INF, 0}};

        all_shortest_path(field);

    }
    public static void all_shortest_path(int[][] field){
        int[][] field_a = new int[field.length][field.length];
        for(int i=0;i<field.length; i++){
            for(int j=0; j<field.length; j++){
                field_a[i][j] = field[i][j];
            }
        }

        for(int i=0;i<field.length; i++){
            for(int j=0; j<field.length; j++){
                for(int k=0;k<field.length; k++){
                    if(field_a[j][i] + field_a[i][k] < field_a[j][k]){
                        field_a[j][k] = field_a[j][i] + field_a[i][k];
                    }
                }
            }
        }

        for(int i=0;i<field.length; i++){
            for(int j=0; j<field.length; j++){
                System.out.print(field_a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
