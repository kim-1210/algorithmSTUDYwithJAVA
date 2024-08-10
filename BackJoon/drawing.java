package BackJoon;

import java.util.Scanner;
import java.util.Vector;

public class drawing {
    public static int draw_cnt;
    public static int area;

    public static void main(String[] args) {
        area = draw_cnt = 0;
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] field = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                field[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (field[i][j] == 1) {
                    draw_cnt++;
                    Vector<int[]> location = new Vector<>();
                    location.add(new int[] { i, j });
                    field[i][j] = 0;
                    int cnt = 0;

                    while (!location.isEmpty()) {
                        int[] loca = location.get(0);
                        location.remove(0);
                        cnt++;
                        if (loca[0] + 1 < field.length && field[loca[0] + 1][loca[1]] == 1) {
                            field[loca[0] + 1][loca[1]] = 0;
                            location.add(new int[] { loca[0] + 1, loca[1] });
                        }
                        if (loca[0] - 1 >= 0 && field[loca[0] - 1][loca[1]] == 1) {
                            field[loca[0] - 1][loca[1]] = 0;
                            location.add(new int[] { loca[0] - 1, loca[1] });
                        }
                        if (loca[1] + 1 < field[0].length && field[loca[0]][loca[1] + 1] == 1) {
                            field[loca[0]][loca[1] + 1] = 0;
                            location.add(new int[] { loca[0], loca[1] + 1 });
                        }
                        if (loca[1] - 1 >= 0 && field[loca[0]][loca[1] - 1] == 1) {
                            field[loca[0]][loca[1] - 1] = 0;
                            location.add(new int[] { loca[0], loca[1] - 1 });
                        }
                    }
                    area = (cnt > area) ? cnt : area;
                }
            }
        }
        System.out.println(draw_cnt + "\n" + area);
    }
}
