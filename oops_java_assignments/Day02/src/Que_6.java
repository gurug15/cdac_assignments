class Que_6{
	
	
	static void  RevPyrad(int n)
	{
		for(int i=0;i<=n;i++)
		{
			for(int j=n;j>=i;j--)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	static void  pyrad(int n)
	{
		for(int i=0;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	static void revCrown(int n)
	{
		int spaces = 0;
		for(int i=0;i<n;i++)
		{
			
			for(int j=0;j<n-i;j++)
			{
				System.out.print("* ");
			}
			for(int k=1;k<spaces;k++)
			{
				System.out.print("  ");
			}
			for(int j=0;j<n-i;j++)
			{
				if (i == 0 && j == n - 1) continue;
				System.out.print("* ");
			}
			System.out.println();
			if(spaces>n){
				spaces-=2;
			}
			else{
				spaces+=2;
			}
		}
	}
	
	
	public static void main(String []args)
	{
	 revCrown(4);
	
	}
}
