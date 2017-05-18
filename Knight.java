/**
 * Created by berk on 02.07.2014.
 */
public class Knight implements Piece {
    private boolean isCaptured = false;
    private int color,x,y;
    public Knight (int a) {

        this.color = a;
    }
    public int getColor() {

        return color;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean checkMove(int startx, int starty, int endx, int endy) {
            if ((startx + 2 == endx || startx - 2 == endx)) {
                if (starty + 1 == endy || starty - 1 == endy) {
                    if (Game.logicalGame.get(endx, endy) == null)
                        return true;
                    else if (Game.logicalGame.get(endx, endy) != null) {
                        if (Game.logicalGame.get(endx, endy).getColor() != Game.logicalGame.get(startx, starty).getColor())
                        {
                            isCaptured=true;
                            return true;
                        }
                        else
                            return false;
                    }
                }
            } else if ((starty + 2 == endy || starty - 2 == endy)) {
                if (startx + 1 == endx || startx - 1 == endx) {
                    if (Game.logicalGame.get(endx, endy) == null)
                        return true;
                    else if (Game.logicalGame.get(endx, endy) != null) {
                        if (Game.logicalGame.get(endx, endy).getColor() != Game.logicalGame.get(startx, starty).getColor())
                        {
                            isCaptured=true;
                            return true;
                        }
                        else
                            return false;
                    }
                }
            }

       return false;

    }
    @Override
    public boolean isCaptured(){
            return isCaptured;
    }

    @Override
    public int[] allMoves() {
        int[] move= new int[16];
        int i=0;
        int newX=x-2;
        int newY=y+1;
        if(newX>=0 && newY<8 && newY<8 && newX>=0) {
            move[i++] = newX;
            move[i++] = newY;

        }
        newY=y-1;
        if(newX>=0 && newX<8 && newY<8 && newY>=0) {
            move[i++] = newX;
            move[i++] = newY;
        }
        newX=x+2;
        newY=y-1;
        if(newX>=0 && newX<8 && newY<8 && newY>=0) {
            move[i++] = newX;
            move[i++] = newY;
        }
        newY=y+1;
        if(newX>=0 && newX<8 && newY<8 && newY>=0) {
            move[i++] = newX;
            move[i++] = newY;
        }
        newX=x-1;
        newY=y+2;
        if(newX>=0 && newX<8 && newY<8 && newY>=0) {
            move[i++] = newX;
            move[i++] = newY;
        }
        newX=x+1;
        if(newX>=0 && newX<8 && newY<8 && newY>=0) {
            move[i++] = newX;
            move[i++] = newY;
        }
        newX=x+1;
        newY=y-2;
        if(newX>=0 && newX<8 && newY<8 && newY>=0) {
            move[i++] = newX;
            move[i++] = newY;
        }
        newX=x-1;
        if(newX>=0 && newX<8 && newY<8 && newY>=0) {
            move[i++] = newX;
            move[i++] = newY;
        }
        return move;
    }

}
