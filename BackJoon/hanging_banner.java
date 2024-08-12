package BackJoon;

import java.util.Scanner;
import java.util.Vector;

public class hanging_banner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int h = scan.nextInt();
        int w = scan.nextInt();

        int[][] field = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                field[i][j] = scan.nextInt();
            }
        }

        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (field[i][j] == 1) {
                    cnt++;
                    Vector<int[]> next = new Vector<>();
                    next.add(new int[] { i, j });
                    field[i][j] = 0;
                    while (!next.isEmpty()) {
                        int[] loca = next.get(0);
                        next.remove(0);
                        next.addAll(find_one(field, new int[] { loca[0], loca[1] }));
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    public static Vector<int[]> find_one(int[][] field, int[] cur) {
        Vector<int[]> new_add = new Vector<>();
        if (cur[0] + 1 < field.length && field[cur[0] + 1][cur[1]] == 1) {
            field[cur[0] + 1][cur[1]] = 0;
            new_add.add(new int[] { cur[0] + 1, cur[1] });
        }
        if (cur[0] - 1 >= 0 && field[cur[0] - 1][cur[1]] == 1) {
            field[cur[0] - 1][cur[1]] = 0;
            new_add.add(new int[] { cur[0] - 1, cur[1] });
        }
        if (cur[1] + 1 < field[0].length && field[cur[0]][cur[1] + 1] == 1) {
            field[cur[0]][cur[1] + 1] = 0;
            new_add.add(new int[] { cur[0], cur[1] + 1 });
        }
        if (cur[1] - 1 >= 0 && field[cur[0]][cur[1] - 1] == 1) {
            field[cur[0]][cur[1] - 1] = 0;
            new_add.add(new int[] { cur[0], cur[1] - 1 });
        }
        // 대각선
        if (cur[1] + 1 < field[0].length && cur[0] + 1 < field.length && field[cur[0] + 1][cur[1] + 1] == 1) {
            field[cur[0] + 1][cur[1] + 1] = 0;
            new_add.add(new int[] { cur[0] + 1, cur[1] + 1 });
        }
        if (cur[1] + 1 < field[0].length && cur[0] - 1 >= 0 && field[cur[0] - 1][cur[1] + 1] == 1) {
            field[cur[0] - 1][cur[1] + 1] = 0;
            new_add.add(new int[] { cur[0] - 1, cur[1] + 1 });
        }
        if (cur[1] - 1 >= 0 && cur[0] + 1 < field.length && field[cur[0] + 1][cur[1] - 1] == 1) {
            field[cur[0] + 1][cur[1] - 1] = 0;
            new_add.add(new int[] { cur[0] + 1, cur[1] - 1 });
        }
        if (cur[1] - 1 >= 0 && cur[0] - 1 >= 0 && field[cur[0] - 1][cur[1] - 1] == 1) {
            field[cur[0] - 1][cur[1] - 1] = 0;
            new_add.add(new int[] { cur[0] - 1, cur[1] - 1 });
        }
        return new_add;
    }
}
