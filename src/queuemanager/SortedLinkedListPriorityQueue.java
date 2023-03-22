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

    //TODO: 
    /*
    1. create node class -> help move between address of the linked list
    2. implement into PriorityQueue methods head(), add(), remove(), isEmpty()
    3. sort linked list
    4. working version 1.0
    5. other...
    */
    
    /**
     * 
     * @param item
     * @param priority
     * @throws QueueOverflowException 
     */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
       
    }

    /**
     * 
     * @return
     * @throws QueueUnderflowException 
     */
    @Override
    public T head() throws QueueUnderflowException {
         if(isEmpty()){
             throw new QueueUnderflowException();
         }
    }

    /**
     * 
     * @throws QueueUnderflowException 
     */
    @Override
    public void remove() throws QueueUnderflowException {
       
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean isEmpty() {
        
    }
    
    public 
    
}
