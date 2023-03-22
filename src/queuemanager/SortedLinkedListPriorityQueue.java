package queuemanager;

/**
 * Implementation of the PriorityQueue ADT using a sorted linked list for storage.
 * 
 * @references
 * Buchalka, T. (2021). Complete Java Software Developer Masterclass (for Java 10). [online] Udemy. Available at: https://www.udemy.com/course/java-the-complete-java-developer-course/.
 * Bro Code (2021). Data Structures and Algorithms Full Course 【𝙁𝙧𝙚𝙚】. YouTube. Available at: https://www.youtube.com/watch?v=CBYHwZcbD-s [Accessed 21 Jul. 2022].
 * FreeCodeCamp (2019). Data Structures Easy to Advanced Course - Full Tutorial from a Google Engineer. [online] www.youtube.com. Available at: https://www.youtube.com/watch?v=RBSGKlAvoiM.
 * 0612 TV w/ NERDfirst (2017). Node-Based Data Structures in Java. [online] www.youtube.com. Available at: https://www.youtube.com/watch?v=PEdFSWJm0TA&t=446s [Accessed 21 Mar. 2023].
 * Amit-L (2018). Priority queue using singly linked-list. [online] Gist. Available at: https://gist.github.com/Amit-L/2753719e10c0a4e3d0040fae5d8c975c [Accessed 21 Mar. 2023].
 * 
 * @param <T> The type of things being stored.
 * 
 * @author Lee Devine
 */
public class SortedLinkedListPriorityQueue<T> implements PriorityQueue<T>{

    private Node<PriorityItem<T>> head;
    
    /**
     * Add the given item to the queue with the given priority.
     * 
     * @param item
     * @param priority
     * @throws QueueOverflowException 
     */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        
        PriorityItem<T> priorityItem = new PriorityItem<>(item, priority);
        Node<PriorityItem<T>> newNode = new Node<>(priorityItem);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<PriorityItem<T>> currentNode = head;
            while (currentNode.getNextNode() != null && 
               currentNode.getNextNode().getData().getPriority() > priority) {
            currentNode = currentNode.getNextNode();
            }
            if (currentNode.getData().getPriority() >= priority) {
                newNode.setNextNode(currentNode.getNextNode());
                currentNode.setNextNode(newNode);
            } else {
            newNode.setNextNode(head);
            head = newNode;
            }
        }     
    }

    /**
     * 
     * @return headNode data (item, priority)
     * @throws QueueUnderflowException 
     */
    @Override
    public T head() throws QueueUnderflowException {
         if(isEmpty()){
             throw new QueueUnderflowException();
         }
         return head.getData().getItem();
    }

    /**
     * remove headNode -> get nextNode in list
     * @throws QueueUnderflowException 
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        head.setNextNode(head.getNextNode());
    }

    /**
     * Check if linked list is empty
     * @return headNode has no value;
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * A string representation of the entire queue.
     *
     * This should be formatted as a list, in square brackets.
     *
     * Each item[Person->name] should be shown as an ordered pair in parentheses together with
     * its priority.
     * 
     * @return string of result; 
     */
    @Override
    public String toString(){
        String result = "[";
        
        /**
         * Loop through queue
         */
        Node<PriorityItem<T>> currentNode = head;
        while (currentNode != null) {
            result += (currentNode.getData().toString());
            currentNode = currentNode.getNextNode();
            if (currentNode != null) {
            result += (", ");
            }
        }
        
        result = result + "]";
        return result;
        
    }
    
}
