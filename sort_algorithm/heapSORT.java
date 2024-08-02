import java.util.Arrays;

public class heapSORT {
    public static void play_heapSORT(int[] arr) {
        int[] new_arr = new int[arr.length + 1];
        new_arr[0] = -1;
        for (int i = 0; i < arr.length; i++) { // 삽입
            new_arr[i + 1] = arr[i];
            int insert_num = i + 1;
            while (insert_num >= 2) {
                int temp_num = insert_num;
                if (insert_num % 2 == 1) { // 짝수면?
                    temp_num = insert_num - 1;
                }
                int r = temp_num / 2;
                if (new_arr[r] > new_arr[insert_num]) {
                    int temp = new_arr[r];
                    new_arr[r] = new_arr[insert_num];
                    new_arr[insert_num] = temp;
                    insert_num = r;
                } else {
                    break;
                }
            }
        }
        System.out.println("After 1 : " + Arrays.toString(new_arr));

        int[] new_arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) { // 빼기
            new_arr2[i] = new_arr[1];
            int num = (new_arr.length - 1) - i;
            new_arr[1] = new_arr[num];
            new_arr[num] = 9999999;
            int next_index = 1;
            while (next_index < new_arr.length) {
                if (next_index * 2 + 1 < new_arr.length) {
                    if (new_arr[next_index * 2] > new_arr[next_index * 2 + 1]) {
                        if (new_arr[next_index] > new_arr[next_index * 2 + 1]) {
                            int temp = new_arr[next_index];
                            new_arr[next_index] = new_arr[next_index * 2 + 1];
                            new_arr[next_index * 2 + 1] = temp;
                            next_index = next_index * 2 + 1;
                        } else {
                            break;
                        }
                    } else {
                        if (new_arr[next_index] > new_arr[next_index * 2]) {
                            int temp = new_arr[next_index];
                            new_arr[next_index] = new_arr[next_index * 2];
                            new_arr[next_index * 2] = temp;
                            next_index = next_index * 2;
                        } else {
                            break;
                        }
                    }
                } else if (next_index * 2 < new_arr.length) {
                    if (new_arr[next_index] > new_arr[next_index * 2]) {
                        int temp = new_arr[next_index];
                        new_arr[next_index] = new_arr[next_index * 2];
                        new_arr[next_index * 2] = temp;
                        next_index = next_index * 2;
                    }
                    else{
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println("After 2 : " + Arrays.toString(new_arr2));
    }

    public static void main(String[] args) {
        int[] a = { 4, 6, 10, 8, 20, 5, 11, 78, 66, 1 };
        System.out.println("before : " + Arrays.toString(a));
        play_heapSORT(a);
    }
}