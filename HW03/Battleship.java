import java.util.Scanner;

public class Battleship {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Battleship!");

        char[][] player1 = new char[5][5];
        char[][] player2 = new char[5][5];
        
        System.out.println("PLAYER 1, ENTER YOUR SHIPS'S COORDINATES.");

        for(int i = 0; i < 5; i++)
        {
            addCoordinates(sc, i, player1);
        }

        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(player1[i][j]=='\u0000')
                {
                    player1[i][j] = '-';
                }
                else
                {
                    continue;
                }
            }
        }

        printBattleShip(player1);


        // 100 blank lines...!
        for(int i = 1; i <= 100; i++)
        {
            System.out.println("");
        }


        System.out.println("PLAYER 2, ENTER YOUR SHIPS'S COORDINATES.");

        for(int i = 0; i < 5; i++)
        {
            addCoordinates(sc, i, player2);
        }

        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(player2[i][j]=='\u0000')
                {
                    player2[i][j] = '-';
                }
                else
                {
                    continue;
                }
            }
        }

        printBattleShip(player2);

        char[][] targethistory_1 = new char[5][5];
        char[][] targethistory_2 = new char[5][5];

        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                targethistory_1[i][j] = player1[i][j];
            }
        }

        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                targethistory_2[i][j] = player2[i][j];
            }
        }

        int turn = 2;

        do {
            if(turn%2==0)
            {
                hitShip(sc, 1, 2, targethistory_2);
            }
            else
            {
                hitShip(sc, 2, 1, targethistory_1);
            }

            turn += 1;
        } while(checkCharacter('@', targethistory_1) && checkCharacter('@', targethistory_2));

        if(!checkCharacter('@', targethistory_1))
        {
            System.out.println("PLAYER 2 WON!");
        }
        else
        {
            System.out.println("PLAYER 1 WON");
        }
	}

	// Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}


    private static void addCoordinates(Scanner sc, int coordinate_no, char[][] player_coordinates)
    {
        System.out.println("Enter ship " + (coordinate_no+1) + " location:");
        String[] coordinates = (sc.nextLine()).trim().split("\\s");
        try
        {
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);

            if(player_coordinates[x][y]=='\u0000')
            {
                player_coordinates[x][y] = '@';
            }
            else
            {
                System.out.println("You already have a ship there. Choose different coordinates.");
                addCoordinates(sc, coordinate_no, player_coordinates);
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid coordinates. Choose different coordinates.");
            addCoordinates(sc, coordinate_no, player_coordinates);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid coordinates. Choose different coordinates.");
            addCoordinates(sc, coordinate_no, player_coordinates);
        }
    }

    private static boolean checkCharacter(char a, char[][] char_array)
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(char_array[i][j]=='@')
                {
                    return true;
                }
                else
                {
                    continue;
                }
            }
        }

        return false;
    }

    private static void hitShip(Scanner sc, int hitting_player, int victim_player, char[][] char_array)
    {
        System.out.println("Player " + hitting_player + ", enter hit row/column:");
        String[] attack_coordinates = (sc.nextLine()).trim().split("\\s");
        int x = Integer.parseInt(attack_coordinates[0]);
        int y = Integer.parseInt(attack_coordinates[1]);
        try
        {
            if(char_array[x][y] == 'X')
            {
                System.out.println("You already fired on this spot. Choose different coordinates.");
                hitShip(sc, hitting_player, victim_player, char_array);
            }
            else if(char_array[x][y] == '@')
            {
                char_array[x][y] = 'X';
                System.out.println("PLAYER " + hitting_player + " HIT PLAYER " + victim_player + "'s SHIP.");
            }
            else if(char_array[x][y] == '-')
            {
                char_array[x][y] = 'O';
                System.out.println("PLAYER " + hitting_player + " MISSED!");
            }

        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid coordinates. Choose different coordinates.");
            hitShip(sc, hitting_player, victim_player, char_array);

        }
    }

}