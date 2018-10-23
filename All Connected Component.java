import java.util.Scanner;
import java.util.LinkedList;
class Connected_Component
{
	int v;
	LinkedList<Integer> adj[];
	Connected_Component(int v)
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
		System.out.print(u+" ");
		for(Integer i:adj[u])
		{
			if(!visited[i])
				dfsUtil(i,visited);
		}

	}
	void dfs()
	{
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++)
			visited[i]=false;
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
			{
				dfsUtil(i,visited);
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Connected_Component g=new Connected_Component(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		g.dfs();
	}
}
