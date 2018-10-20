import java.util.Scanner;
import java.util.LinkedList;
class Eulerian_Graph
{
	int v;
	LinkedList<Integer> adj[];
	Eulerian_Graph(int v)
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
	boolean eulerian()
	{
		int od=0,ev=0;
		for(int i=0;i<v;i++)
		{
              for(Integer j:adj[i])
              {
              	ev++;
              }
              if(ev%2!=0)
              	od++;
              ev=0;
		}
		if(od>2)
			return false;

		return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Eulerian_Graph g=new Eulerian_Graph(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		if(g.eulerian())
			System.out.println("Eulerian Graph");
		else
			System.out.println("Not Eulerian Graph");
	}

}
