package DSA_EXAM_QNS;
import java.util.Stack;

class GfG {

    public class QueueUsingStacks {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
    
        public QueueUsingStacks() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }
    
        public void enqueue(int x) {
            stack1.push(x);
        }

        public int dequeue() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return stack2.pop();
        }
    }
    
}



