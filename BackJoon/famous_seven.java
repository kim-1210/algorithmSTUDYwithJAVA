package BackJoon;
//작동 X
import java.util.Scanner;
import java.util.Vector;

public class famous_seven {
    public static int result;
    public static void main(String[] args) {
        result = 0;
        Scanner scan = new Scanner(System.in);
        char[][] field = new char[5][5];
        Vector<int[]> S_loca = new Vector<>();

        for(int i=0;i<5;i++){
            String r = scan.nextLine();
            for(int j=0;j<5; j++){
                field[i][j] = r.charAt(j);
                if(field[i][j] == 'S'){
                    S_loca.add(new int[]{i,j});
                }
            }
        }

        start(field, S_loca);
        System.out.println(result);
    }
    public static void set(int cnt, char[][] field, Vector<int[]> select){
        if(cnt == 7){
            int k = 0;
            for(int[] loca : select){
                k = (field[loca[0]][loca[1]] == 'S')? k + 1 : k;
            }
            if(k >= 4) result++;
            return;
        }
        for(int[] loca : select){
            if(loca[0] + 1 < field.length){
                if(!check(select, new int[]{loca[0] + 1, loca[1]})){
                    select.add(new int[]{loca[0] + 1, loca[1]});
                    set(cnt + 1, field, select);
                    select.remove(select.size() - 1);
                }
            }
            if(loca[0] - 1 >= 0){
                if(!check(select, new int[]{loca[0] - 1, loca[1]})){
                    select.add(new int[]{loca[0] - 1, loca[1]});
                    set(cnt + 1, field, select);
                    select.remove(select.size() - 1);
                }
            }
            if(loca[1] + 1 < field[0].length){
                if(!check(select, new int[]{loca[0], loca[1] + 1})){
                    select.add(new int[]{loca[0], loca[1] + 1});
                    set(cnt + 1, field, select);
                    select.remove(select.size() - 1);
                }
            }
            if(loca[1] - 1 >= 0){
                if(!check(select, new int[]{loca[0], loca[1] - 1})){
                    select.add(new int[]{loca[0], loca[1] - 1});
                    set(cnt + 1, field, select);
                    select.remove(select.size() - 1);
                }
            }
        }
    }

    public static void start(char[][] field, Vector<int[]> S_loca){        
        for(int[] loca : S_loca){
            Vector<int[]> sel = new Vector<>();
            sel.add(loca);
            set(1, field, sel);
        }
    }

    public static boolean check(Vector<int[]> pre_sel, int[] cur_sel){
        for(int[] sel : pre_sel){
            if(sel[0] == cur_sel[0] && sel[1] == cur_sel[1]) return true;
        }
        return false;
    }
}
