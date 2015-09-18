package navigators;

import java.io.FileNotFoundException;

import entities.Graph;
import entities.GraphBuilder;
import entities.Vertex;

public class DFS_nav {
	
	private static Graph graph;

	public static void main(String[] args) throws FileNotFoundException {
		graph = GraphBuilder.buildGraph(args[0]);
		int x1 = Integer.parseInt(args[1]);
		int y1 = Integer.parseInt(args[2]);
		int x2 = Integer.parseInt(args[3]);
		int y2 = Integer.parseInt(args[4]);
		int vertex1ID = getIDFromCoordinates(x1, y1);
		int vertex2ID = getIDFromCoordinates(x2, y2);
		PathFinder.search(graph, graph.getVertices()[vertex1ID], graph.getVertices()[vertex2ID], Constants.DFS);
	}

	private static int getIDFromCoordinates(int x, int y) {
		for (Vertex vertex: graph.getVertices()) {
			if (vertex.getX() == x && vertex.getY() == y) {
				return vertex.getId();
			}
		}
		return -1;
	}
}
