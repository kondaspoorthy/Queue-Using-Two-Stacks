// Queue with two stacks. Implement a queue with two stacks so that each queue operations takes a
// constant amortized number of stack operations. Hint: If you push elements onto a stack and then 
// pop them all, they appear in reverse order. If you repeat this process, they're now back in order.
import java.io.*;
import java.util.*;

class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public Queue() {
       stack1=new Stack<Integer>();
       stack2=new Stack<Integer>();

    }

    // Push element x to the back of queue.
    public void enqueue(int x) {
        if(stack1.isEmpty()){
            stack1.push(x);
        }
        else{
            while(!stack1.isEmpty()){
                int item = stack1.pop();
                stack2.push(item);
            }
            stack2.push(x);
            while(!stack2.isEmpty()){
                int item1=stack2.pop();
                stack1.push(item1);
            }
        }
    }
        

    

    // Removes the element from in front of queue.
    public int dequeue() {
        if (stack1.isEmpty()) throw new NoSuchElementException();
        int item2=stack1.pop();
        return item2;    
        
    }
    
    // Get the front element.
    public int peek() {
        int element = stack1.peek();
        return element;
       

    }
    
    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty();
       

    }

    // Return the number of elements in queue.
    public int  size() {
        return stack1.size();

    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue queue = new Queue();
        int queries = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < queries; i++) {
            String input = scan.nextLine();
            if (input.charAt(0) == '1') {
                String[] tokens = input.split(" ");
                queue.enqueue(Integer.parseInt(tokens[1]));
            } else if (input.charAt(0) == '2') {
                queue.dequeue();
            } else if (input.charAt(0) == '3') {
                System.out.println(queue.peek());
            } 
        }
        scan.close();
    }
}
