package com.stack.practice;

import java.util.EmptyStackException;

/**
 * using a single array to hold three stacks
 * 
 * @author ajay
 *
 */
public class FixedMultiStack {
	/* the number of stacks we want to have in the array */
	private int numOfStacks = 3;
	/* the capacity of each stack */
	private int stackCapacity;
	/* the array that would store all the stacks */
	private int[] values;
	/* the array that would have the size of all the stacks */
	private int[] sizes;

	public FixedMultiStack(int stackSize) {
		this.stackCapacity = stackSize;
		this.values = new int[this.numOfStacks * stackSize];
		this.sizes = new int[this.numOfStacks];
	}

	public void push(int stackNum, int value) {
		if (isFull(stackNum)) return;
		this.sizes[stackNum]++;
		this.values[getTopOfStack(stackNum)] = value;
	}

	public int pop(int stackNum) {
		if (isEmpty(stackNum)) throw new EmptyStackException();
		int topIndex = getTopOfStack(stackNum);
		int topValue = values[topIndex];
		values[topIndex] = 0; // clear
		sizes[stackNum]--; // shrink
		return topValue;
	}

	public int peek(int stackNum) {
		if (isEmpty(stackNum)) throw new EmptyStackException();
		int topIndex = getTopOfStack(stackNum);
		return values[topIndex];
	}

	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}

	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}

	public int getTopOfStack(int stackNum) {
		int offset = stackNum * stackCapacity;
		return offset + sizes[stackNum] - 1;
	}
}
