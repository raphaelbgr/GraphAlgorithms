package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Node {
	private boolean visited;
	private int previsit;
	private int postvisit;
	private char name;
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
	public char getName() {
		return name;
	}
	public void setName(char name) {
		this.name = name;
	}
	
	public Node(char name, Collection<? extends Edge> edges) {
		super();
		this.name = name;
		this.edges = new ArrayList<Edge>();
		if (edges != null) {
			this.edges.addAll(edges);
		}
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
	
//	public Node() {
//		super();
//	}
}
