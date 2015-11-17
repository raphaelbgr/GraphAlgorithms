package model;

import java.util.ArrayList;
import java.util.List;


public class Graph {
	private List<Node> nodes = new ArrayList<Node>();
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	public List<Node> getNodes() {
		return nodes;
	}
	public boolean containsName(Character name) {
		for(Node node : nodes) {
			if (node.getName() == name) {
				return true;
			}
		}
		return false;
	}
}
