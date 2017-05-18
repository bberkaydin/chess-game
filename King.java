/**
 * Created by berk on 02.07.2014.
 */
public class King implements Piece {
    private int color,x,y;
    private boolean isCaptured = false;

    public King (int a) {
        this.color = a;
    }
    public int getColor() {
        return color;
    }
    @Override
    public boolean checkMove(int startx, int starty, int endx, int endy) {

        if(startx+1==endx){
            if((starty+1==endy || starty-1==endy ||starty==endy) && Game.logicalGame.get(endx,endy)==null)
                return true;
            else if((starty+1==endy || starty-1==endy ||starty==endy) && Game.logicalGame.get(endx,endy)!=null){
                if(Game.logicalGame.get(endx,endy).getColor()!=Game.logicalGame.get(startx,starty).getColor()) {
                    isCaptured = true;
                    return true;
                }
            }
        }
        else if(startx-1==endx){
            if((starty+1==endy || starty-1==endy ||starty==endy) && Game.logicalGame.get(endx,endy)==null)
                return true;
            else if((starty+1==endy || starty-1==endy ||starty==endy) && Game.logicalGame.get(endx,endy)!=null){
                if(Game.logicalGame.get(endx,endy).getColor()!=Game.logicalGame.get(startx,starty).getColor()) {
                    isCaptured = true;
                    return true;
                }
            }
        }
        else if(starty+1==endy){
            if((startx+1==endx || startx-1==endx ||startx==endx) && Game.logicalGame.get(endx,endy)==null)
                return true;
            else if((startx+1==endx || startx-1==endx ||startx==endx) && Game.logicalGame.get(endx,endy)!=null){
                if(Game.logicalGame.get(endx,endy).getColor()!=Game.logicalGame.get(startx,starty).getColor()) {
                    isCaptured = true;
                    return true;
                }
            }
        }
        else if(starty-1==endy){
            if((startx+1==endx || startx-1==endx ||startx==endx) &&Game.logicalGame.get(endx,endy)==null)
                return true;
            else if((startx+1==endx || startx-1==endx ||startx==endx) && Game.logicalGame.get(endx,endy)!=null){
                if(Game.logicalGame.get(endx,endy).getColor()!=Game.logicalGame.get(startx,starty).getColor()) {
                    isCaptured=true;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isCaptured() {
        return isCaptured;
    }

    @Override
    public int[] allMoves() {
        int[] move = new int[16];
        int newX,newY,i=0,j=1;
        newX=x;
        newY=y-1;
        if(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
            move[i++] = newX;
            move[i++] = newY;
        }
        newX=x+1;
        newY=y-1;
        if(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
            move[i++] = newX;
            move[i++] = newY;
        }
        newX=x+1;
        newY=y;
        if(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
            move[i++] = newX;
            move[i++] = newY;
        }
        newX=x-1;
        newY=y+1;
        if(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
            move[i++] = newX;
            move[i++] = newY;
        }
        newX=x;
        newY=y+1;
        if(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
            move[i++] = newX;
            move[i++] = newY;
        }
        newX=x-1;
        newY=y+1;
        if(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
            move[i++] = newX;
            move[i++] = newY;
        }
        newX=x-1;
        newY=y;
        if(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
            move[i++] = newX;
            move[i++] = newY;
        }
        newX=x-1;
        newY=y-1;
        if(newX >= 0 && newX < 8 && newY < 8 && newY >= 0) {
            move[i++] = newX;
            move[i++] = newY;
        }


        return move;
    }
}
