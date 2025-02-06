class MinStack {
    // Let's create the head node
    private Node head;

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int val) {
        // If the head node is null, 
        // create a new node with the value and the minimum value as the value
        if (head == null) {
            head = new Node(val, val, null);
        } else { // If the head node is not null
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    public void pop() {
        // The head node is removed
        head = head.next;
    }
    
    public int top() {
        // The top value is stored in the head node
        return head.val;
    }
    
    public int getMin() {
        // The minimum value is stored in the head node
        return head.min;   
    }

    // Let's create the node class to store the value and the minimum value at that point
    private class Node {
        int val;
        int min;
        Node next;
        
        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}

