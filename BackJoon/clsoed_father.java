package BackJoon;

import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class clsoed_father {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test_case_n = scan.nextInt();
        int[] answer = new int[test_case_n];

        for(int i=0;i<test_case_n; i++){
            int n = scan.nextInt();
            int[] field = new int[n + 1];
            for(int j=0;j<n - 1; j++){
                int r = scan.nextInt();
                int k = scan.nextInt();
                field[k] = r; //r은 k의 부모다.
            }

            int A = scan.nextInt();
            int B = scan.nextInt();
            Vector<Integer> A_father = new Vector<>();
            Vector<Integer> B_father = new Vector<>();
            A_father.add(A);
            B_father.add(B);

            while(A != 0){
                if(field[A] == 0) break;
                A_father.add(field[A]);
                A = field[A];
            }

            while(B != 0){
                if(field[B] == 0) break;
                B_father.add(field[B]);
                B = field[B]; 
            }

            for(int j=0; j<A_father.size(); j++){
                boolean check = false;
                for(int h=0;h<B_father.size(); h++){
                    if(Objects.equals(A_father.get(j), B_father.get(h))){
                        //System.out.println(B_father.get(h));
                        answer[i] = B_father.get(h);
                        check = true;
                        break;
                    }
                }
                if(check){break;}
            }

        }
        for(int i=0;i<test_case_n; i++){
            System.out.println(answer[i]);
        }
    }
}
