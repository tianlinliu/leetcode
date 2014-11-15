class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.empty()) {
            int x = stack.pop();
            if (minStack.peek() == x) {
                minStack.pop();
            }
        }
    }

    public int top() {
        int x = Integer.MAX_VALUE;
        if (!stack.empty()) {
            x = stack.peek();
        }

        return x;
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        if (!minStack.empty()) {
            min = minStack.peek();
        }

        return min;
    }
}
