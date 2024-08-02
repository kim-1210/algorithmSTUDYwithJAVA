import java.util.*;

public class selectSORT {
    public static void play_selectSORT(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = 99999;
            int arr_num = -1;
            for (int h = i; h < arr.length; h++) {
                if (arr[h] < min) {
                    min = arr[h];
                    arr_num = h;
                }
            }
            if (arr_num != -1) {
                int temp = arr[i];
                arr[i] = min;
                arr[arr_num] = temp;
            }
        }
        System.out.println("After : " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] a = { 4, 6, 10, 8, 20, 5, 11, 78, 66 };
        System.out.println("before : " + Arrays.toString(a));
        play_selectSORT(a);
    }
}