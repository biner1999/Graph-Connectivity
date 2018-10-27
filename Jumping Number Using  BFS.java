

import java.io.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
class Jumping_Number {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		printNumber(n);
	}
	static void printNumber(int n)
	{
	    System.out.print("0"+" ");
	    for(int i=1;i<=9&&i<=n;i++)
	      bfs(n,i);
	}
	static void bfs(int n,int num)
	{
	    Queue<Integer> q=new LinkedList<>();
	    q.add(num);
	    while(!q.isEmpty())
	    {
	        num=q.poll();
	        if(num<=n)
	        {
	            System.out.print(num+" ");
	            int lastDigit=num%10;
	            if(lastDigit==0)
	             q.add((num*10)+(lastDigit+1));
	            else if(lastDigit==9)
	            q.add((num*10)+(lastDigit-1));
	            else
	            {
	                q.add((num*10)+(lastDigit-1));
	                q.add((num*10)+(lastDigit+1));
	            }
	        }
	    }
	}
}
