import java.util.Arrays;

public class mergeSORT {
    public static void play_mergeSORT(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            while (j >= 0 && tmp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
        System.out.println("After : " + Arrays.toString(arr));
    }
    public static void main(String[] args){
        int[] a = { 4, 6, 10, 8, 20, 5, 11, 78, 66, 1 };
        System.out.println("before : " + Arrays.toString(a));
        play_mergeSORT(a);
    }
}
