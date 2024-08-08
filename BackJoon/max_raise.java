package BackJoon;
// NO.25644

import java.util.Scanner;

public class max_raise {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n; i++){
            a[i] = scan.nextInt();
        }

        int min = a[0];
        int result = 0;
        for(int i=1;i<n; i++){
            if(a[i] < min){min = a[i];}
            else{
                int minus = a[i] - min;
                if(minus > result){
                    result = minus;
                }
            }
        }
        System.out.println(result);

        //int[] field = new int[n];
        // int max = -1;
        // for(int i=0;i<n; i++){ //일수
        //     for(int j=i; j<n; j++){ //
        //         field[i] = Math.max(Math.abs(Math.min(a[j - i] - a[j], 0)), field[i]);
        //     }
        //     max = (max < field[i])?field[i]:max;
        // }
        // System.out.println(max);
    }
}
