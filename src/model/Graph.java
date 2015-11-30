package model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Graph {
	private List<Node> nodes = new ArrayList<Node>();
	private int dfsVisits = 1;
//	private int bfsVisits = 1;
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
		node.setPrevisit(dfsVisits);
		dfsVisits++;
		System.out.println("Reached Node " + node.getName() + " - previsit: " +  node.getPrevisit());
		for (Edge edge : node.getEdges()) {
			if (edge.getEndNode().isVisited() == false) {
				edge.getEndNode().setPrevisit(dfsVisits);
				executeDFS(graph, edge.getEndNode());
				edge.getEndNode().setPostvisit(dfsVisits);
			}
		}
		//		procedure DFS(G,v):
		//			2      label v as discovered
		//			3      for all edges from v to w in G.adjacentEdges(v) do
		//			4          if vertex w is not labeled as discovered then
		//			5              recursively call DFS(G,w)
	}

	// EXECUTES THE BREADTH FIRST SEARCH
	public void executeBFS(Graph graph, Node root) {

		for (Node n : graph.getNodes()) {
			n.setDistance(Integer.MAX_VALUE);
			n.setParent(null);

			root.setDistance(0);
			bfsQueue.offer(root);
			if (!root.isVisited()) {
				System.out.println("Enqueued Node " + root.getName() + " - distance: " +  root.getDistance());
				root.setVisited(true);
			}
		}
		while (!bfsQueue.isEmpty()) {
			Node current = bfsQueue.poll();
//			System.out.println("Dequeued Node " + current.getName() + " - distance: " +  current.getDistance());
			for (Edge n2 : current.getEdges()) {
				if (n2.getEndNode().getDistance() == Integer.MAX_VALUE) {
					n2.getEndNode().setDistance(current.getDistance() + 1);
					n2.getEndNode().setParent(current);
					bfsQueue.offer(n2.getEndNode());
					System.out.println("Enqueued Node " + n2.getEndNode().getName() + " - distance: " +  n2.getEndNode().getDistance());
				}
			}
		}

		//		Breadth-First-Search(Graph, root):
		//			 2 
		//			 3     for each node n in Graph:            
		//			 4         n.distance = INFINITY        
		//			 5         n.parent = NIL
		//			 6 
		//			 7     create empty queue Q      
		//			 8 
		//			 9     root.distance = 0
		//			10     Q.enqueue(root)                      
		//			11 
		//			12     while Q is not empty:        
		//			13     
		//			14         current = Q.dequeue()
		//			15     
		//			16         for each node n that is adjacent to current:
		//			17             if n.distance == INFINITY:
		//			18                 n.distance = current.distance + 1
		//			19                 n.parent = current
		//			20                 Q.enqueue(n)

		//		node.setVisited(true);
		//		node.setPrevisit(bfsVisits);
		//		bfsQueue.offer(node);
		//		bfsVisits++;
		//		System.out.println("Enqueued Node " + node.getName() + " - previsit: " +  node.getPrevisit());
		//		while(!bfsQueue.isEmpty()) {
		//			for (Edge edge : node.getEdges()) {
		//				if (edge.getEndNode().isVisited() == false) {
		////					executeBFS(graph, edge.getEndNode());
		//					edge.getEndNode().setVisited(true);
		//					edge.getEndNode().setPrevisit(bfsVisits);
		//					bfsQueue.add(edge.getEndNode()); 		// insira w em F
		//				} else {
		////					executeBFS(graph, edge.getEndNode());
		//				}
		//			}
		//			Node removedNode = bfsQueue.poll();
		//			if (removedNode != null)
		//				System.out.println("Removed Node " + removedNode.getName() + " - previsit: " +  removedNode.getPrevisit());
		//		}

		//		BuscaEmLargura
		//		   escolha uma raiz s de G
		//		   marque s
		//		   insira s em F
		//		   enquanto F nao esta vazia faca
		//		      seja v o primeiro vertice de F
		//		      para cada w pertence a listaDeAdjacencia de v faca
		//		         se w nao esta marcado entao
		//		            visite aresta entre v e w
		//		            marque w
		//		            insira w em F
		//		         senao se w pertence a F entao
		//		            visite aresta entre v e w
		//		         fim se
		//		      fim para
		//		      retira v de F
		//		   fim enquanto
	}

//	private boolean searchBfsQueueByName(String name) {
//		for (Node node : bfsQueue) {
//			if (node.getName().equalsIgnoreCase(name)) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	private boolean removeFromBfsQueueByName(String name) {
//		for (Node node : bfsQueue) {
//			if (node.getName().equalsIgnoreCase(name)) {
//				bfsQueue.remove(node);
//				return true;
//			}
//		}
//		return false;
//	}

}
