import java.util.Arrays;
import java.util.Stack;

public class treeSORT {
    public static void play_treeSORT(int[] arr) {
        int[] new_arr = new int[70];
        new_arr[0] = -1;
        new_arr[1] = arr[0];
        for(int i=1; i< arr.length; i++){
            int check_num = 1;
            while (true) {
                if(new_arr[check_num] == 0){
                    new_arr[check_num] = arr[i];
                    break;
                }
                else if(new_arr[check_num] > arr[i]){
                    check_num *= 2;
                }
                else{
                    check_num *= 2;
                    check_num ++;
                }
            }
        }

        int[] result_arr = new int[arr.length];
        int index = 0;

        Stack<Integer> stack = new Stack<>();
        int current = 1;
        while (current < new_arr.length || !stack.isEmpty()) {
            while (current < new_arr.length && new_arr[current] != 0) {
                stack.push(current);
                current = current * 2;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                result_arr[index++] = new_arr[current];

                current = current * 2 + 1;
                if(index == arr.length){break;}
            }
        }

        System.out.println("After : " + Arrays.toString(result_arr));
    }
    public static void main(String[] args){
        int[] a = { 4, 6, 10, 8, 20, 5, 11, 78, 66, 1 };
        System.out.println("before : " + Arrays.toString(a));
        play_treeSORT(a);
    }
}
