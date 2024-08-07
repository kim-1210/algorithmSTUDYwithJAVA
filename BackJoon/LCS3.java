package BackJoon;

import java.util.Scanner;

public class LCS3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String A = scan.nextLine();
        String B = scan.nextLine();
        String C = scan.nextLine();
        int[][][] field = new int[A.length() + 1][B.length() + 1][C.length() + 1];

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                for (int g = 1; g <= C.length(); g++) {
                    if((A.charAt(i-1) == B.charAt(j-1)) && (B.charAt(j-1) == C.charAt(g-1))){
                        field[i][j][g] = field[i-1][j-1][g-1] + 1;
                    }
                    else{
                        field[i][j][g] = Math.max(field[i-1][j][g], Math.max(field[i][j-1][g], field[i][j][g-1]));
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                for (int g = 1; g <= C.length(); g++) {
                    if(field[i][j][g] > result){ result = field[i][j][g];}
                }
            }
        }
        System.out.println(result);
    }
}
