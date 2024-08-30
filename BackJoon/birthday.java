package BackJoon;

import java.util.Scanner;
//No.5635
public class birthday {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int max = -1, min = 1200000000;
        String max_name = "", min_name = "";
        for(int i=0;i< n; i++){
            String name = scan.next();
            int day = scan.nextInt();
            int month = scan.nextInt();
            int year = scan.nextInt();
            int value = year * 100 + month * 10 + day + 1;
            if(max < value){
                max = value;
                max_name = name;
            }
            if(min > value){
                min = value;
                min_name = name;
            }
        }
        System.out.println(max_name + "\n" + min_name);
    }
}
