import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args) {
        // scanner object
        Scanner scan = new Scanner(System.in);

        // greeting user + asking for 2 coordinate pairs
        System.out.println("Welcome! Please enter a coordinate pair in the form (x, y). Both should be integers.");
        String pair1 = scan.nextLine();
        System.out.println("Enter your next pair.");
        String pair2 = scan.nextLine();

        // extracting strings of the numbers from the pairs
        int commaIndex = pair1.indexOf(",");
        int parIndex = pair1.indexOf(")");
        String x1 = pair1.substring(1, commaIndex);
        String y1 = pair1.substring((commaIndex + 1), parIndex);

        commaIndex = pair2.indexOf(",");
        parIndex = pair2.indexOf(")");
        String x2 = pair2.substring(1, commaIndex);
        String y2 = pair2.substring((commaIndex + 1), parIndex);

        int intX1 = Integer.parseInt(x1);
        int intY1 = Integer.parseInt(y1);
        int intX2 = Integer.parseInt(x2);
        int intY2 = Integer.parseInt(y2);


    }
}