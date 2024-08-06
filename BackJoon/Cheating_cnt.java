package BackJoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cheating_cnt {
    public static int max;
    public static int map_find(Map<Integer, Integer> can_sit, int cnt){
        if(can_sit.isEmpty()){
            return cnt;
        }
        Integer[] keys = can_sit.keySet().toArray(new Integer[0]);
        int func_max = 0;
        for(int i=0; i<keys.length; i++){
            int num = keys[i];
            int r = can_sit.get(num);

            Map<Integer, Integer> temp = new HashMap<>();
            temp.putAll(can_sit);

            temp.remove(num);
            if(temp.containsKey(num - 1)){temp.remove(num - 1);}
            if(temp.containsKey(num + 1)){temp.remove(num + 1);}
            int return_num = 0;
            return_num = map_find(temp, cnt + r);
            if(return_num > func_max){
                func_max = return_num;
            }
        }
        return func_max;
    }

    public static void cheating_max(char[][] field, int h, int w) {
        Map<Integer, Integer> col_cnt = new  HashMap<>();
        for(int i=0; i<w; i++){
            int cnt = 0;
            for(int j = 0; j < h; j++){
                if(field[j][i] == '.'){
                    cnt += 1;
                }
            }
            col_cnt.put(i, cnt);
        }
        max = map_find(col_cnt, 0);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test_case_cnt = scan.nextInt();
        char[][][] field = new char[test_case_cnt][][];
        for(int i=0; i < test_case_cnt; i++){
            int h = scan.nextInt();
            int w = scan.nextInt();
            field[i] = new char[h][w];

            for(int g = 0; g < h; g++){
                String r = scan.next();
                for (int f = 0; f < w; f++) {
                    field[i][g][f] = r.charAt(f);
                }
            }
            max = 0;
            cheating_max(field[i], field[i].length, field[i][0].length);
            System.out.println(max);
        }
        scan.close();
    }
}
