public class BackTracking {
    void findPermutation(String str, String perm){
        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }
        if (perm.length()>1 && perm.charAt(1)!='C') {
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String remstr = str.substring(0,1) + str.substring(i+1);
            findPermutation(remstr, perm+currentChar);
        }
    }
    
    public static void main(String[] args) {

    }
}
