import java.util.Scanner;
import java.util.LinkedList;
class Strongly_Connected
{
int v;
LinkedList<Integer> adj[];
Strongly_Connected(int v)
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
}
void dfsUtil(int v,boolean visited[])
{
	visited[v]=true;
	for(Integer i:adj[v])
	{
		if(!visited[i])
			dfsUtil(i,visited);
	}
}
Strongly_Connected getTranspose()
{
	Strongly_Connected gr=new Strongly_Connected(v);
	for(int i=0;i<v;i++)
	{
		for(Integer j:adj[i])
		{
			gr.adj[j].add(i);
		}
	}
	return gr;
}

boolean isConnect()
{
	boolean visited[]=new boolean[v];
	for(int i=0;i<v;i++)
	{
		visited[i]=false;
	}
	dfsUtil(0,visited);
	for(int i=0;i<v;i++)
	{
		if(visited[i]==false)
			return false;
	}
	for(int i=0;i<v;i++)
	{
		visited[i]=false;
	}
	Strongly_Connected g=getTranspose();
	g.dfsUtil(0,visited);
	for(int i=0;i<v;i++)
	{
		if(visited[i]==false)
			return false;
	}
 return true;
}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int v=sc.nextInt();
	int e=sc.nextInt();
	Strongly_Connected graph=new Strongly_Connected(v);
	for(int i=1;i<=e;i++)
	{
		int src=sc.nextInt();
		int dest=sc.nextInt();
		graph.addEdge(src,dest);
	}
	if(graph.isConnect())
		System.out.println("YES");
	else
		System.out.println("NO");
}
	
}
