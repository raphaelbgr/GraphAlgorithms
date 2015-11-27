package presentation;

import java.util.ArrayList;

import model.Edge;
import model.Graph;
import model.Node;

public class Main {

	private static Graph graph;
	

	public static void main(String [] args) {
		
		graph = new Graph();
		
		ArrayList<String> nodeAttributes = new ArrayList<String>();
		nodeAttributes.add("A");
		nodeAttributes.add("A-B");
		nodeAttributes.add("A-C");
		insertNode(nodeAttributes);
		
		ArrayList<String> nodeAttributes2 = new ArrayList<String>();
		nodeAttributes2.add("B");
		nodeAttributes2.add("B-D");
		nodeAttributes2.add("B-E");
		insertNode(nodeAttributes2);

		System.out.println("============= START DEPH FIRST SEARCH =============");
		graph.executeDFS(graph, graph.getNodes().get(0));
		System.out.println("============= END DEPH FIRST SEARCH =============");
	}
	
	
	private static void insertNode(ArrayList<String> nodeAttributes) {
		for (String commandAttribute : nodeAttributes) {
			if (commandAttribute.length() == 1 && !graph.containsName(commandAttribute)) {
				Node node = new Node(commandAttribute);
				if (graph.addNode(node)) {
					System.out.println("Node " + commandAttribute + " added successfully to the graph.");
				} else {
					System.err.println("Node " + commandAttribute + " already exists on the graph, node not added.");
				}
			} else if (commandAttribute.contains("-")) {

				// CREATES NULL NODE REFERENCES
				Node node1;
				Node node2;

				// TAKES THE NODE LETTERS FROM THE COMMANDS ON THE INPUT
				String term1 = String.valueOf(commandAttribute.charAt(0));
				String term2 = String.valueOf(commandAttribute.charAt(2));

				// SEARCHES FOR EXISTING NODES WITH THAT NAME
				node1 = graph.searchNodeByName(term1);
				if (node1 == null) {
					// CREATES A NEW NODE IF NO NODE IS FOUND
					node1 = new Node(term1);
					System.out.println("Node " + node1.getName() + " added successfully to the graph.");
				}

				// SEARCHES IF THE SECOND NODE EXISTS ON THE GRAPH
				node2 = graph.searchNodeByName(term2);
				if (node2 == null) {
					// CREATES A NEW NODE IF NO NODE IS FOUND
					node2 = new Node(term2);
					System.out.println("Node " + node2.getName() + " added successfully to the graph.");
				}

				// CREATES TWO NEW EDGES LINKING THOSE NODES FORWARDLY AND BACKWARDLY WITH BOTH DIRECTIONS (0)
				Edge edge1 = new Edge(node1, node2, 0);
				Edge edge2 = new Edge(node2, node1, 0);

				// ADDS THOSE EDGES TO THE CORRESPONDING NODES
				node1.addEdge(edge1);
				node2.addEdge(edge2);

				// ADDS THE CREATED NODES TO THE GRAPH
				graph.addNode(node1);
				
				graph.addNode(node2);
			}
		}
	}
}
