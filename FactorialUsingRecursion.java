public class FactorialUsingRecursion {
    public static int fact(int x){
        if (x > 1) {
            return x * fact(x - 1);
        }else{
            return x;
        }
    }
    public static void main(String[] args) {
        int result = fact(5);
        System.out.println(result);
    }
}
