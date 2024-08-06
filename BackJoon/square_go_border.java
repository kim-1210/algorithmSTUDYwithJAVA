package BackJoon;

import java.util.Scanner;

public class square_go_border {

    public static void main(String[] args) {
        int x, y, w, h;
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        y = scan.nextInt();
        w = scan.nextInt();
        h = scan.nextInt();
        int min_x, min_y;
        if(Math.abs(w - x) < x){
            min_x = Math.abs(w - x);
        }
        else{
            min_x = x;
        }
        if(Math.abs(h - y) < y){
            min_y = Math.abs(h - y);
        }
        else{
            min_y = y;
        }
        if(min_x < min_y){
            System.out.println(min_x);
        }
        else{
            System.out.println(min_y);
        }
    }
}
