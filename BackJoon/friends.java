package BackJoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class friends {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.nextLine();

        boolean[][] friends = new boolean[num][num];

        for (int i = 0; i < num; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < num; j++) {
                friends[i][j] = line.charAt(j) == 'Y';
            }
        }

        int max = 0;

        for (int i = 0; i < num; i++) {
            Set<Integer> twoFriends = new HashSet<>();

            for (int j = 0; j < num; j++) {
                if (friends[i][j]) {
                    twoFriends.add(j);
                    for (int k = 0; k < num; k++) {
                        if (friends[j][k] && i != k) {
                            twoFriends.add(k);
                        }
                    }
                }
            }

            if (twoFriends.size() > max) {
                max = twoFriends.size();
            }
        }

        System.out.println(max);
    }
}
