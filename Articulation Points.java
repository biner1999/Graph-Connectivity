import java.util.Scanner;
import java.util.LinkedList;
class Articulation_Points
{
	int v;
	LinkedList<Integer> adj[];
	int time=0;
	Articulation_Points(int v)
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
	void apUtil(int u,boolean visited[],int parent[],int low[],int disk[],boolean ap[])
	{
		visited[u]=true;
		int child=0;
		low[u]=disk[u]=++time;
		for(Integer i:adj[u])
		{
			if(!visited[i])
			{
				child++;
				parent[i]=u;
				apUtil(i,visited,parent,low,disk,ap);
				low[u]=Math.min(low[u],low[i]);
				if(parent[u]==-1&&child>1)
					ap[u]=true;
				if(parent[u]!=-1&&low[i]>=disk[u])
					ap[u]=true;

			}
			else if(i!=parent[u])
				low[u]=Math.min(low[u],disk[i]);
		}

	}
	void ap()
	{
		boolean visited[]=new boolean[v];
		int parent[]=new int[v];
		boolean ap[]=new boolean[v];
		int low[]=new int[v];
		int disk[]=new int[v];
		for(int i=0;i<v;i++)
		{
			visited[i]=false;
			parent[i]=-1;
			ap[i]=false;
		}
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
				apUtil(i,visited,parent,low,disk,ap);
		}
		System.out.println("Articulation Points");
		for(int i=0;i<v;i++)
		{  
           if(ap[i]==true)
           	 System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
     Articulation_Points g=new Articulation_Points(v);
     for(int i=1;i<=e;i++)
     {
     	int src=sc.nextInt();
     	int dest=sc.nextInt();
     	g.addEdge(src,dest);
     }		
     g.ap();
	}
	
}
