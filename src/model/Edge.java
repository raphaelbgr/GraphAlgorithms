package model;

public class Edge {
	private Node start;
	private Node end;
	private int direction; // 0 = two way, 1 - one way, 2 - reverse
	private int weight = 1; // Default minimum value
	
	public Edge(Node start, Node end, int direction, int weight) {
		super();
		this.start = start;
		this.end = end;
		this.direction = direction;
		this.weight = weight;
	}
	
	public Node getStart() {
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}

	public Node getEndNode() {
		return end;
	}

	public void setEnd(Node end) {
		this.end = end;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
