package BackJoon;

import java.util.Arrays;
import java.util.Scanner;

public class treasure {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arr_num = scan.nextInt();
        int[] arr_A = new int[arr_num];
        int[] arr_B = new int[arr_num];
        for(int i=0; i < arr_num; i++){
            arr_A[i] = scan.nextInt();
        }
        for(int i=0; i < arr_num; i++){
            arr_B[i] = scan.nextInt();
        }
        Arrays.sort(arr_A);
        Arrays.sort(arr_B);
        int result = 0;
        for(int i=0; i<arr_num; i++){
            result += (arr_A[i] * arr_B[arr_num - 1 - i]);
        }
        System.out.println(result);
    }
}
