package algorithms.implementation;

import java.util.ArrayList;
import java.util.List;

import algorithms.Algorithm;
import model.Edge;
import model.Graph;
import model.Node;

public class Dijkstra  implements Algorithm {

	private List<Node> dijkstraList = new ArrayList<Node>();

	@Override
	public void execute(Graph graph, Node source) {
		for (Node vertex : graph.getNodes()) {
			vertex.setDistance(Integer.MAX_VALUE);
			vertex.setParent(null);
		}

		source.setDistance(0);
		dijkstraList.addAll(graph.getNodes());

		while (!dijkstraList.isEmpty()) {
			Node u = graph.getClosestNode(graph, dijkstraList);
			dijkstraList.remove(u);
			System.out.println("Node " + u.getName() + " hops from " + source.getName() + ": " + u.getDistance());
			for (Edge edge : u.getEdges()) {
				Node v = edge.getEndNode();
				int alt = u.getDistance() + edge.getWeight();
				if (alt < v.getDistance()) {
					v.setDistance(alt);
					v.setParent(u);
				}
			}
		}
	}
	
	public Dijkstra() {
		System.out.println("============= START OF DIJKSTRA MINUMUM PATH SEARCH=============");
	}
	
	@Override
	public void showResults() {
		System.out.println("============= END OF DIJKSTRA MINUMUM PATH SEARCH =============");
	}


}