import java.util.Scanner;
import java.util.LinkedList;
class Bridge
{
	int v;
	int time=0;
	LinkedList<Integer> adj[];
	Bridge(int v)
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
	void bcUtil(int u,boolean visited[],int low[],int parent[],int disk[])
	{
		
		visited[u]=true;
		low[u]=disk[u]=++time;
		for(Integer i:adj[u])
		{
			if(!visited[i])
			{
				
				parent[i]=u;
				bcUtil(i,visited,low,parent,disk);
					
				low[u]=Math.min(low[i],low[u]);
		         if(low[i]>disk[u])
		         	System.out.println(u+"-->"+i);
			}
			else if(i!=parent[u])
				low[u]=Math.min(low[u],disk[i]);
		}
		
	}
	void bc()
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
         for(int i=0;i<v;i++)
		{
			if(!visited[i])
			    bcUtil(i,visited,low,parent,disk);
		}
		

	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Bridge g=new Bridge(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		g.bc();
	}
	
}
