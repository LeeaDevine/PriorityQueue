
package queuemanager;

/**
 * Implementation of the PriorityQueue ADT using a sorted array for storage.
 * 
 * @references
 * Abdui Bari (2019). 2.6.3 Heap - Heap Sort - Heapify - Priority Queue - Youtube. [online] www.youtube.com. Available at: https://www.youtube.com/watch?v=HqPJF2L5h9U.
 * Buchalka, T. (2021). Complete Java Software Developer Masterclass (for Java 10). [online] Udemy. Available at: https://www.udemy.com/course/java-the-complete-java-developer-course/.
 * Bro Code (2021). Data Structures and Algorithms Full Course 【𝙁𝙧𝙚𝙚】. YouTube. Available at: https://www.youtube.com/watch?v=CBYHwZcbD-s [Accessed 21 Jul. 2022].
 * FreeCodeCamp (2019). Data Structures Easy to Advanced Course - Full Tutorial from a Google Engineer. [online] www.youtube.com. Available at: https://www.youtube.com/watch?v=RBSGKlAvoiM.
 * 
 * @param <T> The type of things being stored.
 * 
 * @author Lee Devine
 */
public class HeapPriorityQueue<T> implements PriorityQueue<T>{
    
    /**
     * TODO LIST:
     *      add(), head(), remove()
     *      compare/find highest priority and swap
     *      parent and child node
     *      heapify?
     *      working version1.0
     */
    
    /**
     * Where the data is actually stored.
     */
    private final Object[] storage;

    /**
     * The size of the storage array.
     */
    private final int capacity;

    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    private int tailIndex;
    
    /**
     * Create new empty queue of the given size
     * @param size 
     */
    public HeapPriorityQueue(int size){
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }

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
        
    }

    /**
     * 
     * @throws QueueUnderflowException 
     */
    @Override
    public void remove() throws QueueUnderflowException {
        
    }

    /**
     * Check if queue is empty.
     * @return True - if no items stored.
     */
    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }
    
    /**
     * A string representation of the queue
     * 
     * This should be formatted as a list, in square brackets.
     * 
     * Each item should be shown as an ordered pair (name, priority)
     * 
     * @return result 
     */
    @Override
    public String toString(){
        String result = "[";
        for(int i = 0; i <= tailIndex; i++){
            if(i > 0){
                result += ", ";
            }
            result += storage[i];
        }
        result += "]";
        return result;
    }
    
}
