public class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-2, -2);
        tail.prev = head;
        head.next = tail;
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            // delete
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // move to tail
            addToTail(node);

            return node.value;
        }
    }

    public void set(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;

            node.prev.next = node.next;
            node.next.prev = node.prev;
        } else {
            if (map.size() == capacity) {
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
            }

            node = new Node(key, value);
            map.put(key, node);
        }

        addToTail(node);
    }

    private void addToTail(Node node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }
}