import java.util.Scanner;
import java.util.LinkedList;
class Dynamic_Connectivity
{
  int v;
  LinkedList<Integer> adj[];
  Dynamic_Connectivity(int v)
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
  boolean checkUtil(int src,int dest,boolean visited[])
  {
   visited[src]=true;
    if(src==dest)
   		  	return true;
   for(Integer i:adj[src])
   {
   	if(!visited[i])
   	{
   		if(checkUtil(i,dest,visited))
   			return true;

   	}
   }
   return false;

  }
 boolean check(int src,int dest)
 {
 	boolean visited[]=new boolean[v];
 	for(int i=0;i<v;i++)
 		visited[i]=false;
 	if(checkUtil(src,dest,visited))
 		return true;
 	return false;
 }
 public static void main(String[] args) {
 	Scanner sc=new Scanner(System.in);
 	int v=sc.nextInt();
 	int e=sc.nextInt();
 	Dynamic_Connectivity g=new Dynamic_Connectivity(v);

 	while(e-->0)
 	{
 		int a,b,c;
 		a=sc.nextInt();
 		b=sc.nextInt();
 		c=sc.nextInt();
       if(a==1)
       {
       	if(g.check(b,c))
       		System.out.println("Yes");
       	else
       		System.out.println("No");

       }
       else
       {
       	g.addEdge(b,c);
       }

 	}
 }
}
