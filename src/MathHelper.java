public class MathHelper {

    public int calc(int a, int b, char action) {
        if (action == '+') {
            return this.plus(a, b);
        } else if (action == '-') {
            return this.minus(a, b);
        } else if (action == '*') {
            return this.multiply(a, b);
        } else if (action == '/') {
            return this.divide(a, b);
        } else {
            return this.typeAnError("error action " + action);
        }
    }

    private int typeAnError(String error) {
        System.out.println(error);
        return 0;
    }

    private int plus(int a, int b) {
        return a + b;
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private int multiply(int number, int multiplier) {
        return number * multiplier;
    }

    private int divide(int number, int divider) {

        if (divider == 0) {
            return this.typeAnError("Cannot divide by zero");
        } else return number / divider;
    }
}
