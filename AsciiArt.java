import java.util.Scanner;
class AsciiArt {
    // No longer necessary const
    //private static final int SIZE = 4;

    // Define a new static scanner method
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // Ask the user for an input, store that value in size
        System.out.println("Input your desired size");
        int size = in.nextInt();
        drawSpaceNeedle(size);
    }
    // Every method from here on takes an int as a parameter to complete the scaling
    public static void drawBottom(int size) {
        // Print the left side end
        System.out.print("|");
        for (int i = 0; i < size * 6; i++) {
            // Print the quotes in multiples of 6
            System.out.print("\"");
        }
        // Print the right side end and move to the next line
        System.out.println("|");
    }

    public static void drawBase(int size) {
        for (int i = 1; i <= size; i++) {
            // Spaces before the left side
            for (int j = 1; j <= size - i; j++) {
                // Extra spaces before the left side were needed here
                System.out.print("   ");
            }
            // The left side end
            System.out.print("__/");
            for (int k = 1; k <= (i - 1) * 3; k++) {
                // Print the left side : in multiples of 3
                System.out.print(":");
            }
            // Draw the middle
            System.out.print("||");
            for (int l = 1; l <= (i - 1) * 3; l++) {
                // Print the right side : in multiples of 3
                System.out.print(":");
            }
            // Print the right side end and move to the next line
            System.out.println("\\__");
        }
    }

    public static void drawMiddle(int size) {
        // size * size to increase the length of the midsection by size^2
        for (int i = 0; i < (size * size); i++) {
            // Fix for when size = 1
            if (size == 1) {
                for (int j = 0; j <= size; j++) {
                    // Print the required spaces, for loop has to end at <= to center properly
                    System.out.print(" ");
                }
                // Otherwise multiple size by 2
            }else{
                for (int j = 0; j <= size * 2; j++) {
                    /// Print the required spaces, for loop has to end at <= to center properly
                    System.out.print(" ");
                }
            }
            // Draw the right side border
            System.out.print("|");

            for (int k = 0; k < size - 2; k++) {
                // size - 2 so there's always 2 fewer symbols than the input size
                // Print the right side %
                System.out.print("%");
            }
            // Print the middle connection
            System.out.print("||");
            for (int k = 0; k < size - 2; k++) {
                // Print the left side %
                System.out.print("%");
            }
            // Draw the left side border and move to the next line
            System.out.println("|");
        }
    }

    public static void drawConnection(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Print the spaces required to center the connector (3)
                System.out.print("   ");
            }
            // Print the connector and move to the next line
            System.out.println("||");
        }
    }

    public static void drawTheTop(int size) {
        for (int i = 0; i < size; i++) {
            // Print spaces before the left side
            for (int j = 0; j < i; j++) {
                // Needed an extra space here
                System.out.print("  ");
            }
            // Print left side end shape
            System.out.print("\\_/");
            for (int k = 0; k < size+2*(size-(i+1)); k++) {
                // Print the slashes
                System.out.print("\\");
                System.out.print("/");
            }
            // Print right side end shape and move to the next line after printing each row
            System.out.println("\\_/");
        }
    }

    public static void drawSpaceNeedle(int size){
        // Draw the entire needle using the size parameter
        drawConnection(size);
        drawBase(size);
        drawBottom(size);
        drawTheTop(size);
        drawConnection(size);
        drawMiddle(size);
        drawBase(size);
        drawBottom(size);
    }
}