public class checkParenthesis {
    boolean checkParenthesis(String exp){
        First_Stack stk = new First_Stack(exp.length());
        String openbraces = "[{(";
        String closeBraces = "]})";
        for(int i=0; i<exp.length();i++){
            char ch = exp.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                stk.push(ch);
            }
            else{
                //closed bracket
                int index = closeBraces.indexOf(ch);
                char openbracket = openbraces.charAt(index);
                if (stk.isEmpty()) {
                    return false;
                }
                if (ch!=stk.pop()) {
                    return false;
                }
            }
        }
        if (!stk.isEmpty()) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
