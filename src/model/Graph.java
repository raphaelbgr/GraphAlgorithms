package model;

import java.util.ArrayList;
import java.util.List;


public class Graph {
	private List<Node> nodes = new ArrayList<Node>();
	private int visits = 1;
	
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
	
	// EXECUTES THE DETH FIRST SEARCH ALGORITHM
	public void executeDFS(Graph graph, Node node) {
		node.setVisited(true);
		node.setPrevisit(visits);
		visits++;
		System.out.println("Node " + node.getName() + " - previsit: " +  node.getPrevisit());
		for (Edge edge : node.getEdges()) {
			if (edge.getEnd().isVisited() == false) {
				edge.getEnd().setPrevisit(visits);
				executeDFS(graph, edge.getEnd());
				edge.getEnd().setPostvisit(visits);
			}
		}
		//		procedure DFS(G,v):
		//			2      label v as discovered
		//			3      for all edges from v to w in G.adjacentEdges(v) do
		//			4          if vertex w is not labeled as discovered then
		//			5              recursively call DFS(G,w)
	}
}
