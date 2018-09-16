import java.io.*;	//Import package which allows user input

public class BattleShip 
{

	/**
	 * This program prompts the user to place 5 ships by providing the upper-left-most position as well as the orientation (North/South or East/West).
	 * The battleship grid is represented by a two-dimensional array. After the user has placed all 5 ships, the program will display the board and allow
	 * a different user to guess the location of the placed ships. 0 will visually represent an empty grid cell and an X will represent locations where
	 * a ship exists. The program displays the array after each attack attempt. Cells that the attacker has not yet probed will be represented with the
	 * letter 'H', direct hits with the letter X, and misses with the letter O.
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in));
		
		final int LENGTH = 10;
		final int HEIGHT = 10;
		final int MIN_RESPONSE = 1;
		final int MAX_RESPONSE = 10;
		
		//Create two-dimensional array for the grid
		char gameBoard[][] = new char[LENGTH][HEIGHT];
		
		//Populate and print the two-dimensional array grid
		int row = 0;
		int column = 0;
		
		while (row < LENGTH)
		{
			if(row != 0)
			{
				System.out.print(Character.toChars(row+65));
				System.out.print(" ");
			}
			while(column < HEIGHT)
			{
				if(row == 0 && column == 0)
				{
					System.out.println("   1 2 3 4 5 6 7 8 9 10");	//Prints the X axis values to make grid easier to read for the user
					System.out.print(Character.toChars(row+65));	//Prints the Y axis values to make grid easier to read for the user
					System.out.print(" ");
				}
				gameBoard[row][column] = '0';
				System.out.print(" " + gameBoard[row][column]);
				column++;
			}
		
			System.out.println();
			column = 0;
			row++;
		}
		//Prompt user to input the upper-left-most position of each sheep and respective orientation
		System.out.println("Please enter the upper-left-most position of each ship (ex: A3), as well as its orientation (North/South or East/West).");
		
		String shipType[] = {"Aircraft Carrier","Battleship","Submarine","Destroyer","Patrol Boat"};
		int shipSize[] = {5,4,3,3,2};
		
		for(int i = 0; i < shipType.length; i++)
		{
			//Declare variables used for user input
			char shipYAxis;
			int shipXAxis;
			int shipIntegerYAxis = 0;
			char shipOrientation;
			
			System.out.println(shipType[i]);
			
			System.out.print("Please specify a Y coordinate (A-J): ");
			shipYAxis = keyboard.readLine().charAt(0);
			if(shipYAxis >= 'A' && shipYAxis <= 'J')
			{
				System.out.print("Please specify a X coordinate (1-10): ");
				shipXAxis = new Integer(keyboard.readLine()).intValue();
				if(shipXAxis < MIN_RESPONSE || shipXAxis > MAX_RESPONSE)
				{
					//Prompts user of invalid entry in case they do not meet the specifications of a valid coordinate
					System.out.println("INVALID ENTRY! Please enter valid coordinate.");
					i--;
					continue;
				}
				else
				{	
					//Converts the user Y axis entry into an integer value
					shipIntegerYAxis = shipYAxis - 'A';
				}
			}
			else
			{
				System.out.println("INVALID ENTRY! Please enter valid coordinate.");
				i--;
				continue;
			}
			
			//Prompts user for the orientation of the ship
			System.out.print("Please enter orientation with the corresponding letter ([V]ertical/[H]orizontal): ");
			shipOrientation = keyboard.readLine().charAt(0);
						
			if (shipOrientation == 'V' || shipOrientation == 'v')
			{
				System.out.println("Your " + shipType[i] + " of size " + shipSize[i] + " is placed on " + shipYAxis + shipXAxis + " in the vertical orientation.");

				if(((10 - shipIntegerYAxis) < shipSize[i]) || (gameBoard[shipIntegerYAxis][shipXAxis-1] == 'X'))
				{
					//This error message displays if the user tries to place the ship over another ship or if the ship will not fit in the designated coordinate and orientation
					System.out.println("INVALID ENTRY! Please enter valid coordinate and orientation.");
					i--;
				}
				else
				{
					int count = 0;
					//This while loop places the ship of choice on the game board
					while(count < shipSize[i])
					{
					
						gameBoard[shipIntegerYAxis][shipXAxis-1] = 'X';
						shipIntegerYAxis++;
						count++;
					}
					
					//This prints out the game board for the user to see the placement of his/her fleet
					row = 0;
					column = 0;
				
					while (row < LENGTH)
					{
						if(row != 0)
						{
							System.out.print(Character.toChars(row+65));
							System.out.print(" ");
						}
						while(column < HEIGHT)
						{
							if(row == 0 && column == 0)
							{
								System.out.println("   1 2 3 4 5 6 7 8 9 10");
								System.out.print(Character.toChars(row+65));
								System.out.print(" ");
							}
							System.out.print(" " + gameBoard[row][column]);
							column++;
						}
					
						System.out.println();
						column = 0;
						row++;
					}
				}
			}
			else if (shipOrientation == 'H' || shipOrientation == 'h')
			{
				System.out.println("Your " + shipType[i] + " of size " + shipSize[i] + " is placed on " + shipYAxis + shipXAxis + " in the horizontal orientation.");

				if(((10 - shipXAxis) < (shipSize[i]-1)) || (gameBoard[shipIntegerYAxis][shipXAxis-1] == 'X'))
				{
					
					//This error message displays if the user tries to place the ship over another ship or if the ship will not fit in the designated coordinate and orientation
					System.out.println("INVALID ENTRY! Please enter valid coordinate and orientation.");
					i--;
				}
				else
				{
					int count = 0;
					//This while loop places the ship of choice on the game board
					while(count < shipSize[i])
					{
						gameBoard[shipIntegerYAxis][shipXAxis-1] = 'X';
						shipXAxis++;
						count++;
					}
					
					//This prints out the game board for the user to see the placement of his/her fleet
					row = 0;
					column = 0;
				
					while (row < LENGTH)
					{
						if(row != 0)
						{
							System.out.print(Character.toChars(row+65));
							System.out.print(" ");
						}
						while(column < HEIGHT)
						{
							if(row == 0 && column == 0)
							{
								System.out.println("   1 2 3 4 5 6 7 8 9 10");
								System.out.print(Character.toChars(row+65));
								System.out.print(" ");
							}
							System.out.print(" " + gameBoard[row][column]);
							column++;
						}
					
						System.out.println();
						column = 0;
						row++;
					}
				}
			}
			else if(shipOrientation != 'V' || shipOrientation != 'v' || shipOrientation != 'H' || shipOrientation != 'h')
			{
				System.out.println("INVALID ENTRY! Please enter valid orientation.");
				i--;
			}
			

		}
		
		//Allows user to clear screen prior to finding an opponent
		System.out.print("Now press the ENTER key, then go find an opponent to attempt sinking your fleet!");
		keyboard.readLine();
		
		//Clears screen of old grid
		for(int clear = 0; clear < 1000; clear++)
		{
			System.out.println() ;
		}
		
		//Initialize and declare variables used for the attack board
		int attackXAxis;
		char attackYAxis;
		int attackIntegerYAxis = 0;
		char attackBoard [][] = new char[LENGTH][HEIGHT];
		int totalHits;
		final int TOTAL_HITS = 17; 		//This number represents the total number of successful attacks required to sink the fleet.
		

		
		//Populate and print the two-dimensional array grid
		row = 0;
		column = 0;
		
		while (row < LENGTH)
		{
			if(row != 0)
			{
				System.out.print(Character.toChars(row+65));
				System.out.print(" ");
			}
			while(column < HEIGHT)
			{
				if(row == 0 && column == 0)
				{
					System.out.println("   1 2 3 4 5 6 7 8 9 10");
					System.out.print(Character.toChars(row+65));
					System.out.print(" ");
				}
				attackBoard[row][column] = 'H';
				System.out.print(" " + attackBoard[row][column]);
				column++;
			}
			
			System.out.println();
			column = 0;
			row++;
		}

		
		do
		{
			totalHits = 0; //This counts the number of successful hits on the fleet by the attacker
			
			System.out.print("Please specify a Y coordinate (A-J), then hit ENTER: ");
			attackYAxis = keyboard.readLine().charAt(0);
			if(attackYAxis >= 'A' && attackYAxis <= 'J')
			{
				//Converts the Y coordinate from a character to a integer value
				attackIntegerYAxis = attackYAxis - 'A';
			
				System.out.print("Please specify an X coordinate (1-10), then hit ENTER: ");
				attackXAxis = new Integer(keyboard.readLine()).intValue();
				
				if(attackXAxis > MAX_RESPONSE || attackXAxis < MIN_RESPONSE)
				{
					System.out.println("INVALID ENTRY! Please enter valid coordinate.");
					continue;
				}
				
				if(gameBoard[attackIntegerYAxis][attackXAxis-1] == 'X' && attackBoard[attackIntegerYAxis][attackXAxis-1]  == 'H')
				{
					//Updates the attack board with the new attempt
					attackBoard[attackIntegerYAxis][attackXAxis-1] = 'X';
				
					//This prints out the game board for the user to see the placement of his/her fleet
					row = 0;
					column = 0;
			
					while (row < LENGTH)
					{
						if(row != 0)
						{
							System.out.print(Character.toChars(row+65));
							System.out.print(" ");
						}
						while(column < HEIGHT)
						{
							if(row == 0 && column == 0)
							{
								System.out.println("   1 2 3 4 5 6 7 8 9 10");
								System.out.print(Character.toChars(row+65));
								System.out.print(" ");
							}
							System.out.print(" " + attackBoard[row][column]);
							column++;
						}
				
						System.out.println();
						column = 0;
						row++;
					}
					
					//Notifies user that attack was successful
					System.out.println("Direct hit, at " + attackYAxis + attackXAxis + ".");
				
				}
				else if(gameBoard[attackIntegerYAxis][attackXAxis-1] != 'X' && attackBoard[attackIntegerYAxis][attackXAxis-1]  == 'H')
				{
					//Updates the attack board with the new attempt
					attackBoard[attackIntegerYAxis][attackXAxis-1] = 'O';
				
					//This prints out the game board for the user to see the placement of his/her fleet
					row = 0;
					column = 0;
			
					while (row < LENGTH)
					{
						if(row != 0)
						{
							System.out.print(Character.toChars(row+65));
							System.out.print(" ");
						}
						while(column < HEIGHT)
						{
							if(row == 0 && column == 0)
							{
								System.out.println("   1 2 3 4 5 6 7 8 9 10");
								System.out.print(Character.toChars(row+65));
								System.out.print(" ");
							}
							System.out.print(" " + attackBoard[row][column]);
							column++;
						}
						System.out.println();
						column = 0;
						row++;
					}
					
					//Notifies user that attack was a failure
					System.out.println("Target missed at " + attackYAxis + attackXAxis + ".");
				
				}
				else
				{
					System.out.println("INVALID ENTRY! Please enter valid coordinate.");
					continue;
				}
			}
			else
			{
				System.out.println("INVALID ENTRY! Please enter valid coordinate.");
				continue;
			}
			
			//Traverses the loop to check for the total number of hits
			for(int rows = 0; rows < 10; rows++)
			{
				for(int columns = 0; columns < 10; columns++)
				{
					if(attackBoard[rows][columns] == 'X')
					{
						totalHits++;
					}
				}
			}
			//fleetSunk = true;
		}while(totalHits != TOTAL_HITS);
		
		System.out.print("Congratulations, you have successfully sunk the fleet!!! Thank you for playing.");
	}

}
