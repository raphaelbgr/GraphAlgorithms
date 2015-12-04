package algorithms.implementation;

import java.util.ArrayList;

import algorithms.Algorithm;
import model.Edge;
import model.Graph;
import model.Node;

public class DephFirstSearch  implements Algorithm {

	private int dfsVisits = 1;
	private ArrayList<String> output = new ArrayList<String>();

	@Override
	public void execute(Graph graph, Node node) {
		// EXECUTES THE DETH FIRST SEARCH ALGORITHM
		node.setVisited(true);
		node.setPrevisit(dfsVisits);
		dfsVisits++;
//		log("Reached Node " + node.getName() + " - previsit: " +  node.getPrevisit());
		for (Edge edge : node.getEdges()) {
			if (edge.getEndNode().isVisited() == false) {
				log("Reached Node " + edge.getStart().getName() + "->" + edge.getEndNode().getName() + " - previsit: " +  node.getPrevisit());
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
		log("============= START OF DEPH FIRST SEARCH =============");
	}

	@Override
	public ArrayList<String> showResults() {
		log("============= END OF DEPH FIRST SEARCH =============");
		return output;
	}

	private void log(String string) {
		output.add(string);
		System.out.println(string);
	}
}
