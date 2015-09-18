package entities;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import navigators.Constants;

public class Frontier {
	private static int algorithm;
	private static Stack<Vertex> stack;
	private static Queue<Vertex> queue;
	private static PriorityQueue<Vertex> priorityQueue;
	
	public Frontier(int navigatorType) {
		algorithm = navigatorType;
		switch (algorithm) {
			case Constants.BFS:
				queue = new LinkedList<Vertex>();			
				break;
			case Constants.DFS:
				stack = new Stack<Vertex>();			
				break;
			case Constants.GreedyBFS:
				priorityQueue = new PriorityQueue<Vertex>();			
				break;
			default:
				break;
		}
	}

	public void push(Vertex vertex) {
		switch (algorithm) {
			case Constants.BFS:
				queue.add(vertex);			
				break;
			case Constants.DFS:
				stack.add(vertex);
				break;
			case Constants.GreedyBFS:
				priorityQueue.add(vertex);			
				break;
			default:
				break;
		}
	}
	
	public Vertex pop() {
		Vertex vertex = null;
		switch (algorithm) {
			case Constants.BFS:
				vertex = queue.remove();			
				break;
			case Constants.DFS:
				vertex = stack.pop();
				break;
			case Constants.GreedyBFS:
				vertex = priorityQueue.remove();			
				break;
			default:
				break;
		}
		return vertex;
	}
	
	public boolean isEmpty() {
		boolean isEmpty = true;
		switch (algorithm) {
			case Constants.BFS:
				isEmpty = queue.isEmpty();			
				break;
			case Constants.DFS:
				isEmpty = stack.isEmpty();
				break;
			case Constants.GreedyBFS:
				isEmpty = priorityQueue.isEmpty();			
				break;
			default:
				break;
		}
		return isEmpty;
	}
	
}
