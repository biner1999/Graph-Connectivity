
//Number of loops of size k starting from a specific node
import java.util.Scanner;
class Number_Of_Loop
{
	static int loop(int n,int k)
	{
          int p=1;
          if(k%2==1)
          	p=-1;
          return (int)((Math.pow(n-1,k)+(p*(n-1)))/n);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		System.out.println(loop(n,k));
	}
}
