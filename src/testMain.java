public class testMain {
    public static void main(String[] args) {
        LinearEquation line = new LinearEquation(1, 2, 3, 4);
        double testNum = line.roundedToHundredth(1.923434);
        System.out.println(testNum);
    }
}
