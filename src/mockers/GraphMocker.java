package mockers;

import java.util.ArrayList;

import model.Edge;
import model.Graph;
import model.Node;

public class GraphMocker {

	public Graph createMockedGraph() {
		Graph graph = new Graph();
		mockGraph(graph);
		return graph;
	}

	private void mockGraph(Graph graph) {
		System.out.println("");
		System.out.println("============= MOCKING GRAPH... =============");
		
		ArrayList<String> nodeAttributes = new ArrayList<String>();
		nodeAttributes.add("A");
		nodeAttributes.add("A-B2");
		nodeAttributes.add("A-C3");
		insertNode(graph, nodeAttributes);

		ArrayList<String> nodeAttributes2 = new ArrayList<String>();
		nodeAttributes2.add("B");
		nodeAttributes2.add("B-D4");
		nodeAttributes2.add("B-E1");
		insertNode(graph, nodeAttributes2);

		ArrayList<String> nodeAttributes3 = new ArrayList<String>();
		nodeAttributes3.add("D-I2");
		nodeAttributes3.add("I-J5");
		nodeAttributes3.add("I-F6");
		insertNode(graph, nodeAttributes3);

		ArrayList<String> nodeAttributes4 = new ArrayList<String>();
		nodeAttributes4.add("E");
		nodeAttributes4.add("E-F4");
		nodeAttributes4.add("E-G8");
		nodeAttributes4.add("E-H10");
		insertNode(graph, nodeAttributes4);
		
		System.out.println("============= GRAPH MOCKED =============");
		System.out.println("");
	}

	public ArrayList<String> insertNode(Graph graph, ArrayList<String> nodeAttributes) {
		ArrayList<String> output = new ArrayList<String>();
		for (String commandAttribute : nodeAttributes) {
			if (commandAttribute.length() == 1 && !graph.containsName(commandAttribute)) {
				Node node = new Node(commandAttribute);
				if (graph.addNode(node)) {
					String out = "Node " + commandAttribute + " added successfully to the graph.";
					output.add(out);
					System.out.println(out);
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
					String out = "Node " + node1.getName() + " added successfully to the graph.";
					output.add(out);
					System.out.println(out);
				}

				// SEARCHES IF THE SECOND NODE EXISTS ON THE GRAPH
				node2 = graph.searchNodeByName(term2);
				if (node2 == null) {
					// CREATES A NEW NODE IF NO NODE IS FOUND
					node2 = new Node(term2);
					String out = "Node " + node2.getName() + " added successfully to the graph.";
					output.add(out);
					System.out.println(out);
				}

				// DETECTS THE WEIGHT OF THE EDGE IF ENTERED
				int weight = 1;
				if (commandAttribute.length() > 3) {
					weight = Integer.valueOf(commandAttribute.substring(3));
				}
				
				// CREATES TWO NEW EDGES LINKING THOSE NODES FORWARDLY AND BACKWARDLY WITH BOTH DIRECTIONS (0) AND WEIGHT IF ANY
				Edge edge1 = new Edge(node1, node2, 0, weight);
				Edge edge2 = new Edge(node2, node1, 0, weight);

				// ADDS THOSE EDGES TO THE CORRESPONDING NODES
				node1.addEdge(edge1);
				node2.addEdge(edge2);

				// ADDS THE CREATED NODES TO THE GRAPH
				graph.addNode(node1);
				graph.addNode(node2);
			}
		}
		return output;
	}
}