package queuemanager;

/**
 * Implementation of the PriorityQueue ADT using an unsorted array for storage.
 * 
 * @references
 * Buchalka, T. (2021). Complete Java Software Developer Masterclass (for Java 10). [online] Udemy. Available at: https://www.udemy.com/course/java-the-complete-java-developer-course/.
 * Bro Code (2021). Data Structures and Algorithms Full Course 【𝙁𝙧𝙚𝙚】. YouTube. Available at: https://www.youtube.com/watch?v=CBYHwZcbD-s [Accessed 21 Jul. 2022].
 * FreeCodeCamp (2019). Data Structures Easy to Advanced Course - Full Tutorial from a Google Engineer. [online] www.youtube.com. Available at: https://www.youtube.com/watch?v=RBSGKlAvoiM.
 * 
 * @param <T> The type of things being stored.
 * 
 * @author Lee Devine
 */
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {
    
    /**
     * Where the data is actually stored.
     */
    private final Object[] storage;


    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    private int tailIndex;

    /**
     * Create a new empty queue of the given size.
     *
     * @param size
     */
    public UnsortedArrayPriorityQueue(int size) {
        storage = new Object[size];
        tailIndex = -1;
    }
    
    /**
     * Helper Method
     * Find the highest priority item from the array
     * 
     * @return headPosition -> largest priority value
     * @throws QueueUnderflowException 
     */
    private int getHighestPriorityItem() throws QueueUnderflowException{
        
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        
        /**
         * create head pointer
         * loop through array and find largest priority value
         */
        int headPosition = tailIndex;
        for(int i = tailIndex; i >= 0; --i){
        
            /**
             * Create 2 integer variables to keep track of current highest priority
             * and what the next priority index is.
             */
            int currentPriority = ((PriorityItem<T>)storage[headPosition]).getPriority();
            int nextPriority = ((PriorityItem<T>)storage[i]).getPriority();
            
            /**
             * compare current greater than next
             * set new highest priority / else keep looping
             */
            headPosition = (currentPriority > nextPriority) ? headPosition : i;
        }
        return headPosition;
    }
    
    /**
     * display highest priority item in unsorted array
     * 
     * @return index of item that has highest priority using helper method -> getHighestPriorityItem()
     * @throws QueueUnderflowException 
     */
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            /**
             * use helper method -> getHighestPriorityItem
             * @return highest priority item
             */
            int headPosition = getHighestPriorityItem();
            return ((PriorityItem<T>)storage[headPosition]).getItem();
        }
    }

    /**
     * add new item to end of list
     * as array is unsorted -> we do not need to do anything else
     * 
     * @param item
     * @param priority
     * @throws QueueOverflowException 
     */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        
        if(tailIndex >= storage.length -1){
            throw new QueueOverflowException();
        } else{
            tailIndex++;
            storage[tailIndex] = new PriorityItem<>(item, priority);
        }
    }

    /**
     * 
     * @throws QueueUnderflowException 
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            
            /**
             * user helper method -> getHighestPriorityItem
             * remove headPosition = highest priority 
             * decrement array by 1
             */
            int headPosition = getHighestPriorityItem();
            storage[headPosition] = storage[tailIndex];
            
            tailIndex--;
        }
    }

    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tailIndex; ++i) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
    
}
