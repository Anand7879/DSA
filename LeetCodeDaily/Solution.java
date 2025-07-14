//Date 14th july 2025
// Day Monday
 class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { 
        this.val = val; 
    }

    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

public class Solution {
    
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = (result << 1) | head.val;
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        // Example: Linked List 1 -> 0 -> 1 (binary = 101 = 5)

        ListNode third = new ListNode(1);
        ListNode second = new ListNode(0, third);
        ListNode first = new ListNode(1, second);

        Solution solution = new Solution();
        int decimalValue = solution.getDecimalValue(first);
        
        System.out.println("Decimal value of binary linked list: " + decimalValue);
    }
}
