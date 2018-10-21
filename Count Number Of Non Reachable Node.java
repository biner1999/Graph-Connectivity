import java.util.Scanner;
import java.util.LinkedList;
class NonReachable_Node
{
	int v;
	LinkedList<Integer> adj[];
	NonReachable_Node(int v)
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
	void dfs(int i,boolean visited[])
	{
		visited[i]=true;
		for(Integer j:adj[i])
		{
			if(!visited[j])
				dfs(j,visited);
		}

	}
	void count(int k)
	{
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++)
			visited[i]=false;
		dfs(k,visited);
		int c=0;
		for(int i=0;i<v;i++)
		{
			if(visited[i]==false)
				c++;
		}
		System.out.println(c);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		NonReachable_Node g=new NonReachable_Node(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		int k=sc.nextInt();
		g.count(k);
	}
	
}
