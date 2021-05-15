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

        // 100 blank lines...!
        for(int i = 1; i <= 100; i++)
        {
            System.out.println("");
        }

        char[][] targethistory_1 = new char[5][5];
        char[][] targethistory_2 = new char[5][5];

        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                targethistory_1[i][j] = '-';
            }
        }

        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                targethistory_2[i][j] = '-';
            }
        }

        int turn = 2;

        do {
            if(turn%2==0)
            {
                hitShip(sc, 1, 2, player2, targethistory_2);
                printBattleShip(targethistory_2);
                System.out.println("");
            }
            else
            {
                hitShip(sc, 2, 1, player1, targethistory_1);
                printBattleShip(targethistory_1);
                System.out.println("");
            }

            turn += 1;
        } while(checkCharacter('@', player1) && checkCharacter('@', player2));

        if(!checkCharacter('@', player1))
        {
            System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
        }
        else
        {
            System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
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
					System.out.print(player[column][row] + " ");
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

    private static void hitShip(Scanner sc, int hitting_player, int victim_player, char[][] player_array, char[][] target_history)
    {
        System.out.println("\n Player " + hitting_player + ", enter hit row/column:");
        String[] attack_coordinates = (sc.nextLine()).trim().split("\\s");
        int x = Integer.parseInt(attack_coordinates[0]);
        int y = Integer.parseInt(attack_coordinates[1]);
        try
        {
            if(target_history[x][y] == 'X' || target_history[x][y] == 'O')
            {
                System.out.println("\n You already fired on this spot. Choose different coordinates.");
                hitShip(sc, hitting_player, victim_player, player_array, target_history);
            }
            else if(player_array[x][y] == '@')
            {
                target_history[x][y] = 'X';
                player_array[x][y] = 'X';
                System.out.println("\n PLAYER " + hitting_player + " HIT PLAYER " + victim_player + "'s SHIP.");
            }
            else if(player_array[x][y] == '-')
            {
                target_history[x][y] = 'O';
                player_array[x][y] = 'O';
                System.out.println("\n PLAYER " + hitting_player + " MISSED!");
            }

        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("\n Invalid coordinates. Choose different coordinates.");
            hitShip(sc, hitting_player, victim_player, player_array, target_history);

        }
    }

}