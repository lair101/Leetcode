package rotate;
/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

	For example:
	Given 1->2->3->4->5->NULL and k = 2,
	return 4->5->1->2->3->NULL.
 * @author Haolin
 *
 */
public class RotateList {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	private int getLength(ListNode header){
		int len=0;
		while(header!=null){
			header=header.next;
			len++;
		}
		return len;
	}
	
	public ListNode solution(ListNode head, int k){
//		It is to solve two corner cases:
//		1) order is greater than arr. length
//		2) order is negative
		if(head==null) return head;
		ListNode start= head;
		int len = getLength(head);
		k=k%len;
		head.next=start;
		for(int i=0;i<len-k;i++){
			head=head.next;
		}
		ListNode rs =head.next;
		head.next=null;
		return rs;
		
		
	}
}
