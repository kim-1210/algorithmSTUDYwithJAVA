package BackJoon;

import java.util.Scanner;
import java.util.Vector;


public class BlackJack {
    public static int standard_num;
    public static int minus_num;
    public static int answer;
    public static void blackjack(Vector<Integer> arr, int cur_sum, int cur_count){
        if(standard_num >= cur_sum && cur_count == 4){
            int check = standard_num - cur_sum;
            if(check < minus_num){
                answer = cur_sum;
                minus_num = check;
            }
            return;
        }
        else if(standard_num >= cur_sum && cur_count < 4){
            for(int h = 0; h < arr.size(); h++){
                int temp = arr.get(h);
                arr.remove(h);
                blackjack(arr, cur_sum + temp, cur_count + 1);
                arr.insertElementAt(temp, h);
            }
        }
        else{
            return;
        }
    }

    public static void main(String[] args) {
        minus_num = 9999999;
        answer = 0;
        int card_num;
        Scanner scan = new Scanner(System.in);
        card_num = scan.nextInt();
        standard_num = scan.nextInt();
        Vector<Integer> arr = new Vector<>();
        for(int i=0;i<card_num; i++){
            int temp = scan.nextInt();
            arr.add(temp);
        }
        blackjack(arr, 0, 1);
        System.out.println(answer);
    }
}
