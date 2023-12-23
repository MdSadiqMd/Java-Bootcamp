/*
Happy Number means we need to sum te squares of the individual numbers if the sum is equal to 1 then it is a happy number otherwise it is not
Example:
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1 and it returns true
Not been given in problem, but you need to understand it by giving test cases --> If a number is not a happy number then the loop will form
So, to approach this problem we can actually use linked list method to find whether a given number and the process have a loop or not
 */
public class Happy_Number {
    static class Node{
        int data;
        Merge_K_Sorted_Lists.Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int findSquare(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans += rem * rem;
            n /= 10;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
