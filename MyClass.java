public class MyClass {
    public static void main(String[] args) {
        double[] coeffs = {3, 0, -4, 1}; // 1x^3 - 4x^2 + 3
        Function f = new Function(coeffs);
        System.out.println("Function: " + f);

        Function derivative = f.derivative();
        System.out.println("Derivative: " + derivative);

        Function integral = f.integral(0);
        System.out.println("Integral (constant=0): " + integral);

        double definiteIntegral = f.definiteIntegral(0, 2);
        System.out.println("Definite integral from 0 to 2: " + definiteIntegral);

        double slopeAt2 = f.slopeAt(2);
        System.out.println("Slope at x=2: " + slopeAt2);

        List<Double> zeros = f.findZeros(-10, 10, 0.01);
        System.out.println("Zeros between -10 and 10: " + zeros);
    }
}