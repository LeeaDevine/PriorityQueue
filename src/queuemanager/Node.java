

package queuemanager;

/**
 * Node class is being used to store item and then be able to link to nextNode and previousNode
 * Primarily used for LinkedList - sorted and unsorted.
 *
 * @references
 * 0612 TV w/ NERDfirst (2017). Node-Based Data Structures in Java. [online] www.youtube.com. Available at: https://www.youtube.com/watch?v=PEdFSWJm0TA&t=446s [Accessed 21 Mar. 2023].
 * Bro Code (2021b). Learn Data Structures and Algorithms for free. [online] www.youtube.com. Available at: https://www.youtube.com/watch?v=CBYHwZcbD-s&t=6100s [Accessed 21 Mar. 2023].
 * Amit-L (2018). Priority queue using singly linked-list. [online] Gist. Available at: https://gist.github.com/Amit-L/2753719e10c0a4e3d0040fae5d8c975c [Accessed 21 Mar. 2023].
 * 
 * @author Lee Devine
 */
public class Node<T> {
    
    /**
     * private variables
     * item - data (item, priority)
     * next node 
     */
    private T data;
    private Node<T> nextNode;
    
    /**
     * CONSTRUCTORS
     */
    public Node(T data){
        this.data = data;
    }
    
    /**
     * GETTERS AND SETTERS
     */
    
    /**
     * 
     * @return data currently stored in node 
     */
    public T getData(){
        return data;
    }
    
    /**
     * 
     * @return next node in linked list 
     */
    public Node<T> getNextNode(){
        return nextNode;
    }
    
    /**
     * Pointer for next node in linked list
     * @param nextNode 
     */
    public void setNextNode(Node<T> nextNode){
        this.nextNode = nextNode;
    }
    
}
