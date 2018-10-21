import java.util.Scanner;
class Transitive_Closure_FloydWarshall
{
int v;
int g[][];
Transitive_Closure_FloydWarshall(int v)
{
this.v=v;
g=new int[v][v];

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
	g[src][dest]=1;
}
void soluTion()
{
	int sol[][]=new int[v][v];
	int i,j,k;
	for(i=0;i<v;i++)
	{
		for(j=0;j<v;j++)
		{
			sol[i][j]=g[i][j];
		}
	}
	for(k=0;k<v;k++)
	{
		for(i=0;i<v;i++)
		{
			for(j=0;j<v;j++)
			{
				sol[i][j]=(sol[i][j]!=0)||((sol[i][k]!=0)&&(sol[k][j])!=0)?1:0;
			}
		}
	}
	for(i=0;i<v;i++)
	{
		for(j=0;j<v;j++)
		{
			System.out.print(sol[i][j]+" ");
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
