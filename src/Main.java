import java.io.IOException;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean match = false;
        boolean[][] gameArray = generateRandomBooleanArrayWithChangeableSize(20, 20);
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        while (!match) {
            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            boolean[][][] arrayHistory = {};
            boolean[][] newArray = gameOfLifeUpdate(gameArray);
            if (Arrays.deepEquals(gameArray, newArray)) match = true;
            gameArray = newArray;
            String gameString = twoDimensionalArrayToString(gameArray, '⬜', '⬛');
            System.out.print(gameString);
            Thread.sleep(300);
//            System.out.println(numberOfLivingNeighbors(pyramidArray,));
        }

    }

    static void clearScreen(int consoleHeight) {
        for (int i = 1; i <= consoleHeight; i++) {
            System.out.println(" ");
        }
    }


    static String twoDimensionalArrayToString(boolean[][] array, char trueValue, char falseValue) {
        String output = "";
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                boolean field = array[i][j];
                 output += field? trueValue : falseValue;
            }
            output += "\n";
        }
        return output;
    }

    static boolean[][] gameOfLifeUpdate(boolean[][] array) {
        boolean[][] newArray = new boolean[array.length][array[0].length];
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {
                int livingNeighbors = numberOfLivingNeighbors(array, i, j);
                boolean alive = array[i][j];
                if ((livingNeighbors == 3 || livingNeighbors == 2) && alive) {
                    newArray[i][j] = true;
                } else if (alive) {
                    newArray[i][j] = false;
                } else if (livingNeighbors == 3) {
                    newArray[i][j] = true;
                } else {
                    newArray[i][j] = false;
                }
            }

        }
        return newArray;
    }

    static int numberOfLivingNeighbors(boolean[][] array, int x, int y) {
        int alive = 0;
        int xLength = array.length, yLength = array[0].length;
        alive += array[(x + 1) % xLength][y] ? 1 : 0;
        alive += array[(x + 1) % xLength][(y - 1) < 0 ? yLength - 1 : (y - 1)] ? 1 : 0;
        alive += array[(x + 1) % xLength][(y + 1) % xLength] ? 1 : 0;

        alive += array[(x - 1) < 0 ? xLength - 1 : x - 1][y] ? 1 : 0;
        alive += array[(x - 1) < 0 ? xLength - 1 : x - 1][(y - 1) < 0 ? yLength - 1 : y - 1] ? 1 : 0;
        alive += array[(x - 1) < 0 ? xLength - 1 : x - 1][(y + 1) % xLength] ? 1 : 0;

        alive += array[x][(y + 1) % xLength] ? 1 : 0;
        alive += array[x][(y - 1) < 0 ? yLength - 1 : y - 1] ? 1 : 0;

        return alive;
    }

    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    public static boolean[][] generateRandomBooleanArrayWithChangeableSize(int y, int x) {
        boolean[][] randomBooleanArray = new boolean[y][x];
        for (int i = 1; i < y; i++)
            for (int j = 1; j < x; j++)
                randomBooleanArray[i][j] = getRandomBoolean();
        return randomBooleanArray;
    }
    String output;
}
