import java.util.Scanner;
import java.util.LinkedList;
class NumberOfGroup
{
	int v,y=0;
	LinkedList<Integer> adj[];
	NumberOfGroup(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		for(int i=1;i<v;i++)
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
		y++;
		for(Integer i:adj[u])
		{
			if(!visited[i])
				dfsUtil(i,visited);
		}
	}
	void dfs()
	{
		boolean visited[]=new boolean[v];
		int c=0,g=1;
		for(int i=1;i<v;i++)
		{
			if(!visited[i])
			{
				c++;
				dfsUtil(i,visited);
				g=g*y;
				y=0;
			}
		}
		System.out.println("Number of Exist Group="+c+"\nNumber of New Group Can be formed="+g);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		NumberOfGroup graph=new NumberOfGroup(v+1);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			graph.addEdge(src,dest);
		}
		graph.dfs();
	}
}
