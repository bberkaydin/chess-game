import java.util.Scanner;
import javax.swing.*;
/**
 * Created by berk on 18.07.2014.
 */
public class RunGame {
    public static void main(String[]args){
        Scanner k = new Scanner(System.in);
        Clock clock = new Clock();
        int mode = k.nextInt();
        int whosturn = 1;
        Board board = new Board();

        if(mode==1) {
            while (Game.logicalGame.checkmate() == false) {

                String place = k.next();
                String sx = place.substring(0,1);
                int sy = Integer.parseInt(place.substring(1,2));
                String ex =place.substring(2,3);
                int ey = Integer.parseInt(place.substring(3,4));
                int a=0,b=0;
                if(sx.equalsIgnoreCase("a"))
                    a = 0;
                else if(sx.equalsIgnoreCase("b"))
                    a = 1;
                else if(sx.equalsIgnoreCase("c"))
                    a = 2;
                else if(sx.equalsIgnoreCase("d"))
                    a = 3;
                else if(sx.equalsIgnoreCase("e"))
                    a = 4;
                else if(sx.equalsIgnoreCase("f"))
                    a = 5;
                else if(sx.equalsIgnoreCase("g"))
                    a = 6;
                else if(sx.equalsIgnoreCase("h"))
                    a = 7;

                if(ex.equalsIgnoreCase("a"))
                    b = 0;
                else if(ex.equalsIgnoreCase("b"))
                    b = 1;
                else if(ex.equalsIgnoreCase("c"))
                    b = 2;
                else if(ex.equalsIgnoreCase("d"))
                    b = 3;
                else if(ex.equalsIgnoreCase("e"))
                    b = 4;
                else if(ex.equalsIgnoreCase("f"))
                    b = 5;
                else if(ex.equalsIgnoreCase("g"))
                    b = 6;
                else if(ex.equalsIgnoreCase("h"))
                    b = 7;
                Game.logicalGame.movePiece(sy-1,a,ey-1,b,whosturn);
                board.emptyBoard();
                board.updateGUI();
                if(Game.logicalGame.get(sy-1,a)==null) {
                    if (whosturn == 1)
                        whosturn = 0;
                    else if (whosturn == 0)
                        whosturn = 1;
                }
            }
        }
        if(mode==2) {
            while (Game.logicalGame.checkmate() == false) {
                clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                clock.setSize(250, 150);
                clock.setTitle("Clock");
                clock.setVisible(true);

                String place = k.next();
                String sx = place.substring(0,1);
                int sy = Integer.parseInt(place.substring(1,2));
                String ex =place.substring(2,3);
                int ey = Integer.parseInt(place.substring(3,4));
                int a=0,b=0;
                if(sx.equalsIgnoreCase("a"))
                    a = 0;
                else if(sx.equalsIgnoreCase("b"))
                    a = 1;
                else if(sx.equalsIgnoreCase("c"))
                    a = 2;
                else if(sx.equalsIgnoreCase("d"))
                    a = 3;
                else if(sx.equalsIgnoreCase("e"))
                    a = 4;
                else if(sx.equalsIgnoreCase("f"))
                    a = 5;
                else if(sx.equalsIgnoreCase("g"))
                    a = 6;
                else if(sx.equalsIgnoreCase("h"))
                    a = 7;

                if(ex.equalsIgnoreCase("a"))
                    b = 0;
                else if(ex.equalsIgnoreCase("b"))
                    b = 1;
                else if(ex.equalsIgnoreCase("c"))
                    b = 2;
                else if(ex.equalsIgnoreCase("d"))
                    b = 3;
                else if(ex.equalsIgnoreCase("e"))
                    b = 4;
                else if(ex.equalsIgnoreCase("f"))
                    b = 5;
                else if(ex.equalsIgnoreCase("g"))
                    b = 6;
                else if(ex.equalsIgnoreCase("h"))
                    b = 7;
                Game.logicalGame.movePiece(sy-1,a,ey-1,b,whosturn);
                board.emptyBoard();
                board.updateGUI();
                if(Game.logicalGame.get(sy-1,a)==null) {
                    if (whosturn == 1)
                        whosturn = 0;
                    else if (whosturn == 0)
                        whosturn = 1;
                }
            }
        }
    }
}