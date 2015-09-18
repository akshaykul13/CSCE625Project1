package navigators;

import java.util.ArrayList;

import entities.Edge;
import entities.Frontier;
import entities.Graph;
import entities.Vertex;

public class PathFinder {
		
	public static void search(Graph graph, Vertex source, Vertex destination, int navigatorType) {
		int[] status = new int[graph.V()];
		Frontier frontier = new Frontier(navigatorType);
		frontier.push(source);
		status[source.getId()] = Constants.VISITED;
		source.setParent(-1);
		System.out.println("Pushed Vertex " + source.getId() + '(' + source.getX() + ',' + source.getY() + ')');
		while (!frontier.isEmpty()) {
			Vertex poppedVertex = frontier.pop();
			System.out.println("Popped Vertex " + poppedVertex.getId() + '(' + poppedVertex.getX() + ',' + poppedVertex.getY() + ')');
			if (poppedVertex.getId() == destination.getId()) {
				System.out.println("Found Node"); 
				printTracebackPath(poppedVertex, graph);
				return;
			}
			for(Edge edge: graph.getAdj()[poppedVertex.getId()]) {
				int neighborID = edge.getV() == poppedVertex.getId() ? edge.getW() : edge.getV();				
				if (status[neighborID] == Constants.UNSEEN) {
					Vertex neighborVertex = graph.getVertices()[neighborID];
					neighborVertex.setParent(poppedVertex.getId());
					frontier.push(neighborVertex);
					System.out.println("Pushed Vertex " + neighborVertex.getId() + '(' + neighborVertex.getX() + ',' + neighborVertex.getY() + ')');
					status[neighborID] = Constants.VISITED;
				}				
			}
		}
	}

	private static void printTracebackPath(Vertex poppedVertex, Graph graph) {		
		int parentID = poppedVertex.getId();
		while (parentID != -1) {
			Vertex node = graph.getVertices()[parentID];
			// System.out.println("vertex " + parentID + "(" + node.getX() + "," + node.getY() + ")");
			System.out.println(node.getX() + " " + node.getY());
			parentID = node.getParent();
		}
	}
}
