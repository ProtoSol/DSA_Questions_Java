class Node {
    int key;
    int value;
    Node previous;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.previous = null;
        this.next = null;
    }
}

class LRUCache {
    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> lookup;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lookup = new HashMap<>();
        head = new Node(-1, -1); // Dummy head node
        tail = new Node(-1, -1); // Dummy tail node
        head.next = tail;
        tail.previous = head;
    }

    // Helper function to move a node to the end (before the tail)
    private void updateNode(Node node) {
        // Remove the node from its current position in the list
        if (node.previous != null) {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }

        // Move the node to the end
        node.next = tail;
        node.previous = tail.previous;
        tail.previous.next = node;
        tail.previous = node;
    }

    public int get(int key) {
        if (!lookup.containsKey(key)) {
            return -1;
        }

        // Get the node and update its position
        Node node = lookup.get(key);
        updateNode(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (lookup.containsKey(key)) {
            // If the node exists, update its value and move it to the end
            Node node = lookup.get(key);
            node.value = value;
            updateNode(node);
        } else {
            // If the node doesn't exist, create a new node
            if (lookup.size() >= capacity) {
                // Evict the least recently used item (head.next)
                Node nodeToRemove = head.next;
                head.next = nodeToRemove.next;
                nodeToRemove.next.previous = head;
                lookup.remove(nodeToRemove.key);
            }

            // Create a new node and add it to the cache
            Node newNode = new Node(key, value);
            lookup.put(key, newNode);
            updateNode(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */