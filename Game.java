import javax.swing.*;
import javax.swing.text.StringContent;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by Salih on 05.07.2014.
 */
public class Game {
    private final int WHITE = 1;
    private final int BLACK = 0;
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public static Game logicalGame= new Game();
    private Piece[][] ChessBoard = new Piece[8][8];
    Piece White_Rook = new Rook(WHITE);
    Piece Black_Rook  = new Rook(BLACK);
    Piece White_Knight = new Knight(WHITE);
    Piece Black_Knight = new Knight(BLACK);
    Piece White_Bishop = new Bishop(WHITE);
    Piece Black_Bishop = new Bishop(BLACK);
    Piece White_Queen = new Queen(WHITE);
    Piece Black_Queen = new Queen(BLACK);
    Piece White_King = new King(WHITE);
    Piece Black_King = new King(BLACK);
    Piece White_Pown = new Pown(WHITE);
    Piece Black_Pown = new Pown(BLACK);

    public Game ( ) {
        ChessBoard[0][0] = White_Rook;
        ChessBoard[0][1] = White_Knight;
        ChessBoard[0][2] = White_Bishop;
        ChessBoard[0][3] = White_Queen;
        ChessBoard[0][4] = White_King;
        ChessBoard[0][5] = White_Bishop;
        ChessBoard[0][6] = White_Knight;
        ChessBoard[0][7] = White_Rook;
        for (int i = 0; i < 8; i++) {
            ChessBoard[1][i] = White_Pown;
            ChessBoard[6][i] = Black_Pown;
        }
        ChessBoard[7][0] = Black_Rook;
        ChessBoard[7][1] = Black_Knight;
        ChessBoard[7][2] = Black_Bishop;
        ChessBoard[7][3] = Black_Queen;
        ChessBoard[7][4] = Black_King;
        ChessBoard[7][5] = Black_Bishop;
        ChessBoard[7][6] = Black_Knight;
        ChessBoard[7][7] = Black_Rook;

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                ChessBoard[i][j] = null;
            }
        }
    }

    public Piece get(int x, int y) {
        return ChessBoard[x][y];
    }

    public void set(int x, int y, Piece p) {

        ChessBoard[x][y] = p;
    }

    public void movePiece(int startx,int starty,int endx,int endy,int colour){

        Piece p = logicalGame.get(startx,starty);

       if(logicalGame.get(startx,starty)!=null && startx<8 && startx>=0 && starty<8 && starty>=0 && endx<8 && endx>=0 && endy<8 && endx>=0) {
           if (p.checkMove(startx, starty, endx, endy) && p.getColor() == colour) {
               logicalGame.set(endx, endy, p);
               logicalGame.set(startx, starty, null);
           }
       }

    }
    public boolean checkmate(){


        return false;
    }


}
