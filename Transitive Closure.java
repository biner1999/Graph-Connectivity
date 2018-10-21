import java.util.Scanner;
import java.util.LinkedList;
class Transitive_Closure
{
int v;
int g[][];
LinkedList<Integer> adj[];
Transitive_Closure(int v)
{
this.v=v;
adj=new LinkedList[v];
g=new int[v][v];
for(int i=0;i<v;i++)
{
	adj[i]=new LinkedList<>();
}
for(int i=0;i<v;i++)
{
	for(int j=0;j<v;j++)
	{
		if(i==j)
			g[i][j]=1;
		else
			g[i][j]=0;
	}
}
}
void addEdge(int src,int dest)
{
	adj[src].add(dest);
}
boolean dfs(int src,int dest,boolean visited[])
{
	if(src==dest)
		return true;
	visited[src]=true;
	for(Integer i:adj[src])
	{
		if(!visited[i])
			if(dfs(i,dest,visited))
				return true;
	}
	return false;
}
void soluTion()
{
	//boolean visited[]=new boolean[v];
	for(int i=0;i<v;i++)
	{
		for(int j=0;j<v;j++)
		{
			if(i!=j)
			{
				boolean visited[]=new boolean[v];

				if(dfs(i,j,visited))
					g[i][j]=1;

			}
		}
	}
	for(int i=0;i<v;i++)
	{
		for(int j=0;j<v;j++)
		{
			System.out.print(g[i][j]+" ");
		}
		System.out.println();
	}
}

public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int v=sc.nextInt();
	int e=sc.nextInt();
	Transitive_Closure graph=new Transitive_Closure(v);
	for(int i=1;i<=e;i++)
	{
       int src=sc.nextInt();
       int dest=sc.nextInt();
       graph.addEdge(src,dest);
	}
	graph.soluTion();
}
	
}
