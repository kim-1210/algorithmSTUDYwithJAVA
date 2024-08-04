package BackJoon;

import java.util.Scanner;
import java.util.Vector;

public class SoTInside {
    public static void main(String[] args) {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String N = br.readLine();
        
        // char[] digits = N.toCharArray();
        
        // Arrays.sort(digits);
        
        // for (int i = digits.length - 1; i >= 0; i--) {
        //     bw.write(digits[i]);
        // }
        // bw.newLine();
        
        // bw.flush();
        // bw.close();
        // br.close();
        
        String input_data;
        Scanner scan = new Scanner(System.in);
        input_data = scan.next();
        Vector<Integer> to_data = new Vector<>();
        for(int i=0;i<input_data.length(); i++){
            to_data.add(Character.getNumericValue(input_data.charAt(i)));
        }
        String result = "";
        for(int i = 9; i >= 0; i--){
            int index = to_data.indexOf(i);
            if(index != -1){
                result += to_data.get(index);
                to_data.remove(index);
                i = i + 1;
            }
        }
        System.out.println(result);
    }
}
