package org.karthik.learning.lru;

/**
 * Represents a linked list datastructure.
 */
public class DoublyLinkedList {
    private Node head;
    private Node tail;

    /**
     * Adds a node to the front of {@link DoublyLinkedList}.
     * @param node The node to be added to the front.
     */
    public void addToTheFront(Node node) {

        //If head is null, newNode is the first node in the linked list.
        if(this.head == null) {
            this.head = node;
            this.tail = node;
        } else { //Else, we add the new node in the front.
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    /**
     * Moves a node to the front of the {@link DoublyLinkedList}.
     * @param node The node to be moved to the front.
     */
    public void moveToTheFront(Node node) {
        if(node.prev == null) { //Already the head.
            return;
        }

        if(node == this.tail) {
            this.tail = node.prev;
            this.tail.next = null;
        }

        node.prev = null;
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    /**
     * Removes the tail node.
     */
    public Node removeTailNode() {
        Node tail = this.tail;

        if(tail.prev != null) {
            Node tailPrev = tail.prev;

            //Break the previous and next links.
            if(tailPrev != null) {
                tailPrev.next = null;
            }
            tail.prev = null;
            this.tail = tailPrev;
        }

        //Update tail to the node before tail.

        return tail;
    }
}
