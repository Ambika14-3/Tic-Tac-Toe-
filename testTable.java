class testTable
{

	char array[][] = new char[3][3];


	testTable (char[][] array)
	{
		this.array = array;
	}


	boolean diagonal1() 
	{
		boolean diagonally_yes = true;
		
		char current = array[0][0];
		char previous = array[0][0];

		for(int x = 0; x<3; x++)
		{
			current = array[x][x];
			if( ((previous == ' ') && (current == ' ')) || (previous != current))
			{
				diagonally_yes = false;
				break;
			}
			previous = current;
		}

			return diagonally_yes;
	}



	boolean diagonal2()
	{
		boolean diagonally_yes = true;
		
		char current = array[0][2];
		char previous = array[0][2];

		for(int x = 0; x<3; x++)
		{
			current = array[x][2-x];
			if( ((previous == ' ') && (current == ' ')) || (previous != current))
			{
				diagonally_yes = false;
				break;
			}
			previous = current;
		}


		return diagonally_yes;
	}



	boolean horizontal()
	{

		boolean horizontally_yes = true;
		boolean end_of_row;

		char current;
		char previous;

		for(int x = 0; x<3; x++)
		{
			current = array[x][0];
			previous = array[x][0];
			end_of_row = true;

			for(int y = 0; y<3; y++)
			{
				current = array[x][y];
				if(((previous == ' ') && (current == ' ')) || (previous != current))
				{
					end_of_row = false;
					horizontally_yes = false;
					break;
				}
				previous = current;
			}

			if(end_of_row == true)
			{
				horizontally_yes = true;
				break;
			}
		}


		return horizontally_yes;		
	}


	boolean vertical()
	{

		boolean vertically_yes = true;
		boolean end_of_column = true;

		char current;
		char previous;

		for(int x = 0; x<3; x++)
		{
			current = array[0][x];
			previous = array[0][x];
			end_of_column = true;

			for(int y = 0; y<3; y++)
			{
				current = array[y][x];
				if(((previous == ' ') && (current == ' ')) || (previous != current))
				{
					end_of_column = false;
					vertically_yes = false;
					break;
				}
				previous = current;
			}

			if(end_of_column == true)
			{
				vertically_yes = true;
				break;
			}
		}


		return vertically_yes;		
	}
}
