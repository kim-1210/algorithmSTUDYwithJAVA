import java.util.Arrays;

public class quickSORT {
    public static void play_quickSORT(int[] arr) {
        System.out.println("After : " + Arrays.toString(arr));
    }
    public static void main(String[] args){
        int[] a = { 4, 6, 10, 8, 20, 5, 11, 78, 66 };
        System.out.println("before : " + Arrays.toString(a));
        play_quickSORT(a);
    }
}
