import java.util.Scanner;
import java.util.LinkedList;
class BiConnected
{
	int v;
	int time=0;
	LinkedList<Integer> adj[];
	BiConnected(int v)
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
	boolean bcUtil(int u,boolean visited[],int low[],int parent[],int disk[])
	{
		int child=0;
		visited[u]=true;
		low[u]=disk[u]=++time;
		for(Integer i:adj[u])
		{
			if(!visited[i])
			{
				child++;
				parent[i]=u;
				if(bcUtil(i,visited,low,parent,disk))
					return true;
				low[u]=Math.min(low[i],low[u]);
				if(parent[u]==-1&&child>1)
					return true;
				if(parent[u]!=-1&&low[i]>=disk[u])
					return true;

			}
			else if(i!=parent[u])
				low[u]=Math.min(low[u],disk[i]);
		}
		return false;
	}
	boolean bc()
	{
		int low[]=new int[v];
		boolean visited[]=new boolean[v];
		int parent[]=new int[v];
		int disk[]=new int[v];
		for(int i=0;i<v;i++)
		{
			visited[i]=false;
			parent[i]=-1;
		}

		if(bcUtil(0,visited,low,parent,disk))
			return false;
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
				return false;
		}
		return true;

	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		BiConnected g=new BiConnected(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		if(g.bc())
			System.out.println("BiConnected");
		else
			System.out.println("Not BiConnected");
	}
	
}
