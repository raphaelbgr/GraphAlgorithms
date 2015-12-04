package algorithms.implementation;

import java.util.PriorityQueue;
import java.util.Queue;

import algorithms.Algorithm;
import model.Edge;
import model.Graph;
import model.Node;

public class BreadthFirstSearch implements Algorithm {
	
	private Queue<Node> bfsQueue = new PriorityQueue<Node>();

	@Override
	public void execute(Graph graph, Node root) {
		// EXECUTES THE BREADTH FIRST SEARCH
			for (Node n : graph.getNodes()) {
				n.setDistance(Integer.MAX_VALUE);
				n.setParent(null);

				root.setDistance(0);
				bfsQueue.offer(root);
				if (!root.isVisited()) {
					System.out.println("Reached Node " + root.getName() + " - distance: " +  root.getDistance());
					root.setVisited(true);
				}
			}
			while (!bfsQueue.isEmpty()) {
				Node current = bfsQueue.poll();
				for (Edge n2 : current.getEdges()) {
					if (n2.getEndNode().getDistance() == Integer.MAX_VALUE) {
						n2.getEndNode().setDistance(current.getDistance() + 1);
						n2.getEndNode().setParent(current);
						bfsQueue.offer(n2.getEndNode());
						System.out.println("Reached Node " + n2.getEndNode().getName() + " - distance: " +  n2.getEndNode().getDistance());
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
		}
	
	public BreadthFirstSearch() {
		System.out.println("============= START OF BREADTH FIRST SEARCH=============");
	}

	@Override
	public void showResults() {
		System.out.println("============= END OF BREADTH FIRST SEARCH =============");
	}
		
}
