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

    private Node<T> headNode;
    
    public SortedLinkedListPriorityQueue(){
        headNode = null;
    }
    
    /**
     * 
     * @param item
     * @param priority
     * @throws QueueOverflowException 
     */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        
        //create new instance of data(item, priority)
        PriorityItem<T> newItem = new PriorityItem<>(item, priority);
        
        //create new instance of new node
        Node newNode = new Node(newItem);
        
        if(headNode == null){
            headNode = newNode;
        }
        
        //create variables to store temp and previous nodes
        Node temp = headNode;
        Node previous = null;
        
        while(temp != null && ((PriorityItem)temp.getData()).getPriority() < priority){
            previous = temp;
            temp = temp.getNextNode();
        }
        
        if(temp == null){
            System.out.println("test1");
//            previous.setNextNode(newNode);
        } else{
            
            if(previous == null){
                newNode.setNextNode(headNode);
                headNode = newNode;
            } else{
                newNode.setNextNode(temp);
                previous.setNextNode(newNode);
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
         return headNode.getData();
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
        headNode = headNode.getNextNode();
    }

    /**
     * Check if linked list is empty
     * @return headNode has no value;
     */
    @Override
    public boolean isEmpty() {
        return headNode == null;
    }
    
    /**
     * 
     * @return string of result; 
     */
    @Override
    public String toString(){
        String result = "[";
        
        /**
         * loop through nodes
         */
        for(Node<T> node = headNode; node != null; node = node.getNextNode()){
            if(node != headNode){
                result = result + ", ";
            }
            result = result + node.getData();
        }
        result = result + "]";
        return result;
        
    }
    
}
