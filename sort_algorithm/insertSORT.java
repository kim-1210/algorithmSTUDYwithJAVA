import java.util.Arrays;

public class insertSORT {
    public static void play_insertSORT(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int num = i;
            while (num > 0) {
                if(arr[num] < arr[num - 1]){
                    int temp = arr[num];
                    arr[num] = arr[num - 1];
                    arr[num - 1] = temp;
                    num--;
                }
                else{
                    break;
                }
            }
        }
        System.out.println("After : " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] a = { 4, 6, 10, 8, 20, 5, 11, 78, 66 };
        System.out.println("before : " + Arrays.toString(a));
        play_insertSORT(a);
    }
}
