package BackJoon;

import java.util.Scanner;

public class enter_route {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int w = scan.nextInt();
        int h = scan.nextInt();

        int[][][][] field = new int[h + 1][w + 1][2][2]; //세로 가로 (오른쪽/위) (꺽기X / 꺽기O)
        for (int i = 1; i <= h; i++) {
            field[i][1][1][0] = 1;
        }
        for (int i = 1; i <= w; i++) {
            field[1][i][0][0] = 1;
        }

        for(int j=2;j<=w; j++){
            for(int i=2;i<=h; i++){
                field[i][j][0][0] = (field[i][j - 1][0][0] + field[i][j - 1][0][1]) % 100000;
                field[i][j][0][1] = field[i][j - 1][1][0] % 100000;
                field[i][j][1][0] = (field[i - 1][j][1][0] + field[i - 1][j][1][1]) % 100000;
                field[i][j][1][1] = field[i - 1][j][0][0] % 100000;
            }
        }
        int result = (field[h][w][0][0] + field[h][w][0][1] + field[h][w][1][1] + field[h][w][1][0]) % 100000;
        System.out.println(result);
    }
}
