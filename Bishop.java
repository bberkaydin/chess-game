/**
 * Created by berk on 02.07.2014.
 */
public class Bishop implements Piece {
    private boolean isCaptured = false;
    private int color,x,y;

    public Bishop (int a) {
        this.color = a;
    }
    public int getColor() {
        return color;
    }

    public boolean checkMove(int startx, int starty, int endx, int endy) {
        int i,j,say=0,a=1;
        i=startx-endx;
        j=starty-endy;
                while(true){
                    if(i>0 && j<0 && Game.logicalGame.get(startx-a,starty+a)==null)
                        say=1;
                    else if(i>0 && j>0 && Game.logicalGame.get(startx-a,starty-a)==null)
                        say=2;
                    else if(i<0 && j>0 && Game.logicalGame.get(startx+a,starty-a)==null)
                        say=3;
                    else if(i<0 && j<0 && Game.logicalGame.get(startx+a,starty+a)==null)
                        say=4;
                    else {
                        say = 0;
                        break;
                    }
                    a++;
                    if (startx + a <= endx || starty + a <= endy || startx - a <= endx || starty - a <= endy || (startx+a<8 && startx-a>=0 && starty+a<8 && starty-a>=0))
                        break;
                }
        if(Game.logicalGame.get(endx,endy)!=null) {
            if(Game.logicalGame.get(endx,endy).getColor()!=Game.logicalGame.get(startx,starty).getColor() && (say==1 || say==2 || say==3 ||say==4))
            {
                return true;
            }
            else
                return false;
        }
        else if(Game.logicalGame.get(endx,endy)==null && (say==1 || say==2 || say==3 ||say==4)) {
            return true;
        }
        else
            return false;

    }


    @Override
    public boolean isCaptured() {
        return isCaptured;
    }

    @Override
    public int[] allMoves() {
        int[] move = new int [32];
        int newX=x,newY=y,i=0,j=1;
        while(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
            newX = x + j;
            newY = y + j;
            if(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
                move[i++] = newX;
                move[i++] = newY;
            }
            j++;
        }
        j=1;
        while(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
            newX = x - j;
            newY = y + j;
            if(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
                move[i++] = newX;
                move[i++] = newY;
            }
            j++;
        }
        j=1;
        while(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
            newX = x - j;
            newY = y - j;
            if(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
                move[i++] = newX;
                move[i++] = newY;
            }
            j++;
        }
        j=1;
        while(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
            newX = x + j;
            newY = y - j;
            if(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
                move[i++] = newX;
                move[i++] = newY;
            }
            j++;
        }
        return move;
    }
}
