package algorithms.implementation;

import algorithms.Algorithm;
import model.Edge;
import model.Graph;
import model.Node;

public class DephFirstSearch  implements Algorithm {

	private int dfsVisits = 1;

	@Override
	public void execute(Graph graph, Node node) {
		// EXECUTES THE DETH FIRST SEARCH ALGORITHM
		node.setVisited(true);
		node.setPrevisit(dfsVisits);
		dfsVisits++;
		System.out.println("Reached Node " + node.getName() + " - previsit: " +  node.getPrevisit());
		for (Edge edge : node.getEdges()) {
			if (edge.getEndNode().isVisited() == false) {
				edge.getEndNode().setPrevisit(dfsVisits);
				execute(graph, edge.getEndNode());
				edge.getEndNode().setPostvisit(dfsVisits);
			}
		}
		//		procedure DFS(G,v):
		//			2      label v as discovered
		//			3      for all edges from v to w in G.adjacentEdges(v) do
		//			4          if vertex w is not labeled as discovered then
		//			5              recursively call DFS(G,w)

	}
	
	public DephFirstSearch() {
		System.out.println("============= START OF DEPH FIRST SEARCH =============");
	}

	@Override
	public void showResults() {
		System.out.println("============= END OF DEPH FIRST SEARCH =============");
	}
}
