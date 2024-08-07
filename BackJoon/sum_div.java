package BackJoon;

import java.util.Scanner;

public class sum_div {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int MOD = 1000000000;
        int[][] cnt = new int[k + 1][n + 1];
        cnt[0][0] = 1;

        for(int i = 1; i <= k; i++){
            for(int h = 0; h <= n; h++){
                for(int m = 0; m <= h; m++){
                    cnt[i][h] = (cnt[i][h] + cnt[i-1][h-m]) % MOD;
                }
            }
        }

        System.out.println(cnt[k][n]);
    }
}

