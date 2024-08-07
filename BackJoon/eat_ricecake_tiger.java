package BackJoon;

import java.util.Scanner;

public class eat_ricecake_tiger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int day = scan.nextInt();
        int ricecake = scan.nextInt();

        int[][] math = new int[day][2]; //0은 x, 1은 y
        math[0][0] = 1;
        math[1][1] = 1;
        for(int i=2; i<day; i++){
            math[i][0] = math[i - 1][0] + math[i - 2][0];
            math[i][1] = math[i - 1][1] + math[i - 2][1];
        }
        int cnt = 1;
        int A, B;
        while(true){
            if((ricecake - math[day - 1][0] * cnt) % math[day - 1][1] == 0){
                int y = (ricecake - math[day - 1][0] * cnt) / math[day - 1][1];
                int pre_2 = math[day - 2][0] * cnt + math[day - 2][1] * y;
                int pre_3 = math[day - 3][0] * cnt + math[day - 3][1] * y;
                if(pre_2 + pre_3 == ricecake){
                    A = cnt;
                    B = y;
                    break;
                } 
            }
            cnt++;
        }
        System.out.println(A + "\n" + B);
    }
}