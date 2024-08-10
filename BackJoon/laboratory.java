package BackJoon;

import java.util.Scanner;
import java.util.Vector;

public class laboratory {
    public static int max;

    public static void main(String[] args) {
        max = 0;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] field = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int h = 0; h < m; h++) {
                field[i][h] = scan.nextInt();
            }
        }

        wall_make(0, deepCopy(field));
        System.out.println(max);
    }

    public static void wall_make(int wall_cnt, int[][] field) {
        if (wall_cnt == 3) {

            Vector<int[]> biruses = new Vector<>();
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[0].length; j++) {
                    if (field[i][j] == 2) {
                        biruses.add(new int[]{i, j});
                    }
                }
            }

            while (!biruses.isEmpty()) {
                int[] birus = biruses.get(0);
                biruses.remove(0);
                field[birus[0]][birus[1]] = 2;
                if (birus[0] + 1 < field.length && field[birus[0] + 1][birus[1]] == 0) {
                    biruses.add(new int[]{birus[0] + 1, birus[1]});
                }
                if (birus[0] - 1 >= 0 && field[birus[0] - 1][birus[1]] == 0) {
                    biruses.add(new int[]{birus[0] - 1, birus[1]});
                }
                if (birus[1] + 1 < field[0].length && field[birus[0]][birus[1] + 1] == 0) {
                    biruses.add(new int[]{birus[0], birus[1] + 1});
                }
                if (birus[1] - 1 >= 0 && field[birus[0]][birus[1] - 1] == 0) {
                    biruses.add(new int[]{birus[0], birus[1] - 1});
                }
            }

            int cnting = 0;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[0].length; j++) {
                    if (field[i][j] == 0) {
                        cnting++;
                    }
                }
            }
            max = Math.max(cnting, max);
            return;
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 0) {
                    field[i][j] = 1;
                    wall_make(wall_cnt + 1, deepCopy(field));
                    field[i][j] = 0;
                }
            }
        }
    }

    // 2차원 배열의 깊은 복사 메소드
    public static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
}
