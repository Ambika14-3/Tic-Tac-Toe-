import java.util.Scanner;



class Player
{
	String name;
	char symbol;

	Player(String name, char symbol)
	{
		this.name = name;
		this.symbol = symbol;
	}
}






class Table
{
	char array[][] = new char[3][3];
	Player currentPlayer;

	Table()
	{
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				array[i][j] =  ' ';
			}
		}
	}

	void gameON(Player p)
	{
		currentPlayer = p;
		Scanner take_ip = new Scanner(System.in);
		int x,y,flag;flag = 0;
		while(flag == 0)
	      {
		try 
		{
			do
			{
				System.out.println("Player: " + p.name + " Symbol: " + p.symbol);
				System.out.print("Enter the position in the table: ");
		
				x = take_ip.nextInt();
				y = take_ip.nextInt();	

			} while (notVacant(x-1,y-1));
		
			array[x-1][y-1] = p.symbol; flag = 1;
		}
		
		

		catch(Throwable exc)
		{
			System.out.println("Enter a valid position within (1,1) to (3,3)");
		}	
		
	     }		
	}


	boolean notVacant(int x, int y)
	{
		boolean value = false;

		if(array[x][y] != ' ')
		{
			value = true;
			System.out.println("Not vacant, please try for some different place");
		}

		return value;
	}


	void show_Table()
	{
		for(char []a: array)
		{
			for(char b : a)
			{
				System.out.print("|" + b + "|"); 
			}
			
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}


	boolean anyone_win()
	{

		boolean answer = false;   // NO ONE WON

		testTable test = new testTable(array);   // PASS TABLE AS AN OBJECT TO TEST IT


		if(test.diagonal1() || test.diagonal2() || test.horizontal() || test.vertical() )
		{
			answer = true;
		}

		if(answer == true)           // CURRENT PLAYER HAS WON THE GAME
		{
			System.out.println(currentPlayer.name + " with symbol " + currentPlayer.symbol + " wins the game"); 
		}
		
		return answer;
		
	}


	boolean tableFilled()
	{
		boolean filled = true;

		for(int x = 0; x<3; x++)
		{
			for(int y = 0; y<3; y++)
			{
				if(array[x][y] == ' ')
				{
					filled = false;
					break;
				}
			}
		}
		
		if(filled)
			System.out.println("Table is filled! It's a draw");

		return filled;
	}
}





class TicTacToe
{
	public static void main(String args[])
	{
		Player P1 = new Player("P1",'X');
		Player P2 = new Player("P2",'O');

		Table ttt = new Table();
		ttt.show_Table();
		
		while(1>0)
		{
			
			ttt.gameON(P1);
			ttt.show_Table();
			if(ttt.anyone_win() || ttt.tableFilled())
				break;

			ttt.gameON(P2);
			ttt.show_Table();
			if(ttt.anyone_win() || ttt.tableFilled())
				break;
		}
	}
}