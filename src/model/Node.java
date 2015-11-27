package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Node {
	private boolean visited;
	private int previsit;
	private int postvisit;
	private String name;
	private List<Edge> edges;
	
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Node(String name, Collection<? extends Edge> edges) {
		super();
		this.name = name;
		if (edges != null) {
			this.edges = new ArrayList<Edge>();
		}
		this.edges.addAll(edges);
	}
	
	public Node(String name, Edge edge) {
		super();
		this.name = name;
		if (edges != null) {
			this.edges = new ArrayList<Edge>();
		}
		this.edges.add(edge);
	}
	
	public Node(String name) {
		super();
		this.name = name;
	}
	
	public int getPrevisit() {
		return previsit;
	}
	public void setPrevisit(int previsit) {
		this.previsit = previsit;
	}
	public int getPostvisit() {
		return postvisit;
	}
	public void setPostvisit(int postvisit) {
		this.postvisit = postvisit;
	}
	public Node getExistingOrCreateNode(Graph graph, String name) {
		Node node = graph.searchNodeByName(name);
		if (node != null) {
			return node;
		} else return new Node(name);
	}
	public void addEdge(Edge edge) {
		if (edges == null) {
			edges = new ArrayList<Edge>();
		}
		this.edges.add(edge);
	}
}
