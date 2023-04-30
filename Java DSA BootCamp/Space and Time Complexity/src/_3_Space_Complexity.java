/*
Our objective is to get less space and less Time Complexity
But if we have a choice to choose between time and Space we choose better Time Complexity as space is available but time isn't

Space Complexity Means the space needed to execute a Code
Two types of Space Complexity:
1.Variable (always the space complexity is O(1))
2.Array or other data Structures where the space complexity varies

ex:
int f(int n){
    if(n<=0){
        return 0;
    }
    return n+f(n-1);
}
In above problem we are using recursion here f(int n) is a function inside that function we have f(n-1) which a shifted argument function of f(n)
Here every value in the code returning will be stored in stack and further on will get retrived
here the space complexity is O(n) as further refer array
 */
public class _3_Space_Complexity {
    public static void main(String[] args) {

    }
}
