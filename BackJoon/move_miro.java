package BackJoon;

import java.util.Scanner;

public class move_miro {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int h = scan.nextInt(); 
        int w = scan.nextInt();

        int[][] field = new int[h][w];
        for(int i=0;i<h; i++){
            for(int j = 0; j<w; j++){
                field[i][j] = scan.nextInt();
            }
        }

        for(int i= 0;i<h; i++){
            for(int j = 0; j<w; j++){
                if(i != 0 && j != 0){
                    field[i][j] += Math.max(field[i - 1][j], Math.max(field[i][j - 1], field[i - 1][j - 1]));
                }
                else if(i != 0){
                    field[i][j] += field[i - 1][j];
                }
                else if(j != 0){
                    field[i][j] += field[i][j - 1];
                }
            }
        }
        System.out.println(field[h - 1][w - 1]);
    }
}
