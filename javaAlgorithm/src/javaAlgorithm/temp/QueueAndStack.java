package javaAlgorithm.temp;

import java.util.*;

public class QueueAndStack {
	public static void main (String[] args) {
		System.out.println("Queue");
		Queue<Integer> queue = new LinkedList<>();
		System.out.println(queue.poll());
		queue.add(10);
		queue.add(20);
		queue.add(30);
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue.poll());
		System.out.println("peek: " + queue.peek());
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		System.out.println("Stack");
		Stack<Integer> stack = new Stack<>();
		stack.add(10);
		stack.add(20);
		stack.add(30);
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println("peek: " + stack.peek());
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
