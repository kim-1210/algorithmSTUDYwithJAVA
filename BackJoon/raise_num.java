package BackJoon;

import java.util.Scanner;

public class raise_num {
    public static void main(String[] args) {
        int num = (new Scanner(System.in)).nextInt();
        int result = 0;
        int[][] field = new int[num][10];
        for(int i=0;i<10; i++){
            field[0][i] = 1;
        }

        for(int i=1; i<num; i++){
            for(int j=0;j<10; j++){
                int sum = 0;
                for(int h = j; h < 10; h++){
                    field[i][j] += field[i - 1][h];
                    field[i][j] %= 10007;
                }
            }
        }

        for(int i=0; i<10; i++){
            result += field[num - 1][i];
        }
        result %= 10007;
        System.out.println(result);
    }
}
