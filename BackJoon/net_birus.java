package BackJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class net_birus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int com_n = scan.nextInt();
        int n = scan.nextInt();
        int[][] field = new int[n][2];
        for(int i=0;i<n; i++){
            int start = scan.nextInt();
            int end = scan.nextInt();
            field[i][0] = start;
            field[i][1] = end;
        }
        Queue<Integer> find = new LinkedList();
        Queue<Integer> check = new LinkedList();
        find.add(1);
        check.add(1);
        int cnt = -1; //1은 포함이 안되니까
        while(!find.isEmpty()){
            int t = find.element();
            cnt++;
            find.remove();
            for(int i=0; i<n; i++){
                if(field[i][0] == t && !checking(check, field[i][1])){
                    find.add(field[i][1]);
                    check.add(field[i][1]);
                }
                else if(field[i][1] == t && !checking(check, field[i][0])){
                    find.add(field[i][0]);
                    check.add(field[i][0]);
                }
            }
        }
        System.out.println(cnt);
    }
    public static boolean checking(Queue<Integer> check, int a){
        for(int c : check){
            if(a == c) return true;
        }
        return false;
    }
}
