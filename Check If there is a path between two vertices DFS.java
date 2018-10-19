import java.util.Scanner;
import java.util.LinkedList;
class Path_Between_Two_Vertices_Dfs
{
	int v;
	LinkedList<Integer> adj[];
	Path_Between_Two_Vertices_Dfs(int v)
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
	boolean isPathUtil(int src,int dest,boolean visited[])
	{
		visited[src]=true;
		if(src==dest)
			return true;
		for(Integer i:adj[src])
		{
			if(!visited[i])
			{
				
				if(isPathUtil(i,dest,visited))
					return true;
			}
		}
		return false;
	}
	boolean isPath(int src,int dest)
	{
		boolean visited[]=new boolean[v];
		if(isPathUtil(src,dest,visited))
			return true;
		return false;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Path_Between_Two_Vertices_Dfs g=new Path_Between_Two_Vertices_Dfs(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			g.addEdge(src,dest);
		}
		int src=sc.nextInt();
		int dest=sc.nextInt();
		if(g.isPath(src,dest))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
