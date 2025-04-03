class Que_5{
	
	
	public static void gradeAllot(int n)
	{
		if(n<60)
		{
		  if(n>50){
			  System.out.println("Second class");
		  }else
		  {
			  System.out.println("pass class");
		  }
		}
		else{
			if(n<75)
			{
				System.out.println("First calss");
			}
			else{
				System.out.println("Distinct class");
			}
		}	
	}
	
	
	public static void main(String[] args)
	{
		
		gradeAllot(Integer.parseInt(args[0]));
		
		
	}
	
	
}