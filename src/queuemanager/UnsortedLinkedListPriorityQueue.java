
package queuemanager;

/**
 * Implementation of the PriorityQueue ADT using an unsorted linked list for storage.
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
public class UnsortedLinkedListPriorityQueue<T> implements PriorityQueue<T>{

    /**
     * private variables
     *  head index of queue
     *  size of linked list
     */
    private Node<PriorityItem<T>> head;
    private int size;
    
    /**
     * Constructor to create unsorted linked list
     */
    public UnsortedLinkedListPriorityQueue(){
        head = null;
        size = 0;
    }
    
    
    /**
     * Add the given item to the queue with the given priority.
     * 
     * @param item
     * @param priority
     */
    @Override
    public void add(T item, int priority){
        
        /**
         * create instance of item -> item, priority
         */
        PriorityItem<T> newItem = new PriorityItem<>(item, priority);
        /**
         * create instance of new node -> priorityItem
         */
        Node<PriorityItem<T>> newNode = new Node<>(newItem);
        
        /**
         * Check if empty
         * head = new node
         */
        if (head == null) {
            head = newNode;
        } else {
            /**
             * create variables to store temp and previous
             */
            Node<PriorityItem<T>> temp = head;
            Node<PriorityItem<T>> previous = null;
            
            /**
             * while loop
             */
            while (temp != null && temp.getData().getPriority() <= priority) {
                previous = temp;
                temp = temp.getNextNode();
            }
            
            /**
             * check if previous node is null
             */
            if(previous == null){
                newNode.setNextNode(head);
                head = newNode;
            } else{
                previous.setNextNode(newNode);
                newNode.setNextNode(temp);
            }
        }
        
        /**
         * increment size of list
         */
        size++;
    }

    /**
     * The highest priority item stored.
     * 
     * @return The item with the highest priority
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
     * Remove the highest priority item from the queue
     * @throws QueueUnderflowException 
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if(size == 0 || head == null){
            throw new QueueUnderflowException();
        }
        
        head = head.getNextNode();
        size--;
    }

    /**
     * Check if linked list is empty
     * @return true - if there are no items stored
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
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
        if(size == 0){
            return "[]";
        } else{
            String result = null;
            result += "[";
          
            Node<PriorityItem<T>> temp = head;
          
            /**
            * Loop through queue
            */
            
            while(temp != null){
                result += temp.getData().toString();
                temp = temp.getNextNode();
                if(temp != null){
                    result += ", ";
                }
            }
            
            result = result + "]";
            return result;
        }
    }
    
}
