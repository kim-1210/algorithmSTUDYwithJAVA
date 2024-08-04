package BackJoon;

import java.util.Scanner;

public class Re_Paint_Chess{
    public static char[][] chess_pan_A = new char[8][8];
    public static char[][] chess_pan_B = new char[8][8];

    public static int chess_pan_check(char[][] chess_pan, int start_w, int start_h){
        int A_w, A_b, B_w, B_b; //A판과 B판에 칠해야하는 개수
        A_b = A_w = B_b = B_w = 0;
        for(int h = start_h; h < start_h + 8; h++){
            for(int w = start_w; w < start_w + 8; w++){
                if(chess_pan_A[h - start_h][w - start_w] != chess_pan[h][w]){
                    if(chess_pan[h][w] == 'W'){ A_b += 1;}
                    else{A_w += 1;}
                }
                if(chess_pan_B[h - start_h][w - start_w] != chess_pan[h][w]){
                    if(chess_pan[h][w] == 'W'){ B_b += 1;}
                    else{B_w += 1;}
                }
            }
        }
        if(A_b + A_w < B_b + B_w){
            return A_b + A_w;
        }
        else{
            return B_b + B_w;
        }
    }

    public static void min_paint(char[][] chess_pan, int width, int height){
        int min = 999999999;
        for(int i = 0; i <= height - 8; i++){
            for(int u=0; u<= width - 8; u++){
                int w = 0;
                int k = chess_pan_check(chess_pan, u, i);
                if(k < min){
                    min = k;
                }
            }
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        int width, height;
        Scanner scan = new Scanner(System.in);
        height = scan.nextInt();
        width = scan.nextInt();
        char[][] chess_pan = new char[height][width];
        for (int i = 0; i < height; i++) {
            String r = scan.next();
            for (int h = 0; h < width; h++) {
                chess_pan[i][h] = r.charAt(h);
            }
        }
        char input = 'W';

        for(int i = 0; i<8; i++){ //처크할 판을 제작
            for(int h=0;h<8; h++){
                chess_pan_A[i][h] = input;
                if(input == 'W'){
                    input = chess_pan_B[i][h] = 'B';
                }
                else{
                    input = chess_pan_B[i][h] = 'W';
                }
                if(h == 7){
                    input = chess_pan_A[i][h];
                }
            }
        }
        scan.close();
        min_paint(chess_pan, width, height);
    }
} 
