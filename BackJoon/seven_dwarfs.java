package BackJoon;
// No.3040

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class seven_dwarfs {
    public static void main(String[] args) {
        int[] num = new int[9];
        Scanner scan = new Scanner(System.in);
        for(int i=0;i<9; i++){
            num[i] = scan.nextInt();
        }
        int[] result = Arrays.stream(find_dwarfs(num)).filter(s -> s != 0).toArray();
        for(int k : result){
            System.out.println(k);
        }
    }

    public static int[] find_dwarfs(int[] num){
        for(int i=0;i<7; i++){
            int[] copy_n = num.clone();
            copy_n[i] = 0;
            for(int h=i + 1; h< 9; h++){
                int temp = copy_n[h];
                copy_n[h] = 0;
                if(Arrays.stream(copy_n).sum() == 100){
                    return copy_n;
                }
                copy_n[h] = temp;
            }
        }
        return null;
    }
}
