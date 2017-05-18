/**
 * Created by Salih on 02.07.2014.
 */
public interface Piece {

    //checks whether the Piece can move from location (startx,starty) to (endx, endy)
    public boolean checkMove(int startx, int starty, int endx, int endy);
    //returns whether the Piece is still on play or not.
    public boolean isCaptured();
    //return all moves that the Piece can make. It should return an array of
    //coordinates (x,y), in a format
    public int[] allMoves();
    public int getColor();
}
