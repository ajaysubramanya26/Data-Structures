package com.linkedlist.practice;

import java.util.HashSet;
import java.util.Stack;

import com.ctci.linkedlist.library.LinkedListNode;

/**
 * using hash table, running time : O(n)
 * 
 * @author ajay
 *
 */
public class LinkedList {

	public static void deleteDups(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<>();
		LinkedListNode previous = null;
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}

	public static void deleteDupsUsingRunner(LinkedListNode n) {
		LinkedListNode current = n;
		while (current != null) {
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (current.data == runner.next.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	public static void getKthItem(LinkedListNode head, int k) {
		LinkedListNode current = head;
		LinkedListNode runner = head;

		for (int i = 0; i < k; i++) {
			if (runner == null) return;
			runner = runner.next;
		}

		while (runner.next != null) {
			current = current.next;
			runner = runner.next;
		}

		System.out.println("K'th item " + current.data);
	}

	public static int getKthItemRecursively(LinkedListNode head, int k) {
		if (head == null) return 0;
		int index = getKthItemRecursively(head.next, k) + 1;
		if (index == k) System.out.println(k + "'th from last is " + head.data);
		return index;
	}

	public static boolean deleteMiddleNode(LinkedListNode node) {
		if (node == null || node.next == null) return false;
		LinkedListNode next = node.next;
		node.data = next.data;
		node.next = next.next;
		return true;
	}

	/* incomplete */
	public static LinkedListNode sumLists(LinkedListNode head1, LinkedListNode head2) {

		Stack<Integer> stack = new Stack<>();
		int rem = 0;
		while (head1.next != null || head2.next != null) {
			int sum = head1.data + head2.data + rem;
			rem = 0;
			if (sum % 9 > 0) rem = sum % 9;
			stack.push(sum % 10);
			head1 = head1.next;
			head2 = head2.next;
		}

		stack.push(head1.data + head2.data + rem);

		LinkedListNode first = new LinkedListNode(stack.pop(), null, null);
		LinkedListNode second = first;
		LinkedListNode head = first;
		for (int i = 0; i <= stack.size(); i++) {
			second = new LinkedListNode(stack.pop(), null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}

		return head;
	}

	/**
	 * 
	 * @param head
	 *            the head of the linked list that you want to reverse
	 * @return the head of the reversed linked list
	 */
	public static LinkedListNode reverseLinkedList(LinkedListNode head) {
		LinkedListNode rev = null;
		while (head != null) {
			LinkedListNode newNode = new LinkedListNode(head.data, null, null);
			newNode.next = rev;
			rev = newNode;
			head = head.next;
		}
		return rev;
	}

	/**
	 * 
	 * @param l1
	 *            first linked list
	 * @param l2
	 *            second linked list
	 * @return if the two linked lists are equal
	 */
	public static boolean isEqual(LinkedListNode l1, LinkedListNode l2) {
		while (l1 != null || l2 != null) {
			if (l1.data != l2.data) return false;
			l1 = l1.next;
			l2 = l2.next;
		}
		return l1 == null && l2 == null;
	}

	/**
	 * 
	 * @param head
	 *            head of a linked list
	 * @return if the given linked list is a palindrom or not
	 */
	public static boolean isPalindrom(LinkedListNode head) {
		LinkedListNode rev = reverseLinkedList(head);
		return isEqual(rev, head);
	}

	/**
	 * iterative approach using stack
	 * 
	 * @param head
	 *            head of a linked list
	 * @return if the given linked list is a palindrom or not
	 */
	public static boolean isPalindrom1(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		Stack<Integer> stack = new Stack<>();

		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null) slow = slow.next;

		while (slow != null) {
			if (stack.pop() != slow.data) return false;
			slow = slow.next;
		}

		return true;
	}

	/* not tested */
	public static LinkedListNode findIntersectingNode(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode first = head1;
		LinkedListNode second = head2;

		int len1 = 0;
		int len2 = 0;

		while (first.next != null) {
			len1++;
			first = first.next;
		}

		while (second.next != null) {
			len2++;
			second = second.next;
		}

		if (first.data != second.data) return null;

		if (len1 > len2) {
			for (int i = 0; i < len1; i++) {
				head1 = head1.next;
			}
		} else {
			for (int i = 0; i < len2; i++) {
				head2 = head2.next;
			}
		}

		while (head1 != head2) {
			head1 = head1.next;
			head2 = head2.next;
		}

		return head1;
	}
}
