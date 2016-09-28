package com.linkedlist.practice;

import com.ctci.linkedlist.library.AssortedMethods;
import com.ctci.linkedlist.library.LinkedListNode;

public class App {

	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		if (node.next != null) {
			value = 10 * linkedListToInt(node.next);
		}
		return value + node.data;
	}

	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.createLinkedListFromArray(new int[] { 1, 0, 1, 1, 0, 1 });
		System.out.println(head.printForward());
		System.out.println(LinkedList.isPalindrom1(head));
	}

}