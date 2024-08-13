//Fail!!@!

// package BackJoon;

// import java.util.Arrays;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Scanner;
// import java.util.Vector;

// public class green_cloth_jelda {
//     public static void main(String[] args) {
//         Scanner scan = new Scanner(System.in);
//         int cnt = 0;
//         Vector<Integer> answer = new Vector<>();
//         while (true) {
//             int n = scan.nextInt();
//             if (n == 0)
//                 break;
//             cnt++;
//             int[][] field = new int[n][n];
//             for (int i = 0; i < n; i++) {
//                 for (int j = 0; j < n; j++) {
//                     field[i][j] = scan.nextInt();
//                 }
//             }
//             int[][] result_field = new int[n][n];
//             for (int i = 0; i < n; i++)
//                 Arrays.fill(result_field[i], 100000000);
//             result_field[0][0] = field[0][0];
//             Queue<int[]> next = new LinkedList<>();
//             next.add(new int[] { 0, 0 });
//             while (!next.isEmpty()) {
//                 int[] loca = next.element();
//                 next.remove();
//                 if (loca[0] == n - 1 && loca[1] == n - 1) {
//                     break;
//                 }
//                 int a = loca[0], b = loca[1], min = 99999999;
//                 if (loca[0] > 0) {
//                     result_field[loca[0] - 1][loca[1]] = Math.min(
//                             result_field[loca[0]][loca[1]] + field[loca[0] - 1][loca[1]],
//                             result_field[loca[0] - 1][loca[1]]);

//                     if (min > result_field[loca[0] - 1][loca[1]]) {
//                         min = result_field[loca[0] - 1][loca[1]];
//                         a = loca[0] - 1;
//                         b = loca[1];
//                     }
//                 }
//                 if (loca[0] < n - 1) {
//                     result_field[loca[0] + 1][loca[1]] = Math.min(
//                             result_field[loca[0]][loca[1]] + field[loca[0] + 1][loca[1]],
//                             result_field[loca[0] + 1][loca[1]]);

//                     if (min > result_field[loca[0] + 1][loca[1]]) {
//                         min = result_field[loca[0] + 1][loca[1]];
//                         a = loca[0] + 1;
//                         b = loca[1];
//                     }
//                 }
//                 if (loca[1] > 0) {
//                     result_field[loca[0]][loca[1] - 1] = Math.min(
//                             result_field[loca[0]][loca[1]] + field[loca[0]][loca[1] - 1],
//                             result_field[loca[0]][loca[1] - 1]);
//                     if (min > result_field[loca[0]][loca[1] - 1]) {
//                         min = result_field[loca[0]][loca[1] - 1];
//                         a = loca[0];
//                         b = loca[1] - 1;
//                     }
//                 }
//                 if (loca[1] < n - 1) {
//                     result_field[loca[0]][loca[1] + 1] = Math.min(
//                             result_field[loca[0]][loca[1]] + field[loca[0]][loca[1] + 1],
//                             result_field[loca[0]][loca[1] + 1]);
//                     if (min > result_field[loca[0]][loca[1] + 1]) {
//                         min = result_field[loca[0]][loca[1] + 1];
//                         a = loca[0];
//                         b = loca[1] + 1;
//                     }
//                 }
//                 if(min != 9999999){
//                     System.out.println(a + " , " + b);
//                     next.add(new int[]{a, b});
//                 }
//             }
//             answer.add(result_field[n - 1][n - 1]);
//         }
//         for (int i = 0; i < cnt; i++) {
//             System.out.println("Problem " + cnt + ": " + answer.get(i));
//         }
//     }
// }
