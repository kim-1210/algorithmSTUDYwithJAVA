package BackJoon;

import java.util.Arrays;
import java.util.Scanner;

public class candy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test_n = scan.nextInt();
        for(int i=0;i<test_n; i++){
            int candy_n = scan.nextInt();
            int box_n = scan.nextInt();
            int[] boxes = new int[box_n];
            for(int j = 0; j<box_n; j++){
                boxes[j] = (scan.nextInt() * scan.nextInt());
            }
            Arrays.sort(boxes);
            int cnt = 1;
            for(int j = 0; j < boxes.length; j++){
                if(candy_n - boxes[boxes.length - 1 - j] <= 0)break;
                candy_n -= boxes[boxes.length - 1 - j];
                cnt++;
            }
            System.out.println(cnt);
        }
    }    
}
