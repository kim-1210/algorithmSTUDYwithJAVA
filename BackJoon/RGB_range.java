package BackJoon;

import java.util.Scanner;

public class RGB_range {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[][] field = new int[num][3];
        for(int i=0; i < num; i++){
            for(int h =0; h < 3; h++) field[i][h] = scan.nextInt();
        }

        for(int i=1; i<num; i++){
            field[i][0] += Math.min(field[i - 1][1], field[i - 1][2]);
            field[i][1] += Math.min(field[i - 1][2], field[i - 1][0]);
            field[i][2] += Math.min(field[i - 1][1], field[i - 1][0]);
        }
        System.out.println(Math.min(Math.min(field[num - 1][0], field[num - 1][1]), field[num - 1][2]));
    }
}
