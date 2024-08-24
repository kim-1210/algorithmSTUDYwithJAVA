package nhn_coding_test;

import java.util.Arrays;

public class Exam1 {
    public static void main(String[] args) {
        int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] b = a.clone();
        int[] c = new int[a.length];
        int[] d = new int[a.length];
        // 1-1 서로 다른 배열로 복사(5)
        System.out.println("a : " + Arrays.toString(a));
        System.out.println("b : " + Arrays.toString(b));
        System.out.println("c : " + Arrays.toString(c));

        System.out.println("d : " + Arrays.toString(d));
        System.out.println("System.arraycopy(a, 1, c, 3, 5)");
        arraycopy(a, 1, c, 3, 5);
        System.out.println("c : " + Arrays.toString(c));
        System.out.println("arraycopy(b, 1, d, 3, 5)");
        System.arraycopy(b, 1, d, 3, 5);
        System.out.println("d : " + Arrays.toString(d));
        System.out.println("Arrays.equals(c, d) = " + Arrays.equals(c, d));
        // 1-2 같은 배열로 복사(5)
        System.out.println("System.arraycopy(a, 1, a, 3, 5)");
        System.arraycopy(a, 1, a, 3, 5);
        System.out.println("arraycopy(b, 1, b, 3, 5)");
        arraycopy(b, 1, b, 3, 5);
        System.out.println("Arrays.equals(a, b) = " + Arrays.equals(a, b));
        System.out.println("System.arraycopy(a, 4, a, 2, 5)");
        System.arraycopy(a, 4, a, 2, 5);
        System.out.println("arraycopy(b, 4, b, 2, 5)");
        arraycopy(b, 4, b, 2, 5);
        System.out.println("Arrays.equals(a, b) = " + Arrays.equals(a, b));
    }

    public static void arraycopy(int[] src, int srcPos, int[] dest, int destPos, int length) {
        try {
            int[] k = src.clone();
            for (int i = destPos; i < destPos + length; i++) {
                dest[i] = k[srcPos++];
            }
        }catch(ArrayStoreException e){
            System.out.println("같지 않은 배열의 타입");
        }catch(IndexOutOfBoundsException e){
            System.out.println("설정 값이 가지고 있는 배열의 길이 초과");
        }catch(NullPointerException e){
            System.out.println("넣을 값이 없음");
        }catch(Exception e){
            System.out.println("기타 오류 :\n" + e.getMessage());
        }
    }
}