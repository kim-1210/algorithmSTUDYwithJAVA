package BackJoon;

import java.util.Arrays;
import java.util.Scanner;

public class max_cost {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int city_n = scan.nextInt();
        int[][] field = new int[city_n][city_n];
        for (int i = 0; i < city_n; i++) {
            Arrays.fill(field[i], 9000001);
        }
        int bus_n = scan.nextInt();
        for(int i=0;i<bus_n; i++){
            int k = scan.nextInt();
            int r = scan.nextInt();
            field[k - 1][r - 1] = scan.nextInt();
        }
        int start = scan.nextInt() - 1;
        int end = scan.nextInt() - 1;

        for(int g=0;g<city_n; g++){
            for(int i=0;i<city_n; i++){
                for(int j=0;j<city_n; j++){
                    if(field[g][i] + field[i][j] < field[g][j]){
                        field[g][j] = field[g][i] + field[i][j];
                        g = 0;
                    }
                }
            }
        }
        System.out.println(field[start][end]);
    }
}
