Question: 

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

A straight forward solution would be iterating the list and using a HashSet to store unique nodes. When we encounter a node which is already in the set, it means this list has a cycle. 
Suppose there are n nodes in the list, the time complexity is O(n), the space complexity is O(n).

public class Solution {
	public boolean hasCycle(ListNode head) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		while (head != null){
			if (set.contains(head))
				return true;
			set.add(head);
			head = head.next;
		}
		return false;
	}
}

Another solution is to use two pointers. One of them moves one step each time. The other moves two steps each time. Eventually they will reach the same node. This could be demonstrated by going through several examples. If there is indeed a cycle, the fast pointer will always be one loop faster than the slow pointer. So the time complexity is O(n), the space complexity is O(1).

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        if (head != null && head.next == head) return true;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
 
            if(slow == fast)
                return true;
        }
 
        return false;        
    }
}
