import java.util.ArrayList;
import java.util.List;

public class Function {
    private double[] coefficients;

    public Function(double[] coefficients) {
        this.coefficients = coefficients;
    }

    public double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;

        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (!first) {
                    sb.append(coefficients[i] > 0 ? " + " : " - ");
                } else {
                    if (coefficients[i] < 0) {
                        sb.append("-");
                    }
                    first = false;
                }

                double absCoefficient = Math.abs(coefficients[i]);
                if (i == 0 || absCoefficient != 1) {
                    sb.append(absCoefficient);
                }

                if (i > 0) {
                    sb.append("x");
                    if (i > 1) {
                        sb.append("^").append(i);
                    }
                }
            }
        }

        if (first) { // all coefficients are zero
            sb.append("0");
        }

        return sb.toString();
    }
        public Function derivative() {
        if (coefficients.length <= 1) {
            return new Function(new double[]{0});
        }
        double[] derivCoefficients = new double[coefficients.length - 1];
        for (int i = 1; i < coefficients.length; i++) {
            derivCoefficients[i - 1] = coefficients[i] * i;
        }
        return new Function(derivCoefficients);
    }

    public Function integral(double constant) {
        double[] integralCoefficients = new double[coefficients.length + 1];
        integralCoefficients[0] = constant;
        for (int i = 0; i < coefficients.length; i++) {
            integralCoefficients[i + 1] = coefficients[i] / (i + 1);
        }
        return new Function(integralCoefficients);
    }

    public double definiteIntegral(double a, double b) {
        Function integralFunction = this.integral(0);
        return integralFunction.evaluate(b) - integralFunction.evaluate(a);
    }

    public double slopeAt(double x) {
        Function derivativeFunction = this.derivative();
        return derivativeFunction.evaluate(x);
    }

    public List<Double> findZeros(double start, double end, double increment) {
        List<Double> zeros = new ArrayList<>();
        double x = start;
        while (x <= end) {
            if (Math.abs(evaluate(x)) < 1e-6) {
                zeros.add(x);
            }
            x += increment;
        }
        return zeros;
    }  
}
