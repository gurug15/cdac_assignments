
class Que_4 {
	
	public static int digitSum(int n)
	{
		int sum =0;
		while(n>0)
		{
			sum = sum + n%10;
			n=n/10;
		}
		
		return sum;
	}
	
	private static int digitSumRec(int n)
	{
		if(n<=0){
			return 0;
		}
		
		
		return n%10 + digitSumRec(n/10);
	
	}
	
	

	public static void main(String[] args){
		System.out.println("sum is: "+digitSumRec(Integer.parseInt(args[0])));
		
	}

	
}
