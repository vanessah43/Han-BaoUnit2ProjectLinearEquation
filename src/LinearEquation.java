public class LinearEquation {
    // instance vars
    private String pair1;
    private String pair2;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int yDiff;
    private int xDiff;

    // creates a LinearEquation object
        // precondition: x1 & x2 are NOT equal
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        yDiff = (y2 - y1);
        xDiff = (x2 - x1);

        pair1 = "(" + x1 + ", " + y1 + ")";
        pair2 = "(" + x2 + ", " + y2 + ")";

    }

    // calculates and returns distance
    public double distance() {
        double temp = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return roundedToHundredth(temp);
    }

    // calculates and returns the y-intercept of the line
    public double yIntercept() {
        // if one of the pairs is on the y-axis returns its y-value
////        if (x1 == 0) {
//            return roundedToHundredth(y1);
//        } else if (x2 == 0) {
//            return roundedToHundredth(y2);
//        }

        // else
        double b = y1 - (slope() * x1);
        return roundedToHundredth(b);
    }

    // calculates and returns the slope of the line
    public double slope() {
            double yVal = yDiff;
            double xVal = xDiff;
            return roundedToHundredth(yVal/xVal);
    }


    // returns the equation of the line
    public String equation () {
        String slope = yDiff + "/" + xDiff;
        String line = "y = ";
        String yInt = "+ " + yIntercept();

        /* finding slopes + constraints */
//        // if one is negative
//        if ((xDiff < 0 && yDiff > 0 ) || (xDiff > 0 && yDiff < 0 )) {
//            slope = "-" + yDiff + "/" + xDiff;
//            System.out.println("b");
//        }

        // if one value (x or y) in the slope is negative
        if ((xDiff < 0) && (yDiff >= 0 ) || (xDiff > 0) && (yDiff <= 0 )) {
            slope = "-" + Math.abs(yDiff) + "/" + Math.abs(xDiff);
        }
        // if both values are negative
        else if (xDiff < 0 && yDiff < 0) {
            yDiff = Math.abs(yDiff);
            xDiff = Math.abs(xDiff);
            slope = yDiff + "/" + xDiff;
        }
        // if yDiff is divisible by xDiff
        if (yDiff % xDiff == 0) {
            // if one is negative
            if ((xDiff < 0 && yDiff > 0 ) || (xDiff > 0 && yDiff < 0 )) {
                slope = "-" + Math.abs(yDiff / xDiff);
            } else {
                slope = String.valueOf(yDiff / xDiff);
            }
        }

        // if slope = 1 or -1
        if (Math.abs(yDiff) == Math.abs(xDiff)) {
            // if slope negative
            if ((xDiff < 0 && yDiff > 0 ) || (xDiff > 0 && yDiff < 0 )) {
                slope = "-";
            } else {
                slope = "";
            }
        }

        /* finding y-ints + constraints */
        // if y int is negative
        if (yIntercept() < 0) {
            yInt = "- " + Math.abs(yIntercept());
        }

        // if y int is == 0
        else if (yIntercept() == 0) {
            yInt = "";
        }

        // if y int is positive
        else if (yIntercept() > 0) {
            yInt = "+ " + yIntercept();
        }

        // constructing string
        line += slope + "x " + yInt;

        // if string is horizontal
        if (y1 == y2) {
            line += yInt;
        }

        // final return statement
        return line;
    }

    /* returns a string of the coordinate point on the line that
    has both x & y coords. as decimals to the nearest hundredth */
    public String coordinateForX(double xValue) {
        double yValue = (xValue * slope() + yIntercept());
        yValue = roundedToHundredth(yValue);
        double roundedX = roundedToHundredth(xValue);
        return "(" + roundedX + ", " + yValue + ")";
    }

    //helper method, rounds to nearest hundredth
    public double roundedToHundredth(double toRound) {
        toRound *= 100;
        toRound = Math.round(toRound);
        toRound /= 100.0;
        return toRound;
    }

    // returns a String including all information about the equation & its points
    public String lineInfo() {
        String info = "Original points: " + pair1 + " and " + pair2;
        info += "\nEquation: " + equation();
        info += "\nSlope: " + slope();
        info += "\ny-intercept: " + yIntercept();
        info += "\nDistance: " + distance();

        return info;
    }
}
