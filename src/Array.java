public class Array {
    public static void main(String[] args) {

        for (int n = 0; n < 2; ++n) {
            int[][] myNumbers = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
            for (int i = 0; i < myNumbers.length; ++i) {
                for (int j = 0; j < myNumbers[i].length; ++j) {
                    int field = myNumbers[i][j];
                    if (field == 7) {
                        System.out.print("X ");
                    } else {
                        System.out.print(myNumbers[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
        boolean[][] pyramidArray = {
                {false, false, true, false, false},
                {false, true, true, true, false},
                {true, true, true, true, true},
        };
        for (int i = 0; i < pyramidArray.length; ++i) {
            for (int j = 0; j < pyramidArray[i].length; ++j) {
                boolean field = pyramidArray[i][j];
                if (field == true) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}