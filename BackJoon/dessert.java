package BackJoon;

import java.util.Scanner;

public class dessert {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int day = scan.nextInt();
        int dessert_n = scan.nextInt();

        int[][] pomangam = new int[dessert_n][day];
        for(int i=0;i<dessert_n; i++){
            for(int h=0;h<day; h++){
                pomangam[i][h] = scan.nextInt();
            }
        }

        int[][] field = new int[day][dessert_n];
        for(int i=0;i<dessert_n; i++){
            field[0][i] = pomangam[i][0];
        }

        for(int i=1; i < day; i++){
            for(int h=0;h<dessert_n; h++){
                int max = -1;
                for(int j=0;j<dessert_n; j++){
                    if(j != h && max < field[i - 1][j]){
                        max = field[i - 1][j];
                    }
                }
                field[i][h] = Math.max(field[i - 1][h] + (pomangam[h][i] / 2), max + pomangam[h][i]);
            }
        }
        int result = 0;
        for(int i=0; i < dessert_n; i++){
            result = (result < field[day - 1][i])? field[day - 1][i] : result;
        }
        System.out.println(result);
    }
}
