/*Refer Lesson Plan Notes Rather Than Reading This*/
/*
Algorithm is a sequence of writing code in finite number of steps in it's beat space and time complexity
Properties of algorithm:
--> Terminate after an amount of time
--> Produce at least one output
--> Independent of Programming language
--> Unambiguous (no confusion and deterministic outcome)
ex:while(true):
        print("Allah") --> This is not a valid algorithm as it will print infinite number of times
*/
/*
Time Complexity --> Time required by the CPU to execute a program
Types of time complexity:
1.Best Case (Omega Ω )
2.Average Case (Theta θ )
3.Worst Case (Big O)

ex:Printing sum of n numbers
(a)sum=0
   for(i=0;i<=n;i++){
   sum=sum+i;}
   return sum;}} //Time Complexity O(n)
(b)sum=0;
   sum=n*(n+1)/2; //Time Complexity O(1)
b execute faster than a

ex:
for(i=0;i<n;i++){
    for(j=0;j<n;j++){
        print("Hello world")
        }
     }
Here let us consider n=3 then for i=0 hello world will print three times and for i=1 3 times and i=2 three times total 9 times the overall time complexity is O(n^2)
If we Add another loop the time complexity may be O(n^3) this is called Quadratic Time Complexity

ex:
In Binary search we take the middle part and search for it thus the searching is for n elements
n/(2^k) = 1
k=log n to the base 2
Time Complexity is O(log n to the base 2)
This type of time complexity is called logarithmic time complexity

Note:
For time complexity on an overview check these points
1.Loops of a code
2.Bigger/Nested Loops
3.Number of Iterations
*/
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
Here every value in the code returning will be stored in stack and further on will get retrieved
here the space complexity is O(n) as further refer array
*/
public class _1_Algorithm_TimeComplexity_SpaceComplexity {
    public static void main(String[] args) {

    }
}
