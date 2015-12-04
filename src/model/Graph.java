package model;

import java.util.ArrayList;
import java.util.List;


public class Graph {

	private List<Node> nodes = new ArrayList<Node>();

	public boolean addNode(Node node) {
		if (!containsName(node.getName())) {
			nodes.add(node);
			return true;
		}
		return false;
	}
	public List<Node> getNodes() {
		return nodes;
	}
	public boolean containsName(String name) {
		for(Node node : nodes) {
			if (node.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	public Node searchNodeByName(String name) {
		for (Node node : nodes) {
			if (node.getName().equalsIgnoreCase(name)) {
				return node;
			}
		}
		return null;
	}

	public Node getClosestNode(Graph graph, List<Node> dijkstraList) {
		int d = Integer.MAX_VALUE;
		Node n = null;

		for (Node node : dijkstraList) {
			if (node.getDistance() < d) {
				d = node.getDistance();
				n = node;
			} else if (d == node.getDistance() && n == null) {
				d = node.getDistance();
				n = node;
			} else {
				if (node.compareTo(n) == -1) {
					n = node;
				}
			}
		}
		return n;
	}
}
