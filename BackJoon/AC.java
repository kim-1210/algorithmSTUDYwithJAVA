package BackJoon;
//No.5430

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class AC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test_case_n = scan.nextInt();
        scan.nextLine();
        
        for (int i = 0; i < test_case_n; i++) {
            String r = scan.nextLine();
            int n = scan.nextInt();
            scan.nextLine();
            String nums = scan.nextLine();
            
            nums = nums.replaceAll("\\[|\\]|\\s", "");
            String[] numes = nums.split(",");
            
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(numes[j]));
            }
            
            boolean reverse = false;
            boolean error = false;
            
            for (int j = 0; j < r.length(); j++) {
                if (r.charAt(j) == 'R') {
                    reverse = !reverse;
                } else if (r.charAt(j) == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    } else {
                        if (reverse) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    }
                }
            }
            
            if (error) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (reverse) {
                        sb.append(deque.removeLast());
                    } else {
                        sb.append(deque.removeFirst());
                    }
                    if (!deque.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
        }
    }
}
