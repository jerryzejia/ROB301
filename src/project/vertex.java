package project;

public class vertex {
	int v; 
	int [] dir;	
	vertex parent; 
	
	public vertex (int v, int[] dir) {
		this.v = v;
		this.dir = dir; 
		parent = null; 
	}
	
	public void addParent(vertex p) {
		parent = p; 
	}

	
	
	
}
