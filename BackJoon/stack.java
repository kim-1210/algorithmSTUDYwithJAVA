package BackJoon;

import java.util.Scanner;
import java.util.Vector;

public class stack {

    public static void main(String[] args) {
        Vector<Integer> arr = new Vector<>();
        Scanner scan = new Scanner(System.in);
        int order_cnt = scan.nextInt();
        scan.nextLine();
        for(int i=0; i<order_cnt; i++){
            String r = scan.nextLine();
            String[] k = r.split(" ");
            if(k[0].contains("push")){
                int r1 = Integer.parseInt(k[1]);
                arr.add(r1);
            }
            else if(k[0].contains("pop")){
                if(!arr.isEmpty()){System.out.println(arr.get(arr.size() - 1)); arr.remove(arr.size() - 1);}
                else{System.out.println(-1);}
            }
            else if(k[0].contains("size")){
                System.out.println(arr.size());
            }
            else if(k[0].contains("empty")){
                System.out.println((arr.isEmpty())?1:0);
            }
            else if(k[0].contains("top")){
                if(!arr.isEmpty()){System.out.println(arr.get(arr.size() - 1));}
                else{System.out.println(-1);}
            }
        }
    }
}
