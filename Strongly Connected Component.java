import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
class Strongly_Connected_Componenet
{
	int v;
	LinkedList<Integer> adj[];
	Stack<Integer> st;
	Strongly_Connected_Componenet(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		st=new Stack<Integer>();
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList<>();
		}
	}
	void addEdge(int src,int dest)
	{
		adj[src].add(dest);
		
	}
	Strongly_Connected_Componenet transPose()
	{
		Strongly_Connected_Componenet gr=new Strongly_Connected_Componenet(v);
		for(int i=0;i<v;i++)
		{
			for(Integer j:adj[i])
			{
				gr.adj[j].add(i);
			}
		}
		return gr;
	}
	void dfsUtil(int i,boolean visited[])
	{
		visited[i]=true;
		st.push(i);
		for(Integer j:adj[i])
		{
			if(!visited[j])
				dfsUtil(j,visited);
		}
        
	}
	void prinntDfs(int i,boolean visited[])
	{
		visited[i]=true;
		System.out.print(i+" ");
		for(Integer j:adj[i])
		{
			if(!visited[j])
				prinntDfs(j,visited);
		}
	}
	void printComponent()
	{
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++)
		{
			visited[i]=false;
		}
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
		   dfsUtil(i,visited);
		}
		Strongly_Connected_Componenet g=new Strongly_Connected_Componenet(v);
		g=transPose();
		for(int i=0;i<v;i++)
		{
			visited[i]=false;
		}
		while(!st.isEmpty())
		{
			int i=st.pop();
			if(!visited[i])
			{
				System.out.println();
				prinntDfs(i,visited);
				
			}
		}

	}
	
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int v=sc.nextInt();
	int e=sc.nextInt();
	Strongly_Connected_Componenet graph=new Strongly_Connected_Componenet(v);
	for(int i=1;i<=e;i++)
	{
		int src=sc.nextInt();
		int dest=sc.nextInt();
		graph.addEdge(src,dest);
	}
	graph.printComponent();
}
	
}
