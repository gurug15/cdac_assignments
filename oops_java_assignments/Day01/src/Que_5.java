class Que_5 {
	
	private static void factorial(int n)
	{
		int fact = 1;
		for(int i=1;i<=n;i++)
		{
			fact =fact*i;
			System.out.print(fact+" ");
		}
	
	}

	public static void main(String[] args){
		int num = Integer.parseInt(args[0]);
		factorial(num);
	}

	
}
