class MyCircularDeque {
    int size;//剩余数量
    MyCircularDequeNode firstNode = null;
    MyCircularDequeNode lastNode = null;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.size = k;

    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        MyCircularDequeNode node = new MyCircularDequeNode(value);
        if (isEmpty()) {
            firstNode = node;
            lastNode = node;
        } else {
            node.next = firstNode;
            firstNode.pre = node;
            firstNode = node;
        }
        this.size--;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        MyCircularDequeNode node = new MyCircularDequeNode(value);
        if (isEmpty()) {
            firstNode = node;
            lastNode = node;
        } else {
            lastNode.next = node;
            node.pre = lastNode;
            lastNode = node;
        }
        this.size--;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        } else {
            firstNode = firstNode.next;
            firstNode.pre = null;
        }
        this.size++;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        } else {
            lastNode = lastNode.pre;
            lastNode.next = null;
        }


        this.size++;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (firstNode != null) {
            return firstNode.val;
        } else {
            return -1;
        }
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (lastNode != null) {
            return lastNode.val;
        } else {
            return -1;
        }
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        if (firstNode == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }
}

class MyCircularDequeNode {
    int val;
    //使用双向链表结构，提高查询效率
    //环形是否可以提高效率？
    MyCircularDequeNode next;
    MyCircularDequeNode pre;

//    public MyCircularDequeNode(int val, MyCircularDequeNode node) {
//        this.val = val;
//        this.next = node;
//    }

    public MyCircularDequeNode(int val) {
        this.val = val;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */