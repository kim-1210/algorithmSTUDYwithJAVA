package BackJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class tomato {
    public static int cnt = 0;
    public static Queue<Integer> per_cnt;
    public static void main(String[] args) {
        per_cnt = new LinkedList();
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt(), n = scan.nextInt(), h = scan.nextInt();
        int[][][] field = new int[h][n][m];
        Queue<int[]> next = new LinkedList();
        
        for(int i=0;i<h; i++){
            for(int j=0;j<n; j++){
                for(int g=0;g<m; g++){
                    field[i][j][g] = scan.nextInt();
                    if(field[i][j][g] == 1){
                        next.add(new int[]{i,j,g});
                        per_cnt.add(0);
                        field[i][j][g] = 2;
                    }
                }
            }
        }

        while (!next.isEmpty()) {
            int[] loca = next.element();
            int cur_cnt = per_cnt.element();
            next.remove();
            per_cnt.remove();
            next.addAll(birus_tomato(field, loca, cur_cnt));
            cnt = (cur_cnt > cnt)? cur_cnt : cnt;
        }

        for(int i=0;i<h; i++){
            for(int j=0;j<n; j++){
                for(int g=0;g<m; g++){
                    if(field[i][j][g] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
    public static Queue<int[]> birus_tomato(int[][][] field, int[] cur, int temp_cnt){
        Queue<int[]> nexting = new LinkedList<>();
        temp_cnt++;
        if(cur[0] + 1 < field.length && field[cur[0] + 1][cur[1]][cur[2]] == 0){
            field[cur[0] + 1][cur[1]][cur[2]] = 2;
            nexting.add(new int[]{cur[0] + 1, cur[1], cur[2]});
            per_cnt.add(temp_cnt);
        }
        if(cur[0] - 1 >= 0 && field[cur[0] - 1][cur[1]][cur[2]] == 0){
            field[cur[0] - 1][cur[1]][cur[2]] = 2;
            nexting.add(new int[]{cur[0] - 1, cur[1], cur[2]});
            per_cnt.add(temp_cnt);
        }
        if(cur[1] + 1 < field[0].length && field[cur[0]][cur[1] + 1][cur[2]] == 0){
            field[cur[0]][cur[1] + 1][cur[2]] = 2;
            nexting.add(new int[]{cur[0], cur[1] + 1, cur[2]});
            per_cnt.add(temp_cnt);
        }
        if(cur[1] - 1 >= 0 && field[cur[0]][cur[1] - 1][cur[2]] == 0){
            field[cur[0]][cur[1] - 1][cur[2]] = 2;
            nexting.add(new int[]{cur[0], cur[1] - 1, cur[2]});
            per_cnt.add(temp_cnt);
        }
        if(cur[2] + 1 < field[0][0].length && field[cur[0]][cur[1]][cur[2] + 1] == 0){
            field[cur[0]][cur[1]][cur[2] + 1] = 2;
            nexting.add(new int[]{cur[0], cur[1], cur[2] + 1});
            per_cnt.add(temp_cnt);
        }
        if(cur[2] - 1 >= 0 && field[cur[0]][cur[1]][cur[2] - 1] == 0){
            field[cur[0]][cur[1]][cur[2] - 1] = 2;
            nexting.add(new int[]{cur[0], cur[1], cur[2] - 1});
            per_cnt.add(temp_cnt);
        }
        return nexting;
    }
}
