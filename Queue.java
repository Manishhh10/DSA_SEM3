public class Queue {
    int queue[];
    int size;
    int front = -1;
    int rear = -1;
    Queue(int size){
        this.size=size;
        queue = new int [size];

    }

    void enqueue(int data){
        if (isFull()) {
            System.out.println("Queue is full");
        }
        else{
            if (front == -1) {
                front = 0;
            }
            // rear++;
            // queue[rear] = data;
            queue[++rear] = data;
        }
    }

    int dequeue(){
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        if (front == rear) {
            int temp = front;
            front = rear = -1;
            return queue[front];
        }
        // int temp = front;
        // front++;
        // return queue[temp];
        return queue[front++];
    }

    boolean isFull(){
        return rear == size-1;
    }

    boolean isEmpty(){
        return front == -1  && rear == -1;
    }

    public static void main(String[] args) {
        
    }
}

// Write an alogotihm to implement Stack using two Queues and 
// Write an alogotihm to implement Queue using two Stack 