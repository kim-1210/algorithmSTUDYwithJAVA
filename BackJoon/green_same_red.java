package BackJoon;

import java.util.Scanner;
import java.util.Vector;

public class green_same_red {
    public static int n_a = 0;
    public static int n_b = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        char[][] field = new char[n][n];
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String r = scan.nextLine();
            for (int j = 0; j < n; j++) {
                field[i][j] = r.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] != 'W' && field[i][j] != 'M') {
                    char k = field[i][j];
                    if (field[i][j] != 'B') {
                        field[i][j] = 'W';
                    } else {
                        field[i][j] = 'M';
                    }
                    Vector<int[]> locas = new Vector<>();
                    locas.add(new int[] { i, j });
                    person(field, locas, k);
                    n_a++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] != '.') {
                    char k = field[i][j];
                    field[i][j] = '.';
                    Vector<int[]> locas = new Vector<>();
                    locas.add(new int[] { i, j });
                    disabled_person(field, locas, k);
                    n_b++;
                }
            }
        }

        System.out.println(n_a + " " + n_b);
    }

    public static void disabled_person(char[][] field, Vector<int[]> sel, char objective) {
        while (!sel.isEmpty()) {
            int[] loca = sel.get(0);
            sel.remove(0);
            if (loca[0] + 1 < field.length && field[loca[0] + 1][loca[1]] == objective) {
                sel.add(new int[] { loca[0] + 1, loca[1] });
                field[loca[0] + 1][loca[1]] = '.';
            }
            if (loca[0] - 1 >= 0 && field[loca[0] - 1][loca[1]] == objective) {
                sel.add(new int[] { loca[0] - 1, loca[1] });
                field[loca[0] - 1][loca[1]] = '.';
            }
            if (loca[1] + 1 < field[0].length && field[loca[0]][loca[1] + 1] == objective) {
                sel.add(new int[] { loca[0], loca[1] + 1 });
                field[loca[0]][loca[1] + 1] = '.';
            }
            if (loca[1] - 1 >= 0 && field[loca[0]][loca[1] - 1] == objective) {
                sel.add(new int[] { loca[0], loca[1] - 1 });
                field[loca[0]][loca[1] - 1] = '.';
            }
        }
    }

    public static void person(char[][] field, Vector<int[]> sel, char objective) {
        while (!sel.isEmpty()) {
            int[] loca = sel.get(0);
            sel.remove(0);
            if (loca[0] + 1 < field.length && field[loca[0] + 1][loca[1]] == objective) {
                sel.add(new int[] { loca[0] + 1, loca[1] });
                if (objective != 'B') {
                    field[loca[0] + 1][loca[1]] = 'W';
                } else {
                    field[loca[0] + 1][loca[1]] = 'M';
                }
            }
            if (loca[0] - 1 >= 0 && field[loca[0] - 1][loca[1]] == objective) {
                sel.add(new int[] { loca[0] - 1, loca[1] });
                if (objective != 'B') {
                    field[loca[0] - 1][loca[1]] = 'W';
                } else {
                    field[loca[0] - 1][loca[1]] = 'M';
                }
            }
            if (loca[1] + 1 < field[0].length && field[loca[0]][loca[1] + 1] == objective) {
                sel.add(new int[] { loca[0], loca[1] + 1 });
                if (objective != 'B') {
                    field[loca[0]][loca[1] + 1] = 'W';
                } else {
                    field[loca[0]][loca[1] + 1] = 'M';
                }
            }
            if (loca[1] - 1 >= 0 && field[loca[0]][loca[1] - 1] == objective) {
                sel.add(new int[] { loca[0], loca[1] - 1 });
                if (objective != 'B') {
                    field[loca[0]][loca[1] - 1] = 'W';
                } else {
                    field[loca[0]][loca[1] - 1] = 'M';
                }
            }
        }
    }
}
