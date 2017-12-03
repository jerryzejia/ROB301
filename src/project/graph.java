package project;
import project.vertex;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class graph {
	int V = 25; 
	LinkedList<vertex>[] adj = new LinkedList[25]; 


	public graph (int num){
		V = num; 
		for (int i=0; i<num; ++i){
			adj[i] = new LinkedList<vertex>();
		}
	}	

	public int numVertices() {
		return V; 		
	}

	void addEdge(int v,vertex w)
	{
		adj[v].add(w);
	}

	public ArrayList<vertex> findpath(vertex v, vertex w, graph g) {
		Queue<vertex> q = new LinkedList<vertex>();
		boolean[] visited = new boolean[g.numVertices()];
		ArrayList<vertex> path = new ArrayList<vertex>();
		q.add(v);
		while(q.peek() != null) {
			bfsSearch(q.poll(),w,visited,q,path);
		}



		return path; 

	}

	public void bfsSearch(vertex s, vertex f, boolean[] visited,Queue<vertex> q, ArrayList<vertex> path){
		// Create a queue for BFS
		Queue<vertex> queue = new LinkedList<vertex>();
		// Mark the current node as visited and enqueue it
		visited[s.v]=true;
		queue.add(s);
		while (queue.size() != 0)
		{
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			Iterator<vertex> i = adj[s.v].listIterator();
			while (i.hasNext())
			{
				vertex n = i.next();
				if (!visited[n.v])
				{
					visited[n.v] = true;
					n.addParent(s); 
					queue.add(n);
				}
			}
		}
		vertex end = f; 
		while(end != null) {
			path.add(end);
			end = end.parent; 
		}
		Collections.reverse(path);

	}


    private static void printList(ArrayList<vertex> myList) {
        for (vertex ver: myList) {
            System.out.println(ver.v+1);
        }
    }
    
    
    private static void printdir(ArrayList<Integer> myList) {
        for (int i: myList) {
            System.out.println(i);
        }
    }

    
    
    
    
    private static ArrayList<Integer> finddir (ArrayList<vertex> path) {
        ArrayList<Integer> dirarr = new ArrayList<Integer>();
    	for (int i = 0; i < path.size()-1; i++) {
        	dirarr.add(path.get(i).dir[path.get(i+1).v]);   
        }
    	
    	
    	
		return dirarr;
    }



	public static void main(String[] args) {
		graph gir = new graph(25); 
		int[] dir= {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[5] = 3;
		vertex a = new vertex(0, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[2] = 2;
		dir[6] = 3;
		vertex b = new vertex(1, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[1] = 0;
		dir[3] = 2;
		vertex c = new vertex(2, dir);


		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[2] = 0;
		dir[4] = 2;
		vertex d = new vertex(3, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};	
		dir[3] = 0;
		dir[9] = 3;
		vertex e = new vertex(4, dir);


		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[0] = 1;
		dir[10] = 3;
		vertex f = new vertex(5, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[1] = 1;
		dir[11] = 3;
		vertex g = new vertex(6, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[8] = 2;
		dir[12] = 3;
		vertex h = new vertex(7, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[7] = 0;
		dir[9] = 2;
		vertex i = new vertex(8, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[4] = 1;
		dir[8] = 0;
		dir[14] = 3;		
		vertex j = new vertex(9, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[5] = 1;
		dir[11] = 2;
		vertex k = new vertex(10, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[6] = 1;
		dir[10] = 0;
		dir[16] = 3;
		vertex l = new vertex(11, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[7] = 1;
		dir[17] = 3;
		vertex m = new vertex(12, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[14] = 2;
		dir[18] = 3;
		vertex n = new vertex(13, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[9] = 1;
		dir[13] = 0;
		vertex o = new vertex(14, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[16] = 2;
		dir[20] = 3;
		vertex p = new vertex(15, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[11] = 1;
		dir[15] = 0;
		vertex q = new vertex(16, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[12] = 1;
		dir[22] = 3;
		vertex r = new vertex(17, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[13] = 1; 
		dir[23] = 3;
		vertex s = new vertex(18, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[24] = 3;
		vertex t = new vertex(19, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[15] = 1;
		dir[21] = 2;
		vertex u = new vertex(20, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[20] = 0;
		vertex v = new vertex(21, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[17] = 1;
		vertex w = new vertex(22, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[18] = 1;
		dir[24] = 2;
		vertex x = new vertex(23, dir);

		dir = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		dir[23] = 0;
		vertex y = new vertex(24, dir);
		gir.addEdge(0, f);

		gir.addEdge(1, c);
		gir.addEdge(1, g); 

		gir.addEdge(2, b);
		gir.addEdge(2, d);

		gir.addEdge(3, c);
		gir.addEdge(3, e); 

		gir.addEdge(4, d);
		gir.addEdge(4, j);

		gir.addEdge(5, a);
		gir.addEdge(5, k);

		gir.addEdge(6, b);
		gir.addEdge(6, l);

		gir.addEdge(7, i);
		gir.addEdge(7, m);

		gir.addEdge(8, h);
		gir.addEdge(8, j);

		gir.addEdge(9, e);
		gir.addEdge(9, i);
		gir.addEdge(9, o);

		gir.addEdge(10, f);
		gir.addEdge(10, l);

		gir.addEdge(11, g);
		gir.addEdge(11, k);
		gir.addEdge(11, q);

		gir.addEdge(12, h);
		gir.addEdge(12, r);

		gir.addEdge(13, o);
		gir.addEdge(13, s);

		gir.addEdge(14, j);
		gir.addEdge(14, n);

		gir.addEdge(15, q);
		gir.addEdge(15, u);

		gir.addEdge(16, l);
		gir.addEdge(16, p);

		gir.addEdge(17, m);
		gir.addEdge(17, w);

		gir.addEdge(18, n);
		gir.addEdge(18, x);

		gir.addEdge(19, y);

		gir.addEdge(20, p);
		gir.addEdge(20, v);

		gir.addEdge(21, u);

		gir.addEdge(22, r);

		gir.addEdge(23, s);
		gir.addEdge(23, y);

		gir.addEdge(24, x);
		gir.addEdge(24, u);
		//gir.printList(gir.findpath(a, w, gir));
		gir.printdir(finddir(gir.findpath(a, v, gir)));



	}
}
