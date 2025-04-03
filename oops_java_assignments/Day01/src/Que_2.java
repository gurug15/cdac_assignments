import java.util.Scanner;

class Que_2
{
	public static double add(double a,double b)
	{
		return a+b;
	}
	
	public static double sub(double a,double b)
	{
		return a-b;
	}
	
	public static double mul(double a,double b)
	{
		return a*b;
	}
	
	public static  double div(double a,double b)
	{
		return (double)a/b;
	}
	
	public static void main(String[] args)
	{	
	Scanner in =new Scanner(System.in);
		System.out.print("Enter Your Two Numbers");
		double a=in.nextInt();
		double b=in.nextInt();

	System.out.print("Enter Your Choice\n1)Add\n2)Sub\n3)mul\n4)div\n");
	int ch=in.nextInt();
	
	switch(ch)
	{
		case 1:
		System.out.print("Addition:"+add(a,b));
		break;
		case 2:
		System.out.print("\nSubstraction:"+sub(a,b));
		break;
		case 3:
		System.out.print("\nMultiplication:"+mul(a,b));
		break;
		case 4:
		System.out.print("\nDivision:"+div(a,b));
		break;
		default:
		System.out.print("\n Option is Incorrect:");
		
	}
}
}