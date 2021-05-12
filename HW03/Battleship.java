import java.util.Scanner;

public class Battleship {
	public static void main(String[] args) {
        System.out.println("Welcome to Battleship!");
        
        Scanner sc = new Scanner(System.in);

        char[][] player1 = new char[5][5];
        char[][] player2 = new char[5][5];
        
        System.out.println("PLAYER 1, ENTER YOUR SHIPS'S COORDINATES.");

        for(int i = 0; i < 5; i++)
        {
            System.out.println("Enter ship " + (i+1) + " location:");
            String[] coordinates = (sc.nextLine()).trim().split("\\s");
            try
            {
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);

                if(player1[x][y]=='\u0000')
                {
                    player1[x][y] = '@';
                }
                else
                {
                    System.out.println("You already have a ship there. Choose different coordinates.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }
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
}