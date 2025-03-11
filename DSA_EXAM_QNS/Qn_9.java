package DSA_EXAM_QNS;

public class Qn_9 {
    public class Power {
        public static double power(double x, int n) {
            if (n == 0) {
                return 1;
            }
            if (n < 0) {
                return 1 / power(x, -n);
            }            
            
            double temp = power(x, n / 2);
            
            if (n % 2 == 0) {
                return temp * temp;
            } else {
                return temp * temp * x;
            }
        }
    
        public static void main(String[] args) {
            System.out.println("2^10 = " + power(2, 10));  // Output: 1024.0
            System.out.println("2^-3 = " + power(2, -3));  // Output: 0.125
        }
    }
    
}
