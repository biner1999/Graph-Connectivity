import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Path_Between_Two_Vertices
{
	int v;
	LinkedList<Integer> adj[];
	Path_Between_Two_Vertices(int v)
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
	boolean isPath(int src,int dest)
	{
		if(src==dest)
			return true;
		Queue<Integer> q=new LinkedList<>();
		boolean visited[]=new boolean[v];
		q.add(src);
		visited[src]=true;
		while(!q.isEmpty())
		{
			int u=q.poll();
			for(Integer i:adj[u])
			{
				if(!visited[i])
				{
					visited[i]=true;
					q.add(i);
					if(i==dest)
						return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Path_Between_Two_Vertices g=new Path_Between_Two_Vertices(v);
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
