public class InfixToPostFix {

    int precedence(char ch){
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (ch == '*' || ch == '/') {
            return 2;
        }
        if (ch == '^') {
            return 3;
        }
        return -1;
    }

    String convertToPostFix(String exp){
        String res = "";
        First_Stack stk = new First_Stack(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (precedence(ch)>0) {
                //operator
                while (!stk.isEmpty() && precedence(stk.peek())>=precedence(ch)) {
                    res=res+stk.pop();
                }
                stk.push(ch);
            }
            else{
                //bracket or opherend
                if (ch=='(') {
                    stk.push(ch);
                }
                else if(ch=='('){
                    char x = stk.pop();
                    while (x!='(') {
                        res=res+x;
                        x=stk.pop();
                    }
                }
                else{
                    // opherend case
                    res = res + ch;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        
    }
}
