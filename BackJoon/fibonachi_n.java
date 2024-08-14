package BackJoon;
//NO.1003

import java.util.Scanner;

public class fibonachi_n {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test_case_n = scan.nextInt();
        int[][] answer = new int[test_case_n][2];
        for(int i=0;i<test_case_n; i++){
            int n = scan.nextInt();
            if(n == 0){
                answer[i][0] = 1;
                answer[i][1] = 0;
            }
            else if(n == 1){
                answer[i][0] = 0;
                answer[i][1] = 1;
            }
            else{
                int[][] field = new int[n + 1][2];
                field[0][0] = 1;
                field[1][1] = 1;
                for(int j=2; j<=n; j++){
                    field[j][0] = field[j - 1][0] + field[j - 2][0];
                    field[j][1] = field[j - 1][1] + field[j - 2][1];
                }
                answer[i][0] = field[n][0];
                answer[i][1] = field[n][1];
            }
        }
        for(int i=0;i<test_case_n; i++){
            System.out.println(answer[i][0] + " " + answer[i][1]);
        }
    }
}
