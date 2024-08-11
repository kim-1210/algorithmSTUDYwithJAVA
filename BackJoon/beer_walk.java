package BackJoon;

import java.util.Scanner;
import java.util.Vector;

public class beer_walk {
    public static boolean check = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test_case_n = scan.nextInt();
        String[] answer = new String[test_case_n];

        for (int i = 0; i < test_case_n; i++) {
            check = false;
            int n = scan.nextInt();
            int[][] locaes = new int[n + 2][2];
            for (int j = 0; j < n + 2; j++) {
                locaes[j][0] = scan.nextInt();
                locaes[j][1] = scan.nextInt();
            }

            double beer = 20.0;
            Vector<int[]> next = new Vector<>();
            Vector<Integer> beer_n = new Vector<>();
            beer_n.add(20);
            next.add(locaes[0]);
            enter(locaes, next, 0, beer_n);
            answer[i] = (check) ? "happy" : "sad";
        }

        for (int i = 0; i < test_case_n; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void enter(int[][] locaes, Vector<int[]> next, int cnt, Vector<Integer> beer_n) {
        if (cnt >= locaes.length || check == true)
            return;

        Vector<int[]> nexting = new Vector<>();
        Vector<Integer> beering = new Vector<>();
        while (!next.isEmpty()) {
            int[] loca = next.get(next.size() - 1);
            int beer = beer_n.get(beer_n.size() - 1);
            next.remove(next.size() - 1);
            beer_n.get(beer_n.size() - 1);
            //System.out.println("cur => " + loca[0] + " , " + loca[1]);

            if (loca[0] == locaes[locaes.length - 1][0] && loca[1] == locaes[locaes.length - 1][1]) {
                check = true;
                return;
            }

            for (int i = 0; i < locaes.length; i++) {
                int range = Math.abs(Math.abs(locaes[i][0]) - Math.abs(loca[0])) + Math.abs(Math.abs(locaes[i][1]) - Math.abs(loca[1]));
                if (range != 0) {
                    range /= 50;
                    //System.out.println(range + " : " + beer);
                    if (beer - range >= 0) {
                        //System.out.println(locaes[i][0] + " , " + locaes[i][1]);
                        nexting.add(locaes[i]);
                        beering.add(20);
                    }
                }
            }
            enter(locaes, nexting, cnt + 1, beering);
            nexting.clear();
            beering.clear();
        }
    }
}

// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Scanner;

// public class BeerWalk {
//     public static void main(String[] args) {
//         Scanner scan = new Scanner(System.in);
//         int testCaseCount = scan.nextInt();
//         String[] answer = new String[testCaseCount];

//         for (int i = 0; i < testCaseCount; i++) {
//             int n = scan.nextInt();
//             int[][] locations = new int[n + 2][2];

//             for (int j = 0; j < n + 2; j++) {
//                 locations[j][0] = scan.nextInt();
//                 locations[j][1] = scan.nextInt();
//             }

//             answer[i] = bfs(locations) ? "happy" : "sad";
//         }

//         for (String ans : answer) {
//             System.out.println(ans);
//         }
//     }

//     public static boolean bfs(int[][] locations) {
//         int n = locations.length;
//         boolean[] visited = new boolean[n];
//         Queue<Integer> queue = new LinkedList<>();

//         // 상근이의 집(0번째 위치)에서 시작
//         queue.add(0);
//         visited[0] = true;

//         while (!queue.isEmpty()) {
//             int current = queue.poll();

//             // 페스티벌에 도착한 경우
//             if (current == n - 1) {
//                 return true;
//             }

//             for (int i = 0; i < n; i++) {
//                 if (!visited[i]) {
//                     int distance = Math.abs(locations[current][0] - locations[i][0]) + Math.abs(locations[current][1] - locations[i][1]);

//                     // 맥주 20병(1000m)으로 갈 수 있는 거리가 있는지 확인
//                     if (distance <= 1000) {
//                         queue.add(i);
//                         visited[i] = true;
//                     }
//                 }
//             }
//         }

//         return false; // 페스티벌에 도달할 수 없는 경우
//     }
// }
