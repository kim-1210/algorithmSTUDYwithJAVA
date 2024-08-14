package BackJoon;
//NO.17120

import java.util.Scanner;

public class emoji {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            String k = scan.nextLine();
            if(k.contains(":cat:")){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}
