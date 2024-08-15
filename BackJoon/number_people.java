package BackJoon;
//NO.2644
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class number_people {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int peo_n = scan.nextInt();
        int[] field = new int[peo_n];
        Arrays.fill(field, -1);
        Stack<Integer> a_n = new Stack<>();
        Stack<Integer> b_n = new Stack<>();

        int a = scan.nextInt() - 1, b = scan.nextInt() - 1;
        a_n.add(a);
        b_n.add(b);

        int n = scan.nextInt();
        for(int i=0;i<n; i++){
            int r = scan.nextInt(), k = scan.nextInt();
            field[k - 1] = r - 1;
        }
        if(a == b){System.out.println("0"); return;}

        boolean check1 = false, check2 = false;
        while(!check1 || !check2){
            check1 = (field[a] == -1)?true:false;
            check2 = (field[b] == -1)?true:false;
            if(!check1){
                a_n.add(field[a]);
                a = field[a];
            }
            if(!check2){
                b_n.add(field[b]);
                b = field[b];
            }
        }

        int a_f = a_n.pop();
        int b_f = b_n.pop();
        if(a_f == b_f){
            while(a_f == b_f){
                if(a_n.size() == 0 || b_n.size() == 0){break;}
                a_f = a_n.pop();
                b_f = b_n.pop();
            }
            if(a_f != b_f){
                a_n.add(a_f);
                b_n.add(b_f);
            }
            System.out.println(a_n.size() + b_n.size());
        }
        else{
            System.out.println(-1);
        }
    }
}
