package BackJoon;

import java.util.Scanner;

public class Fibonachi {
    public static void main(String[] args) {
        int num = (new Scanner(System.in)).nextInt();
        int[] fibonachi = new int[num + 1];
        fibonachi[0] = 0;
        fibonachi[1] = 1;
        for(int i=2; i < num + 1; i++){
            fibonachi[i] = fibonachi[i - 2] + fibonachi[i - 1];
        }
        System.out.println(fibonachi[num]);
    }
}
