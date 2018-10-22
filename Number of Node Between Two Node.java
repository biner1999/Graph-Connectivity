import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
class Number_Of_Node_Between_Vertices
{
	int v;
	ArrayList<Integer> adj[];
	Number_Of_Node_Between_Vertices(int v)
	{
		this.v=v;
		adj=new ArrayList[v];
		for(int i=0;i<v;i++)
		{
			adj[i]=new ArrayList<>();
		}
	}
	void addEdge(int src,int dest)
	{
		adj[src].add(dest);
		adj[dest].add(src);
	}
	int node(int src,int dest)
	{
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++)
			 visited[i]=false;
	    Queue<Integer> q=new LinkedList<Integer>();
	    q.add(src);
	    int p[]=new int[v];
	    for(int i=0;i<v;i++)
	    	p[i]=0;
	    visited[src]=true;
	    while(!q.isEmpty())
	    {
	    	int u=q.poll();
	    	for(Integer i:adj[u])
	    	{
	    		if(!visited[i])
	    		{
	    			visited[i]=true;
	    			q.add(i);
	    			p[i]=u;
	    		}
	    	}

	    }
	    int c=-1;
	    while(src!=dest)
	    {
	    	c++;
	    	dest=p[dest];
	    }
	    return c;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Number_Of_Node_Between_Vertices g=new Number_Of_Node_Between_Vertices(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);

		}
		int src=sc.nextInt();
		int dest=sc.nextInt();
		System.out.println(g.node(src,dest));
	}
}
