package model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Graph {
	private List<Node> nodes = new ArrayList<Node>();
	private int visits = 1;
	private Queue<Node> bfsQueue = new PriorityQueue<Node>();
	
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
			if (edge.getEndNode().isVisited() == false) {
				edge.getEndNode().setPrevisit(visits);
				executeDFS(graph, edge.getEndNode());
				edge.getEndNode().setPostvisit(visits);
			}
		}
		visits = 1;
		
		//		procedure DFS(G,v):
		//			2      label v as discovered
		//			3      for all edges from v to w in G.adjacentEdges(v) do
		//			4          if vertex w is not labeled as discovered then
		//			5              recursively call DFS(G,w)
	}
	
	// EXECUTES THE BREADTH FIRST SEARCH
	public void executeBFS(Graph graph, Node node) {
		node.setVisited(true);
		node.setPrevisit(visits);
		bfsQueue.add(node);
		visits++;
		System.out.println("Node " + node.getName() + " - previsit: " +  node.getPrevisit());
		while(!bfsQueue.isEmpty()) {
			for (Edge edge : node.getEdges()) {
				outerReference = edge;
				if (edge.getEndNode().isVisited() == false) {
					edge.getEndNode().setPrevisit(visits);
					executeDFS(graph, edge.getEndNode());
					edge.getEndNode().setPostvisit(visits);
					bfsQueue.add(edge.getEndNode()); // insira w em F
				} else if (searchBfsQueueByName(edge.getEndNode().getName())) {
					executeBFS(graph, edge.getEndNode());
				}
			}
			bfsQueue.poll(outerReference.getEndNode());
		}
		
//		BuscaEmLargura
//		   escolha uma raiz s de G
//		   marque s
//		   insira s em F
//		   enquanto F não está vazia faça
//		      seja v o primeiro vértice de F
//		      para cada w ∈ listaDeAdjacência de v faça
//		         se w não está marcado então
//		            visite aresta entre v e w
//		            marque w
//		            insira w em F
//		         senao se w ∈ F entao
//		            visite aresta entre v e w
//		         fim se
//		      fim para
//		      retira v de F
//		   fim enquanto
	}
	
	private boolean searchBfsQueueByName(String name) {
		for (Node node : bfsQueue) {
			if (node.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean removeFromBfsQueueByName(String name) {
		for (Node node : bfsQueue) {
			if (node.getName().equalsIgnoreCase(name)) {
				bfsQueue.remove(node);
				return true;
			}
		}
		return false;
	}

}
