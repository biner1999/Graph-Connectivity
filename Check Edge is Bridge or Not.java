import java.util.Scanner;
import java.util.LinkedList;
class Check_Remove_Edge_Grapg_Connectivity
{
	int v;
	LinkedList<Integer> adj[];
	Check_Remove_Edge_Grapg_Connectivity(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
		{

			adj[i]=new LinkedList<Integer>();
		}
	}
	void addEdge(int src,int dest)
	{
        adj[src].add(dest);
		adj[dest].add(src);
	}
	/*void removeEdge(int src,int dest)
	{
		adj[src].remove(dest);
		adj[dest].remove(src);
	}*/
	void checkUtil(int u,boolean visited[])
	{
		visited[u]=true;
		for(Integer i:adj[u])
		{
			if(!visited[i])
				checkUtil(i,visited);
		}
	}
	boolean check(int src,int dest)
	{
		//adj[src].remove(dest);
		//adj[dest].remove(src);
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++)
			visited[i]=false;
		checkUtil(0,visited);
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
				return false;
		}
		//addEdge(src,dest);
       return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Check_Remove_Edge_Grapg_Connectivity g=new Check_Remove_Edge_Grapg_Connectivity(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
			int src=sc.nextInt();
			int dest=sc.nextInt();
		//g.removeEdge(src,dest);
		if(g.check(src,dest))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
