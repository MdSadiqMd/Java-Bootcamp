/*
Given a board of size 2*n and tile of size 2*1 and count the total number of ways to place the tiles on the board
possible ways to place the tile --> 1.Horizontal
                                    2.Vertical
Write test cases and observe the pattern
 */
public class _1_Tile_Problem {
    public static int getWays(int n){
        if(n<=3){
            return n;
        }
        return getWays(n-1)+getWays(n-2);
    }
    public static void main(String[] args) {
        System.out.println(getWays(5));
    }
}
