public class First_Stack {
    char[] stk;
    int top = -1;
    int size;
    First_Stack(int size){
        stk = new char[size];
        this.size = size; 
    }

    void push(char data){
        if (isFull()) {
            System.out.println("Stack overflow!");
        }
        else{
            // top++
            // stk[] = data;
            stk[++top]=data;
        }
    }

    char pop(){
        if (isEmpty()) {
            System.out.println("Stack underflow!");
            return 'e';
        }
        // int temp = top;
        // top--
        // return stk[temp]
        return stk[top--];
    }

    char peek(){
        return stk[top];
    }

    boolean isEmpty(){
        return top == -1;
    }

    boolean isFull(){
        return top == size-1;
    }

    public static void main(String[] args) {
        First_Stack s = new First_Stack(5);
        s.push('a');
        s.push('b');
        System.out.println(s.pop());
    }
}


// Write an algorithm to convert infix expression to prefix and viceversa(tabulation).
// Write an algorithm to evaluate postfix expresiion.