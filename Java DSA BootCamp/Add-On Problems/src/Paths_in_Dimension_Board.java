public class Paths_in_Dimension_Board {
    public static void printBoardPaths(int curr, int dest, String ans) {

        if(curr > dest) {
            return;
        }

        if(curr == dest) {
            System.out.println(ans);
            return;
        }
        printBoardPaths(curr + 1, dest, ans + 1);
        printBoardPaths(curr + 2, dest, ans + 2);
        printBoardPaths(curr + 3, dest, ans + 3);
        printBoardPaths(curr + 4, dest, ans + 4);
        printBoardPaths(curr + 5, dest, ans + 5);
        printBoardPaths(curr + 6, dest, ans + 6);
    }
    public static void main(String[] args) {
        printBoardPaths(0, 8, "");
    }
}
