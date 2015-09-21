package navigators;

import java.io.FileNotFoundException;

import entities.Graph;
import entities.GraphBuilder;
import entities.Node;

public class Navigator {
	private static Graph graph;

	public static void main(String[] args) throws FileNotFoundException {		
		int navigatorType = getNavigator(args[0]);
		graph = GraphBuilder.buildGraph(args[1]);
		int x1 = Integer.parseInt(args[2]);
		int y1 = Integer.parseInt(args[3]);
		int x2 = Integer.parseInt(args[4]);
		int y2 = Integer.parseInt(args[5]);
		int vertex1ID = getIDFromCoordinates(x1, y1);
		int vertex2ID = getIDFromCoordinates(x2, y2);
		PathFinder.search(graph, graph.getVertices()[vertex1ID], graph.getVertices()[vertex2ID], navigatorType);
	}

	private static int getNavigator(String navigator) {
		if (navigator.equals("BFS")) {
			return Constants.BFS;
		} 
		if (navigator.equals("DFS")) {
			return Constants.DFS;
		}
		if (navigator.equals("GBFS")) {
			return Constants.GreedyBFS;
		}
		return -1;
	}

	private static int getIDFromCoordinates(int x, int y) {
		for (Node vertex: graph.getVertices()) {
			if (vertex.getX() == x && vertex.getY() == y) {
				return vertex.getId();
			}
		}
		return -1;
	}
}
