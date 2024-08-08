package BackJoon;

import java.util.Arrays;
import java.util.Scanner;

public class soldier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] a = new int[n];
        for(int i=0;i<n; i++){
            a[i] = scan.nextInt();
        }

        int[] field = new int[n];
        Arrays.fill(field, 1);

        for(int i=1; i<n; i++){
            for(int h=0; h<i; h++){
                if(a[h] > a[i]){
                    field[i] = Math.max(field[i], field[h] + 1);
                }
            }
        }
        int max = field[0];
        for (int i = 1; i < field.length; i++) {
            if (field[i] > max) {
                max = field[i];
            }
        }
        System.out.println(n - max);
    }
}
