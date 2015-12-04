package algorithms;

import model.Graph;
import model.Node;

public interface Algorithm {
	public void execute(Graph graph, Node node);
	public void showResults();
}
