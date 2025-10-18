import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Calculates the board foot value using width and height.
 * A board foot is defined as 144 cubic inches (12 × 12 × 1).
 *
 * @author Beni Nkongolo
 * @version 1.1
 * @since 2025-10-18
 */
public final class BoardFootCalculator {

    /**
     * Calculates the required length (in inches)
     * for a board to equal one board foot.
     *
     * @param width  The width of the wood in inches.
     * @param height The height (thickness) of the wood in inches.
     * @return The length in inches needed for one board foot.
     */
    private static double boardFootCalculator(
        final double width, final double height) {
        return 144 / (width * height);
    }

    /**
     * Asks for width and height,
     * then calculates and displays the board foot length.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = 0;
        double height = 0;

        // Loop until valid positive width
        while (true) {
            System.out.print("Enter the width (in inches): ");
            try {
                width = scanner.nextDouble();
                if (width <= 0) {
                    System.out.println("Width must be a positive number.");
                    continue;
                }
                break; // valid input, exit loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
            }
        }

        // Loop until valid positive height
        while (true) {
            System.out.print("Enter the height (in inches): ");
            try {
                height = scanner.nextDouble();
                if (height <= 0) {
                    System.out.println("Height must be a positive number.");
                    continue;
                }
                break; // valid input, exit loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear invalid input
            }
        }

        double length = boardFootCalculator(width, height);
        System.out.printf("To get 1 board foot, the wood must be "
        + "%.2f inches long.%n", length);

        scanner.close();
    }
}
