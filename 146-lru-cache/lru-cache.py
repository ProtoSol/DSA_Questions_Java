class Node:
    def __init__(self, key, value):
        self.key = key  # Store the key for identifying the node
        self.value = value
        self.previous = None
        self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.head = Node(-1, -1)  # Temporary dummy head
        self.tail = Node(-1, -1)  # Temporary dummy tail
        self.head.next = self.tail
        self.tail.previous = self.head
        self.lookup = {}  # Stores key -> value
        self.position = {}  # Stores key -> node
        self.capacity = capacity

    def update_node(self, node):
        # Delete the node from its current position in the doubly linked list
        if node.previous is not None:
            node.previous.next = node.next
            node.next.previous = node.previous
        
        # Move node to the end (just before the tail)
        node.next = self.tail
        node.previous = self.tail.previous
        self.tail.previous.next = node
        self.tail.previous = node

    def get(self, key: int) -> int:
        if key not in self.position:
            return -1

        # Retrieve node and update it to the end
        node = self.position[key]
        self.update_node(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        if key in self.position:
            # Update existing node's value
            node = self.position[key]
            node.value = value
            # Move it to the end
            self.update_node(node)
        else:
            # Create a new node
            if len(self.lookup) >= self.capacity:
                # Evict the least recently used item (head.next is the least recently used)
                node_to_remove = self.head.next
                self.head.next = node_to_remove.next
                node_to_remove.next.previous = self.head
                del self.lookup[node_to_remove.key]
                del self.position[node_to_remove.key]

            # Insert the new node at the end
            node = Node(key, value)
            self.position[key] = node
            self.lookup[key] = value
            self.update_node(node)

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
