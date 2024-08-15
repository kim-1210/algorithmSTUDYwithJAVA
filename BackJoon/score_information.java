package BackJoon;
//NO.5800

import java.util.Scanner;
import java.util.Vector;

public class score_information {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int classes = scan.nextInt();
        int[][] field = new int[classes][3];
        for(int i=0;i<classes; i++){
            int peo_n = scan.nextInt();
            int max = -1;
            Vector<Integer> sort = new Vector<>();
            for(int j=0;j<peo_n; j++){
                int score = scan.nextInt();
                if(sort.size() != 0){
                    int index = 0;
                    for(int h=0;h<sort.size(); h++){
                        if(score < sort.get(h)){
                            index++;
                        }
                        else{
                            break;
                        }
                    }
                    sort.insertElementAt(score, index);
                }
                else{
                    sort.add(score);
                }
            }
            for(int h=1;h<sort.size(); h++){
                max = (sort.get(h - 1) - sort.get(h)> max)?sort.get(h - 1) - sort.get(h):max; 
            }
            field[i][0] = sort.get(0);
            field[i][1] = sort.get(sort.size() - 1);
            field[i][2] = max;
        }
        for(int i=0;i<classes; i++){
            System.out.println("Class " + (i + 1));
            System.out.println("Max " + field[i][0] + ", Min " + field[i][1] + ", Largest gap " + field[i][2]);
        }
    }
}
