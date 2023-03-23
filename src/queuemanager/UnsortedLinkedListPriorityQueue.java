
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
     */
    private Node<PriorityItem<T>> head;
    
    
    /**
     * Add to the queue
     * Unsorted -> no additional features.
     * add node to list
     * 
     * @param item
     * @param priority
     */
    @Override
    public void add(T item, int priority){
        
        /**
         * create instance of item -> item, priority
         */
        PriorityItem<T> priorityItem = new PriorityItem<>(item, priority);
        /**
         * create instance of new node -> priorityItem
         */
        Node<PriorityItem<T>> newNode = new Node<>(priorityItem);
        
        /**
         * Check if empty
         * head = new node
         */
        if (isEmpty()) {
            head = newNode;
        } else {
            /**
             * create currentNode = head
             */
            Node<PriorityItem<T>> currentNode = head;
            /**
             * while loop
             */
            while(currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }

    /**
     * The highest priority item stored.
     * 
     * Uses helper method -> get highestPriorityNode
     * 
     * @return The item with the highest priority
     * @throws QueueUnderflowException 
     */
    @Override
    public T head() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        
        /**
         * keep track of highest priority
         */
        Node<PriorityItem<T>> currentNode = head;
        Node<PriorityItem<T>> highestPriorityNode = head;
        
        /**
         * while loop
         */
        while(currentNode != null){
            if(currentNode.getData().getPriority() > highestPriorityNode.getData().getPriority()) {
                highestPriorityNode = currentNode;
            }
            currentNode = currentNode.getNextNode();
        }
        return highestPriorityNode.getData().getItem();
    }

    /**
     * Remove the highest priority item from the queue
     * 
     * Uses helper method -> get highestPriorityNode
     * 
     * @throws QueueUnderflowException 
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        
        /**
         * keep track of current, previous, highest
         */
        Node<PriorityItem<T>> currentNode = head;
        Node<PriorityItem<T>> previousNode = head;
        Node<PriorityItem<T>> highestPriorityNode = head;
        
        /**
         * while loop
         */
        while(currentNode.getNextNode() != null){
            if(currentNode.getNextNode().getData().getPriority() > highestPriorityNode.getData().getPriority()) {
                highestPriorityNode = currentNode.getNextNode();
                previousNode = currentNode;
            }
            currentNode = currentNode.getNextNode();
        }
        
        //remove highest priority node
        if(previousNode == null){
            head = highestPriorityNode.getNextNode();
        }else{
            previousNode.setNextNode(highestPriorityNode.getNextNode());
        }
    }

    /**
     * Check if linked list is empty
     * @return true - if there are no items stored
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
          
            Node<PriorityItem<T>> currentNode = head;
          
            /**
            * Loop through queue
            */
            while(currentNode != null){
                result += currentNode.getData().toString();
                currentNode = currentNode.getNextNode();
                if(currentNode != null){
                    result += ", ";
                }
            }
            result = result + "]";
            return result;
        }
    }
}
