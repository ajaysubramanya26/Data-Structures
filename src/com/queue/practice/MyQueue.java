package com.queue.practice;

import java.util.NoSuchElementException;

/**
 * 
 * @author ajay
 *
 * @param <T>
 */
public class MyQueue<T> {
	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;

		public QueueNode(T data) {
			this.data = data;
		}

		private QueueNode<T> first;
		private QueueNode<T> last;

		@SuppressWarnings("unused")
		public void add(T item) {
			QueueNode<T> newItem = new QueueNode<T>(item);
			if (last != null) last.next = newItem;
			last = newItem;
			if (first == null) first = last;
		}

		@SuppressWarnings("unused")
		public T remove() {
			if (first == null) throw new NoSuchElementException();
			T data = first.data;
			first = first.next;
			if (first == null) last = null;
			return data;
		}

		@SuppressWarnings("unused")
		public T peek() {
			if (first == null) throw new NoSuchElementException();
			return first.data;
		}

		@SuppressWarnings("unused")
		public boolean isEmpty() {
			return first == null;
		}
	}
}
