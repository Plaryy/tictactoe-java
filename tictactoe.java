import java.util.Scanner;

class tictactoe {

    static Scanner sc = new Scanner(System.in);
    static char[][] grid = new char[3][3];
    static int count = 0;
    public static char a = 'X', b = 'O', temp = ' ';

    public static void main(String[] args) {

        int p = 65;
        for (int row=0;row<3;row++) {
            for (int col=0;col<3;col++) {
                grid[row][col] = (char) p++;
            }
        }


        do {

            displayGrid();
            System.out.println("Enter coordinates: ");
            int x = sc.nextInt();
            int y = sc.nextInt();

            readAnswer(x, y);

            System.out.println("Attempts left: " + (9 - count) + "\n");



        } while (!(checkAnswer() || count == 9));

        displayGrid();

        if (count == 9) {
            System.out.println("Tie.");
        } else {
             System.out.println("Winner is: " + b);
        }
        


    }

    static char[][] readAnswer(int x, int y) {

        if (grid[x][y] == 'X' || grid[x][y] == 'O') System.out.println("There's already a value there.\n");
        else {
            grid[x][y] = a;
            System.out.println("\nSuccessfully placed " + a + " in " + "(" + x + "," + y + ").");
            temp = a;
            a = b;
            b = temp;
            count += 1;
        }
        return grid;
    }

    static void displayGrid() {
        for (int row=0;row<3;row++) {
            System.out.print("(" + row + ") [");
            for (int col=0; col<3;col++) {
                if (col == 0 || col == 2) {
                    if (grid[row][col] != 'X' && grid[row][col] != 'O') System.out.print("   ");
                    else System.out.print(" " + grid[row][col] + " ");
                } else {
                    if (grid[row][col] != 'X' && grid[row][col] != 'O') System.out.print("|   |");
                    else System.out.print("| " + grid[row][col] + " |");
                }
            }
            if (row != 2) {
                System.out.print("]\n");
            } else {
                System.out.print("]");
            }
        }
        System.out.print("\n     ");
        for (int i = 0; i<3;i++) {
            System.out.print("(" + i + ") ");
        }
        System.out.println();
    }


    static boolean checkAnswer() {
        boolean notEmpty = true;
        for (int row=0;row<3;row++) {
            for (int col=0;col<3;col++) {

                if (grid[row][col] == 'X' || grid[row][col] == 'O') notEmpty = false;
            }
        }
        if (notEmpty) return false;
        
        
        return (grid[0][0] == grid [0][1] && grid[0][0] == grid [0][2]) ||
        (grid[0][0] == grid [1][1] && grid[0][0] == grid [2][2]) ||
        (grid[0][0] == grid [1][0] && grid[0][0] == grid [2][0]) ||
        (grid[2][0] == grid [2][1] && grid[2][0] == grid [2][2]) ||
        (grid[2][0] == grid [1][1] && grid[0][0] == grid [0][2]) ||
        (grid[0][2] == grid [1][2] && grid[0][2] == grid [2][2]) ||
        (grid[0][1] == grid [1][1] && grid[0][1] == grid [2][1]) ||
        (grid[1][0] == grid [1][1] && grid[1][0] == grid [1][2]) || 
        (grid[0][2] == grid [1][1] && grid[1][1] == grid [2][0]);
    }
} 
