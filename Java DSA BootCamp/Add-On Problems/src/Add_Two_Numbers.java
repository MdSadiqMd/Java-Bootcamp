import java.util.Stack;
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807
 */
public class Add_Two_Numbers {
    public static class LinkedList {
        Node head;
        class Node {
            int data;
            Node next;
            Node(int d) {
                data = d;
                next = null;
            }
        }
    }

    public static void insert(LinkedList list, int newData) {
        LinkedList.Node newNode = list.new Node(newData);
        if (list.head == null) {
            list.head = newNode;
        } else {
            LinkedList.Node current = list.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public static void insert1(LinkedList list, int newData) {
        LinkedList.Node newNode = list.new Node(newData);
        if (list.head == null) {
            list.head = newNode;
        } else {
            LinkedList.Node current = list.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public static void Sum(LinkedList list1, LinkedList list2, Stack<Integer> stack1, Stack<Integer> stack2) {
        LinkedList.Node pointer = list1.head;
        LinkedList.Node pointer1 = list2.head;
        while (pointer != null) {
            stack1.push(pointer.data);
            pointer = pointer.next;
        }
        while (pointer1 != null) {
            stack2.push(pointer1.data);
            pointer1 = pointer1.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        insert(list, 2);
        insert(list, 4);
        insert(list, 2);

        LinkedList list1 = new LinkedList();
        insert1(list1, 5);
        insert1(list1, 6);
        insert1(list1, 4);

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        Sum(list, list1, stack1, stack2);

        int[] ans = new int[3];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack1.pop() + stack2.pop();
        }

        for (int i = ans.length - 1; i >= 0; i--) {
            System.out.println(ans[i]);
        }
    }
}
