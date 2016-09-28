package com.stack.practice;

import java.util.EmptyStackException;

/**
 * 
 * @author ajay
 *
 * @param <T>
 */
public class MyStack<T> {
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
		}

		private StackNode<T> top;

		@SuppressWarnings("unused")
		public T pop() {
			if (top == null) throw new EmptyStackException();
			T item = top.data;
			top = top.next;
			return item;
		}

		@SuppressWarnings("unused")
		public void push(T item) {
			StackNode<T> newItem = new StackNode<T>(item);
			newItem.next = top;
			top = newItem;
		}

		@SuppressWarnings("unused")
		public T peek() {
			if (top == null) throw new EmptyStackException();
			return top.data;
		}

		@SuppressWarnings("unused")
		public boolean isEmpty() {
			return top == null;
		}
	}
}
