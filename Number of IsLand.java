import java.util.Scanner;
class Number_Of_Island
{
	int row;
	int col;
	static int g[][];
	Number_Of_Island(int row,int col)
	{
		this.row=row;
		this.col=col;
		g=new int[row][col];

	}
	boolean isSafe(int i,int j,boolean visited[][])
	{
		
			
		return (i>=0&&i<row&&j>=0&&j<col&&g[i][j]==1&&!visited[i][j]);
	}
	void dfs(int i,int j,boolean visited[][])
	{
		int x[]={-1,-1,-1,0,0,1,1,1};
		int y[]={-1,0,1,-1,1,-1,0,1};
		visited[i][j]=true;
		for(int k=0;k<8;k++)
			if(isSafe(i+x[k],j+y[k],visited))
				dfs(i+x[k],j+y[k],visited);

		
	}
	int island()
	{
		int c=0;
		boolean visited[][]=new boolean[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(g[i][j]==1&&visited[i][j]==false)
				{
					
					dfs(i,j,visited);
					c++;
				}
			}
		}
		return c;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int row=sc.nextInt();
		int col=sc.nextInt();
		Number_Of_Island ob=new Number_Of_Island(row,col);
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				g[i][j]=sc.nextInt();
			}
		}
		System.out.println(ob.island());

	}
	
}
