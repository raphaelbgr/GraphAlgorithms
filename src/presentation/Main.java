package presentation;

import algorithms.Algorithm;
import algorithms.implementation.BreadthFirstSearch;
import algorithms.implementation.DephFirstSearch;
import algorithms.implementation.Dijkstra;
import mockers.GraphMocker;
import model.Graph;

public class Main {

	public static void main(String [] args) {
		
		GraphMocker mocker = new GraphMocker();
		Graph graph = null;
		Algorithm algorithm = null;
		
		// MOCK THE GRAPH
		graph = mocker.createMockedGraph();
		
		algorithm = new DephFirstSearch();
		algorithm.execute(graph, graph.getNodes().get(0));
		algorithm.showResults();
		
		// RE-MOCKS THE GRAPH
		graph = mocker.createMockedGraph();
		
		algorithm = new BreadthFirstSearch();
		algorithm.execute(graph, graph.getNodes().get(0));
		algorithm.showResults();
		
		// RE-MOCKS THE GRAPH
		graph = mocker.createMockedGraph();
		
		algorithm = new Dijkstra();
		algorithm.execute(graph, graph.getNodes().get(0));
		algorithm.showResults();
	}
	
}
