package BackJoon;

import java.util.Scanner;

public class max_value{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max = -1;
        int a = -1, b = -1;
        for(int i=0; i<9; i++){
            for(int j=0;j<9; j++){
                int k = scan.nextInt();
                if(max < k){
                    max = k;
                    a = i;
                    b = j;
                }
            }
        }
        System.out.println(max);
        System.out.println((a + 1) + " " + (b + 1));
    }
}