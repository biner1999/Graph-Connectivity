import java.util.Scanner;
class Bridge_Or_Not
{
	int v;
	int g[][];
	Bridge_Or_Not(int v)
	{
		this.v=v;
		g=new int[v][v];
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				g[i][j]=0;
			}
		}
	}
	void addEdge(int src,int dest)
	{
		g[src][dest]=1;
		g[dest][src]=1;
	}
	void removeEdge(int src,int dest)
	{
         g[src][dest]=0;
         g[dest][src]=0;
	}
	void checkUtil(int u,boolean visited[])
	{
       visited[u]=true;
       for(int i=0;i<v;i++)
       {
       	if(!visited[i]&&g[u][i]==1)
       		checkUtil(i,visited);
       }
	}
	boolean check()
	{
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++)
			visited[i]=false;
		checkUtil(0,visited);
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
		Bridge_Or_Not ob=new Bridge_Or_Not(v);
		for(int i=1;i<=e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			ob.addEdge(src,dest);
		}
			int src=sc.nextInt();
			int dest=sc.nextInt();
		ob.removeEdge(src,dest);
		if(ob.check())
			System.out.println("NO");
		else
			System.out.println("YES");
	}

}
