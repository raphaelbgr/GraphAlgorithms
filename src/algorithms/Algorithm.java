package algorithms;

import java.util.ArrayList;

import model.Graph;
import model.Node;

public interface Algorithm {
	public void execute(Graph graph, Node node);
	public ArrayList<String> showResults();
}
