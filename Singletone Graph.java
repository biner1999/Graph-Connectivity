import java.util.Scanner;
import java.util.LinkedList;
class Singletone_Graph
{
int v;
LinkedList<Integer> adj[];
Singletone_Graph(int v)
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
int count()
{
	int c=0;
	for(int i=1;i<v;i++)
	{
		if(adj[i].size()==0)
          c++;
	}
	return c;
}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int v=sc.nextInt();
	int e=sc.nextInt();
	Singletone_Graph g=new Singletone_Graph(v+1);
	for(int i=1;i<=e;i++)
	{
		int src=sc.nextInt();
		int dest=sc.nextInt();
		g.addEdge(src,dest);
	}
	System.out.println(g.count());
}

	
}
