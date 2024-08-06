package BackJoon;

import java.util.Scanner;

public class stick {
    public static void main(String[] args) {
        int cnt = 1;
        Scanner scan = new Scanner(System.in);
        int problem = scan.nextInt();
        int cm = 64;
        while(true){
            if(problem - cm == 0){
                break;
            }
            cm /= 2;
            if(problem - cm > 0){
                cnt++;
                problem -= cm;
            }
        }
        System.out.println(cnt);
    }    
}
