public class MinStack {

    private Value head;
    private int size = 0;
    private int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int val) {
        if (size == 0) {
            head = new Value(null, val);
        } else {
            head = new Value(head, val);
        }
        if (val < min) {
            min = val;
        }
        size++;
    }

    public void pop() {
        size--;
        if (head.val == min) {
            head = head.getNext();
            setMinimum();
        } else {
            head = head.getNext();
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return min;

    }

    private void setMinimum() {
        Value iterator = head;
        int min = Integer.MAX_VALUE;
        while (iterator != null) {
            if (iterator.val < min) {
                min = iterator.val;
            }
            iterator = iterator.next;
        }
        this.min = min;
    }

    static class Value {
        private Value next;
        private int val;

        public Value(Value next, int val) {
            this.next = next;
            this.val = val;
        }

        public Value getNext() {
            return next;
        }

        public void setNext(Value next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
