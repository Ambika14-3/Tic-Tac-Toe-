import java.util.Scanner;


class test
{
	public static void main(String args[])
	{
		char []c = new char[3];
		if(c[1] == '\00')
			System.out.println("NULL");
		if(c[1] == '\0')
			System.out.println("NEXT");

		Scanner take_ip = new Scanner(System.in);
		int x,y;

		try 
		{
			do 
			{
				 x = take_ip.nextInt();

			}while(x <0);
		}
	
		catch(Throwable exc)
		{
			System.out.println("Caught");
			do 
			{
				 y = take_ip.nextInt();

			}while(y <0);

		}
	}
}