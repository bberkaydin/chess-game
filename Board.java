/**
 * Created by berk on 10.07.2014.
 */
import com.sun.deploy.panel.JSmartTextArea;
import oracle.jrockit.jfr.JFR;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;


 public class Board extends JFrame implements MouseListener{
     Scanner keyboard = new Scanner(System.in);
     Color brown = new Color(130, 20, 0);
     JPanel squares[][] = new JPanel[8][8]; //Kareleri tutan array
     JPanel []Harfler = new JPanel[8]; // Kareleri gosteren harfler
     JPanel [] MoveSayi = new JPanel[8];
     JPanel [] MoveHarf = new JPanel[8];
     JButton button;
     //JTextArea textArea = new JTextArea(1,1);
     JLabel JL;
     JLabel nothing = new JLabel(new ImageIcon(""));
     ImageIcon image;
     String harfler = "ABCDEFGH";
     String sayi;


     public Board() {
         this.setTitle("Bil211_ChessDemo");
         this.setSize(720,720);
         this.setLayout(new GridLayout(11,8));
         for ( int i = 0; i < 8; i++) {
             sayi = Integer.toString(i+1);
             MoveSayi[i] = new JPanel();
             MoveSayi[i].add(new JButton(sayi));
         }

        harf();

         for ( int i = 0; i < 8; i++){
             Harfler[i] = new JPanel();
             Harfler[i].setBackground(Color.white);
             if ( i < 7) {
                 Harfler[i].add(new JLabel(harfler.substring(i,i+1)));
             }
             if ( i == 7) {
                 Harfler[i].add(new JLabel(harfler.substring(i,i+1)));
             }
         }
         for (int i = 0; i < 8; i++) {
             for (int j = 0; j < 8; j++) {
                 squares[i][j] = new JPanel();
                 if ((i + j) % 2 == 0) {
                     squares[i][j].setBackground(brown);
                 } else {
                     squares[i][j].setBackground(Color.lightGray);
                 }
                 image = new ImageIcon(getImageForPiece(Game.logicalGame.get(i,j)));
                 JL = new JLabel(image);
                 if (Game.logicalGame.get(i,j) == null) {
                     squares[i][j].add(nothing);
                     this.add(squares[i][j]);
                 }
                 else
                 {
                     squares[i][j].add(JL);
                 }
                 this.add(squares[i][j]);
             }
         }
         for ( int i = 0; i <8; i++){
             this.add(Harfler[i]);
         }
         for ( int i = 0; i < 8; i++) {
             this.add(MoveHarf[i]);
         }
         for ( int i = 0; i < 8; i++) {
             this.add(MoveSayi[i]);
         }

         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
     }
    public void harf(){
            MoveHarf[0] = new JPanel();
            button = new JButton(harfler.substring(0,1));
            MoveHarf[0].add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Game.logicalGame.setA(button.getText());
                }
            });

        MoveHarf[1] = new JPanel();
        button = new JButton(harfler.substring(1,2));
        MoveHarf[1].add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.logicalGame.setA(button.getText());
            }
        });
        MoveHarf[2] = new JPanel();
        button = new JButton(harfler.substring(2,3));
        MoveHarf[2].add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.logicalGame.setA(button.getText());
            }
        });
        MoveHarf[3] = new JPanel();
        button = new JButton(harfler.substring(3,4));
        MoveHarf[3].add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.logicalGame.setA(button.getText());
            }
        });
        MoveHarf[4] = new JPanel();
        button = new JButton(harfler.substring(4,5));
        MoveHarf[4].add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.logicalGame.setA(button.getText());
            }
        });
        MoveHarf[5] = new JPanel();
        button = new JButton(harfler.substring(5,6));
        MoveHarf[5].add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.logicalGame.setA(button.getText());
            }
        });
        MoveHarf[6] = new JPanel();
        button = new JButton(harfler.substring(6,7));
        MoveHarf[6].add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.logicalGame.setA(button.getText());
            }
        });
        MoveHarf[7] = new JPanel();
        button = new JButton(harfler.substring(7,8));
        MoveHarf[7].add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.logicalGame.setA(button.getText());
            }
        });
        }

     public void emptyBoard(){

         for(int i = 0; i < 8; i++){
             for(int j = 0; j < 8; j++) {
                 squares[i][j].removeAll();
                 squares[i][j].repaint();
             }
         }
     }
     public void updateGUI() {
         for(int i = 0; i < 8; i++){
             for(int j = 0; j < 8; j++){
                 image = new ImageIcon(getImageForPiece(Game.logicalGame.get(i,j)));
                 JL = new JLabel(image);
                 if (Game.logicalGame.get(i,j) == null) {
                 }
                 else
                 {
                     squares[i][j].add(JL);
                 }
                 this.add(squares[i][j]);
             }
         }
         for ( int i = 0; i <8; i++){
             this.add(Harfler[i]);
         }
         for ( int i = 0; i < 8; i++) {
             this.add(MoveHarf[i]);
         }
         for ( int i = 0; i < 8; i++) {
             this.add(MoveSayi[i]);
         }
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
     }
     private String getImageForPiece(Piece piece) {
         if (piece instanceof Knight) {
             if (piece.getColor() == 0)
                 return "./resources/blackKnight.png";
             if (piece.getColor() == 1)
                 return "./resources/whiteKnight.png";
         }
         if (piece instanceof Bishop) {
             if (piece.getColor() == 0)
                 return "./resources/blackBishop.png";
             if (piece.getColor() == 1)
                 return "./resources/whiteBishop.png";
         }
         if (piece instanceof King) {
             if (piece.getColor() == 0)
                 return "./resources/blackKing.png";
             if (piece.getColor() == 1)
                 return "./resources/whiteKing.png";
         }
         if (piece instanceof Queen) {
             if (piece.getColor() == 0)
                 return "./resources/blackQueen.png";
             if (piece.getColor() == 1)
                 return "./resources/whiteQueen.png";
         }
         if (piece instanceof Rook) {
             if (piece.getColor() == 0)
                 return "./resources/blackRook.png";
             if (piece.getColor() == 1)
                 return "./resources/whiteRook.png";
         }
         if (piece instanceof Pown) {
             if (piece.getColor() == 0)
                 return "./resources/blackPown.png";
             if (piece.getColor() == 1)
                 return "./resources/whitePown.png";
         }
         return "";
     }

     public void mouseClicked(MouseEvent m) {
    /*     System.out.println("mouseClicked X : "+m.getX()+" Y:" +m.getY());
         Component component = JL.findComponentAt(m.getX(), m.getY());
         //System.out.println("Component: " + component.getX() + "," + component.getY()); */
     }
     public void mouseEntered(MouseEvent m) {
//       System.out.println("mouseEntered X : "+m.getX()+" Y:" +m.getY());
     }
     public void mouseExited(MouseEvent m) {
//       System.out.println("mouseExited X : "+m.getX()+" Y:" +m.getY());
     }
     public void mousePressed(MouseEvent m) {
//       System.out.println("mousePressed X : "+m.getX()+" Y:" +m.getY());
     }
     public void mouseReleased(MouseEvent m) {
//       System.out.println("mouseReleased X : "+m.getX()+" Y:" +m.getY());
     }
 }