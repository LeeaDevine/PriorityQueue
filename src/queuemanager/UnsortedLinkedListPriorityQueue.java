
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
     * head index of queue
     */
    private Node<PriorityItem<T>> head;
    
    
    /**
     * Add to the queue
     * Unsorted -> no additional features.
     * add node to end of list
     * 
     * @param item
     * @param priority
     */
    @Override
    public void add(T item, int priority){
        
        // Create a new PriorityItem with given (item, priority)
        PriorityItem<T> priorityItem = new PriorityItem<>(item, priority);
        
        // Create new node with priorityItem
        Node<PriorityItem<T>> newNode = new Node<>(priorityItem);
        
        //if the list is empty, set the head to new node.
        if (isEmpty()) {
            head = newNode;
        } else {
            //Iterate to end of list
            Node<PriorityItem<T>> currentNode = head;

            while(currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
            
            //Add the new node to the end of the list
            currentNode.setNextNode(newNode);
        }
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
        
        /**
         * Initialize current and highestPriority to the head.
         */
        Node<PriorityItem<T>> currentNode = head;
        Node<PriorityItem<T>> highestPriorityNode = head;
        
        /**
         * Iterate through the linked list to find highest priority node.
         */
        while(currentNode != null){
            if(currentNode.getData().getPriority() > highestPriorityNode.getData().getPriority()) {
                highestPriorityNode = currentNode;
            }
            currentNode = currentNode.getNextNode();
        }
        
        //Return the item of the highest priority.
        return highestPriorityNode.getData().getItem();
    }

    /**
     * Remove the highest priority item from the queue

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
        Node<PriorityItem<T>> previousNode = null;
        Node<PriorityItem<T>> highestPriorityNode = head;
        Node<PriorityItem<T>> previousHighestPriorityNode = null;
        
        /**
         * Iterate through the linked list to find:
         * highest priority node and its previous node.
         */
        while(currentNode != null){
            if(currentNode.getData().getPriority() > highestPriorityNode.getData().getPriority()) {
                highestPriorityNode = currentNode;
                previousHighestPriorityNode = previousNode;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        
        //remove highest priority node from the linked list
        if(previousHighestPriorityNode == null){
            head = highestPriorityNode.getNextNode();
        }else{
            previousHighestPriorityNode.setNextNode(highestPriorityNode.getNextNode());
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
