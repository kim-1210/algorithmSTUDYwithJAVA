import java.util.Arrays;

public class bubbleSORT {
    public static void play_bubbleSORT(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = i;
            while (num < arr.length - 1) {
                if(arr[num] > arr[num + 1]){
                    int temp = arr[num];
                    arr[num] = arr[num + 1];
                    arr[num + 1] = temp;
                    num++;
                    i = -1; //for문을 돌기 때문에 0애서 1을 빼줘야한다
                }
                else{
                    break;
                }
            }
        }
        System.out.println("After : " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] a = { 4, 6, 10, 8, 20, 5, 11, 78, 66, 1 };
        System.out.println("before : " + Arrays.toString(a));
        play_bubbleSORT(a);
    }
}
