/**
 * Created by berk on 02.07.2014.
 */
public class Pown implements Piece {
    private int color,x,y;
    private boolean isCaptured = false;
    public Pown (int a) {
        this.color = a;
    }
    public int getColor() {
        return color;
    }
    @Override
    public boolean checkMove(int startx, int starty, int endx, int endy) {

        if(Game.logicalGame.get(startx,starty).getColor()==1){
            if(startx==1){
                if((startx+1==endx && starty==endy && Game.logicalGame.get(endx,endy)==null) || (startx+2==endx && starty==endy && Game.logicalGame.get(endx,endy)==null && Game.logicalGame.get(endx-1,endy)==null))
                    return true;
                 else if((starty+1==endy || starty-1==endy) && startx+1==endx && Game.logicalGame.get(endx,endy)!=null) {
                    if(Game.logicalGame.get(endx,endy).getColor()!=Game.logicalGame.get(startx,starty).getColor())
                    return true;
                }
                else
                    return false;
            }
            else if(startx!=1 && startx+1==endx&& starty==endy && Game.logicalGame.get(endx,endy)==null)
                return true;
            else if((starty+1==endy || starty-1==endy) && startx+1==endx  && Game.logicalGame.get(endx,endy)!=null) {
                if (Game.logicalGame.get(endx, endy).getColor() != Game.logicalGame.get(startx, starty).getColor())
                    return true;
            }
            else
                return false;
        }
        else {
            if (startx == 6) {
                if ((startx - 1 == endx && starty == endy && Game.logicalGame.get(endx, endy) == null) || (startx - 2 == endx && starty == endy && Game.logicalGame.get(endx, endy) == null && Game.logicalGame.get(endx + 1, endy) == null))
                    return true;
                else if ((starty + 1 == endy || starty - 1 == endy) && startx + 1 == endx && Game.logicalGame.get(endx, endy).getColor() != Game.logicalGame.get(startx, starty).getColor() && Game.logicalGame.get(endx, endy) != null)
                    if (Game.logicalGame.get(endx, endy).getColor() != Game.logicalGame.get(startx, starty).getColor()) {
                        return true;
                    }
            } else if (startx != 6 && startx - 1 == endx && starty == endy && Game.logicalGame.get(endx, endy) == null) {
                isCaptured = true;
                return true;
            } else if ((starty + 1 == endy || starty - 1 == endy) && startx - 1 == endx && Game.logicalGame.get(endx, endy) != null)
                if (Game.logicalGame.get(endx, endy).getColor() != Game.logicalGame.get(startx, starty).getColor()){
                    return true;
        }
            else
                return false;
        }

        return false;
    }

    @Override
    public boolean isCaptured() {
        return isCaptured;
    }

    @Override
    public int[] allMoves() {
        int[] move = new int [12];
        int newX,newY,i=0;
        if(getColor()==0) {
            newX=x+1;
            newY=y;
            if (newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
                move[i++] = newX;
                move[i++] = newY;
            }
            if (x==1){
                newX=x+2;
                newY=y;
                if (newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
                    move[i++] = newX;
                    move[i++] = newY;
                }
            }
            if(Game.logicalGame.get(x+1,y+1).getColor()!=Game.logicalGame.get(x,y).getColor()){
                newX=x+1;
                newY=y+1;
                if (newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
                    move[i++] = newX;
                    move[i++] = newY;
                }
            }
            if(Game.logicalGame.get(x-1,y+1).getColor()!=Game.logicalGame.get(x,y).getColor()){
                newX=x+1;
                newY=y-1;
                if (newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
                    move[i++] = newX;
                    move[i++] = newY;
                }
            }
        }
        else if (getColor()==1){
            newX=x-1;
            newY=y;
            if (newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
                move[i++] = newX;
                move[i++] = newY;
            }
            if (y==6){
                newX=x-2;
                newY=y;
                if (newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
                    move[i++] = newX;
                    move[i++] = newY;
                }
            }
            if(Game.logicalGame.get(x+1,y-1).getColor()!=Game.logicalGame.get(x,y).getColor()){
                newX=x-1;
                newY=y-1;
                if (newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
                    move[i++] = newX;
                    move[i++] = newY;
                }
            }
            if(Game.logicalGame.get(x-1,y-1).getColor()!=Game.logicalGame.get(x,y).getColor()){
                newX=x-1;
                newY=y+1;
                if (newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
                    move[i++] = newX;
                    move[i++] = newY;
                }
            }
        }
        return move;
    }
}
