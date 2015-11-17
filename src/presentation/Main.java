package presentation;

import java.util.ArrayList;
import java.util.List;

import model.Edge;
import model.Graph;
import model.Node;

public class Main {
	
	private static Graph graph;
	private static int visits = 0;
	
	public static void main(String [] args) {
		ArrayList<String> nodeAttributes2 = new ArrayList<String>();
		nodeAttributes2.add("B");
		nodeAttributes2.add("B-D");
		nodeAttributes2.add("B-E");
		insertNode(nodeAttributes2);
		
		ArrayList<String> nodeAttributes = new ArrayList<String>();
		nodeAttributes.add("A");
		nodeAttributes.add("A-B");
		nodeAttributes.add("A-C");
		insertNode(nodeAttributes);
		
		executeDFS(graph, graph.getNodes().get(0));
	}
	
	private static void executeDFS(Graph graph, Node node) {
		node.setVisited(true);
		System.out.println(node.getName());
		
		for (Edge edge : node.getEdges()) {
			
			if (edge.getEnd() != null && edge.getEnd().isVisited() == false) {
				edge.getEnd().setPrevisit(visits);
				visits++;
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

	private static void insertNode(ArrayList<String> nodeAttributes) {
		// CREATES THE GRAPH
		if (graph == null) {
			graph = new Graph();
		}
		
		// CREATES A LIST OF EDGES FOR AN UNKNOWN NODE
		List<Edge> edges = new ArrayList<Edge>();
		
		// CREATES A NEW NODE WITH NO EDGES
		Node node = new Node(nodeAttributes.get(0).charAt(0), null);
		
		// CREATES AND LINK NODES WICH ARE LIKNED TO THE ACTUAL INSERTED IF NOT CREATED
		for (int i = 1;  i < nodeAttributes.size() -1; i++) {
			String attribute = nodeAttributes.get(i);
			for (Character c : attribute.toCharArray()) {
				if (!graph.containsName(c) && (!c.toString().equalsIgnoreCase(String.valueOf(node.getName())) && c != '-')) {
					// CREATES A NEW NODE WITH THE PARAMETER GIVEN
					Node newNode = new Node(c, null);
					
					// CREATES A NEW EDGE AND POINTS IT TO THE DESTINATION NODE
					Edge newEdge = new Edge(newNode, node, 0);
					if (newNode.getEdges() == null) {
						newNode.setEdges(new ArrayList<Edge>());
					}
					newNode.getEdges().add(newEdge);
					
					// CREATES A NEW EDGE AND POINTS IT TO THE ORIGIN NODE
					if (node.getEdges() == null) {
						node.setEdges(new ArrayList<Edge>());
					}
					node.getEdges().add(new Edge(node, newNode, 0));
					node.getEdges().add(newEdge);
					
					// INSERTS THE NEW NODE TO THE GRAPH
					graph.addNode(newNode);
				}
			}
		}
		
		// ADDS AN EDGE TO THE LIST OF EDGES
		edges.add(new Edge(node, null, 0));
		
		// INSERTS THE LIST OF EDGES TO THE CREATED NODE
		node.setEdges(edges);
		
		// INSERTS THE CURRENT NODE TO THE CREATED GRAPH
		graph.addNode(node);
	}
}
