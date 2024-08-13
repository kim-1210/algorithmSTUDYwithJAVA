package BackJoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class apartment_num {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] field = new int[n][n];
        scan.nextLine();
        for(int i=0;i<n; i++){
            String r = scan.nextLine();
            for(int j=0;j<n; j++){
                field[i][j] = (int)r.charAt(j) - '0';
            }
        }
        List<Integer> apartment_n = new ArrayList<>();
        for(int i=0;i<n; i++){
            for(int j=0;j<n; j++){
                if(field[i][j] == 1){
                    Queue<int[]> next = new LinkedList();
                    next.add(new int[]{i, j});
                    field[i][j] = 0;
                    int per_n = 1;
                    while(!next.isEmpty()){
                        int[] loca = next.poll();
                        if(loca[0] > 0 && field[loca[0] - 1][loca[1]] == 1){
                            per_n++;
                            field[loca[0] - 1][loca[1]] = 0;
                            next.add(new int[]{loca[0] - 1, loca[1]});
                        }
                        if(loca[0] < n - 1 && field[loca[0] + 1][loca[1]] == 1){
                            per_n++;
                            field[loca[0] + 1][loca[1]] = 0;
                            next.add(new int[]{loca[0] + 1, loca[1]});
                        }
                        if(loca[1] > 0 && field[loca[0]][loca[1] - 1] == 1){
                            per_n++;
                            field[loca[0]][loca[1] - 1] = 0;
                            next.add(new int[]{loca[0], loca[1] - 1});
                        }
                        if(loca[1] < n - 1 && field[loca[0]][loca[1] + 1] == 1){
                            per_n++;
                            field[loca[0]][loca[1] + 1] = 0;
                            next.add(new int[]{loca[0], loca[1] + 1});
                        }
                    }
                    apartment_n.add(per_n);
                }
            }
        }
        apartment_n.sort(null);
        System.out.println(apartment_n.size());
        for(int i : apartment_n){
            System.out.println(i);
        }
    }
}
