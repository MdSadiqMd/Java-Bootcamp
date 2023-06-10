import java.util.*;
/*
The Josephus Problem is a mathematical problem that involves a group of people standing in a circle and eliminating every kth person until only one person remains.
Your program should take two inputs: the total number of people in the circle (n) and the elimination count (k). The program should then simulate the elimination process and determine the position of the last person remaining.
Your task is to implement a function named "getLastPersonPosition" that takes two integers, n and k, as input and returns the position of the last person remaining.

Constraints:
The total number of people in the circle (n) is a positive integer (1 <= n <= 10^6).
The elimination count (k) is a positive integer (1 <= k <= n).

Note:
You can assume that the positions are numbered from 1 to n in a clockwise manner.
 */
public class Josephus_Problem {
    static void Josephus(List<Integer> person, int k, int index)
    {
        // Base case , when only one person is left
        if (person.size() == 1) {
            System.out.println(person.get(0));
            return;
        }
        // Find the index of first person which will die
        index = ((index + k) % person.size());
        // Remove the first person which is going to be killed
        person.remove(index);
        // Recursive call for n-1 persons
        Josephus(person, k, index);
    }

    // Driver code
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number of people : ");
        int n=sc.nextInt();
        System.out.print("Enter the Elimination Count : ");
        int k=sc.nextInt();
        k--; // (k-1)th person will be killed
        int index = 0; // The index where the person which will die

        List<Integer> person = new ArrayList<>();
        // Fill the person vector
        for (int i = 1; i <= n; i++) {
            person.add(i);
        }
        Josephus(person, k, index);
    }
}
