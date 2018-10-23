import java.util.Scanner;
import java.util.LinkedList;
class Rechable_Node
{
	int v;
	LinkedList<Integer> adj[];
	Rechable_Node(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList<>();
		}
	}
	void addEdge(int src,int dest)
	{
		adj[src].add(dest);
		adj[dest].add(src);
	}
	void dfsUtil(int u,boolean visited[])
	{
		visited[u]=true;
		for(Integer i:adj[u])
		{
			if(!visited[i])
				dfsUtil(i,visited);
		}
	}
	void dfs()
	{
	   for(int i=0;i<v;i++)
	   {
	   	boolean visited[]=new boolean[v];
	   	dfsUtil(i,visited);
	   	for(int j=0;j<v;j++)
	   	{
	   		if(visited[j])
	   			System.out.print(j+" ");
	   	}
	   	System.out.println();
	   }
	}
  public static void main(String[] args) {
  	Scanner sc=new Scanner(System.in);
  	int v=sc.nextInt();
  	int e=sc.nextInt();
  	Rechable_Node g=new Rechable_Node(v);
  	for(int i=1;i<=e;i++)
  	{
  		int src=sc.nextInt();
  		int dest=sc.nextInt();
  		g.addEdge(src,dest);
  	}
  g.dfs();
  }
}
