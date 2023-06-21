public class _6_Sudoko_Solver {
    public static void PrintGrid(int[][] grid,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(int[][] grid,int row,int column,int num,int n){
        //Row Clash
        for(int i=0;i<n;i++){
            if (grid[row][i] == num) {
                return false;
            }
        }
        //Column Clash
        for(int i=0;i<n;i++){
            if (grid[i][column] == num) {
                return false;
            }
        }
        //Box-Clash
        int sqrt=(int) Math.sqrt(n);
        int boxRow=row-row%sqrt;
        int boxColumn=column-column%sqrt;
        for(int i=boxRow;i<boxRow+sqrt;i++){
            for(int j=boxColumn;j<boxColumn+sqrt;j++){
                if(grid[i][j]==num){
                    return false;
                }
            }
        }
        //if it's not having clash we return true
        return true;
    }
    public static boolean SudokoSolver(int[][] grid,int n){
        int row=-1,column=-1;
        boolean isEmpty=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    row=i;
                    column=j;
                    isEmpty=false;
                    break;
                }
            }
            if(!isEmpty){
                break;
            }
        }
        //if no empty space left
        if(isEmpty){
            return true;
        }
        for(int num=1;num<=9;num++){
            if(isSafe(grid,row,column,num,n)==true){
                grid[row][column]=num;
                if(SudokoSolver(grid,n)){
                    return true;
                }
                else{
                    //Backtrack
                    grid[row][column]=0;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] grid={
                {3,0,6,5,0,8,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},
                {0,0,3,0,1,0,0,8,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},
                {1,3,0,0,0,0,2,5,0},
                {0,0,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,3,0,0}
        };
        if(SudokoSolver(grid,grid.length)){
            PrintGrid(grid,grid.length);
        }
        else{
            System.out.println("Solution Doesn't Exist");
        }
    }
}
