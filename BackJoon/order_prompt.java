package BackJoon;

import java.util.Scanner;

public class order_prompt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.nextLine();

        String[] str = new String[num];
        for(int i=0;i<num; i++){
            str[i] = scan.nextLine();
        }
        String result = "";
        for(int i = 0; i<str[0].length(); i++){
            char r = str[0].charAt(i);
            boolean check = true;
            for(int h = 0; h<num; h++){
                if(str[h].charAt(i) != r){
                    result += '?';
                    check = false;
                    break;
                }
            }
            if(check){
                result += r;
            }
        }
        System.out.println(result);
    }
}
