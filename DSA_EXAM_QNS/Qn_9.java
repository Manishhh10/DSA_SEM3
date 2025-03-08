package DSA_EXAM_QNS;

public class Qn_9 {
    public class Power {
        // This method calculates x raised to the power n.
        public static double power(double x, int n) {
            // Base case: any number raised to the 0 is 1.
            if (n == 0) {
                return 1;
            }
            
            // Handle negative exponent by taking reciprocal.
            // Note: This simple handling does not cover the edge case of n == Integer.MIN_VALUE.
            if (n < 0) {
                return 1 / power(x, -n);
            }
            
            // Divide step: recursively compute half power.
            double temp = power(x, n / 2);
            
            // Conquer step: if n is even, square the half power.
            if (n % 2 == 0) {
                return temp * temp;
            } else {
                // If n is odd, multiply an extra x.
                return temp * temp * x;
            }
        }
    
        public static void main(String[] args) {
            System.out.println("2^10 = " + power(2, 10));  // Output: 1024.0
            System.out.println("2^-3 = " + power(2, -3));  // Output: 0.125
        }
    }
    
}
