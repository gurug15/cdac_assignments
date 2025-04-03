import java.util.Scanner;


class Que_3
{
	
	
	public static double simp_interest(double p,double r,double t)
	{
		return (p*r*t)/100;
	}
	
	public static double comp_interest(double p,double r,double t)
	{
		return p*Math.pow(1+r/100,t)-p;
	}
		
		public static void main(String[] args)
		{
			Scanner in=new Scanner(System.in);
			
			System.out.print("Principal amount (the initial amount of money)");
			double p=in.nextDouble();
			
			System.out.print("\nRate of interest (per annum)");
			double r=in.nextDouble();
			
			System.out.print("\nTime period (in years)");
			double t=in.nextDouble();
			
			System.out.print("Simple Interest:"+simp_interest(p,r,t));
			System.out.print("\nCompound Interest:"+Math.round(comp_interest(p,r,t)));
			
			
			
		}

}