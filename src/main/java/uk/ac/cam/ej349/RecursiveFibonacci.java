package uk.ac.cam.ej349;

class NumberTooSmallException extends Exception{
    NumberTooSmallException(int n) {
        super("Fibonacci number " + n + " cannot be calculated!");
    }
}

public class RecursiveFibonacci {

    private static int recursionNumber = 0;

    private static int calculate(int n) throws NumberTooSmallException {
        if (n < 0) {
            throw new NumberTooSmallException(n);
        }
        if (n < 2) {
            recursionNumber++;
            return 1;
        } else {
            recursionNumber++;
            return calculate(n-1) + calculate(n-2);
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            System.out.println(calculate(30));
            System.out.println(recursionNumber);
        } catch (NumberTooSmallException e) {
            throw new Exception(e);
        }
    }
}
