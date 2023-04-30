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
public class _2_Time_Complexity {
    public static void main(String[] args) {

    }
}
