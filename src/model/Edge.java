package model;

public class Edge {
	private Node start;
	private Node end;
	private int direction; // 0 = two way, 1 - one way, 2 - reverse
	
	public Edge(Node start, Node end, int direction) {
		super();
		this.start = start;
		this.end = end;
		this.direction = direction;
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
	
	
}
