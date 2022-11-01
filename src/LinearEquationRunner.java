import java.util.Scanner;
public class LinearEquationRunner {

    static void start() {
        // greeting user
        System.out.println("Welcome!");

    }
    public static void main(String[] args) {
        // scanner object
        Scanner scan = new Scanner(System.in);

        start();

        System.out.print("Please enter a coordinate pair in the form (x, y). \nBoth should be integers. ");
        String pair1 = scan.nextLine();
        System.out.print("Enter your next pair. \nNote: x cannot be the same. ");
        String pair2 = scan.nextLine();

        // extracting strings of the numbers from the pairs
        int commaIndex = pair1.indexOf(", ");
        int parIndex = pair1.indexOf(")");
        String x1 = pair1.substring(1, commaIndex);
        String y1 = pair1.substring((commaIndex + 2), parIndex);

        commaIndex = pair2.indexOf(", ");
        parIndex = pair2.indexOf(")");
        String x2 = pair2.substring(1, commaIndex);
        String y2 = pair2.substring((commaIndex + 2), parIndex);

        // extracting integers by parsing strings
        int intX1 = Integer.parseInt(x1);
        int intY1 = Integer.parseInt(y1);
        int intX2 = Integer.parseInt(x2);
        int intY2 = Integer.parseInt(y2);

        // in the case of a vertical line, exits program w/ 0 errors
        if (x1.equals(x2)) {
            System.out.println("These points are on a vertical line: x = " + x1);
            System.exit(0);
        }

        // initializes object + prints info about it
        LinearEquation linear = new LinearEquation(intX1, intY1, intX2, intY2);
        System.out.println(linear.lineInfo());

        // asks for point on line + prints coordinate
        System.out.print("\nEnter a value for x: ");
        double x = scan.nextDouble();
        System.out.print(linear.coordinateForX(x));
    }
}