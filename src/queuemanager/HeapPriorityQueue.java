
package queuemanager;

/**
 * Implementation of the PriorityQueue ADT using a sorted array for storage.
 * 
 * @references
 * Abdui Bari (2019). 2.6.3 Heap - Heap Sort - Heapify - Priority Queue - Youtube. [online] www.youtube.com. Available at: https://www.youtube.com/watch?v=HqPJF2L5h9U.
 * Buchalka, T. (2021). Complete Java Software Developer Masterclass (for Java 10). [online] Udemy. Available at: https://www.udemy.com/course/java-the-complete-java-developer-course/.
 * Bro Code (2021). Data Structures and Algorithms Full Course 【𝙁𝙧𝙚𝙚】. YouTube. Available at: https://www.youtube.com/watch?v=CBYHwZcbD-s [Accessed 21 Jul. 2022].
 * FreeCodeCamp (2019). Data Structures Easy to Advanced Course - Full Tutorial from a Google Engineer. [online] www.youtube.com. Available at: https://www.youtube.com/watch?v=RBSGKlAvoiM.
 * GeeksForGeeks (2018). Max Heap in Java. [online] GeeksforGeeks. Available at: https://www.geeksforgeeks.org/max-heap-in-java/.
 * 
 * @param <T> The type of things being stored.
 * 
 * @author Lee Devine
 */
public class HeapPriorityQueue<T> implements PriorityQueue<T>{
        
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
     * Add item to the priority queue with the given priority
     * Throw an exception if it's already full capacity.
     * 
     * @param item
     * @param priority
     * @throws QueueOverflowException 
     */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        
        //Increment tailIndex to next available position.
        tailIndex++;
        
        //Check if capacity has been reached.
        if(tailIndex >= capacity){
            //if true -> decrement tailIndex and throw exception.
            tailIndex = tailIndex -1;
            throw new QueueOverflowException();
        }
        else{
            //if false -> insert new Priority Item at the tailIndex.
            storage[tailIndex] = new PriorityItem<>(item, priority);
            
            /**
             * Max Heapify
             * Move the new added item to maintain max heap
             */
            int index = tailIndex;
            int parentIndex = (index - 1) / 2;
            while(index > 0 && compare(index, parentIndex) > 0){
                swap(index, parentIndex);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            }
        }
    }

    /**
     * Return the highest priority item in the queue.
     * Throw an exception if it's empty.
     * 
     * @return Item with the highest priority
     * @throws QueueUnderflowException 
     */
    @Override
    public T head() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        else{
            return ((PriorityItem<T>) storage[0]).getItem();
        }
    }

    /**
     * Remove the highest priority item from the queue
     * Throw an exception if it's empty.
     * 
     * @throws QueueUnderflowException 
     */
    @Override
    public void remove() throws QueueUnderflowException {
        //Check if the heap is empty
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        else{
            // Swap root[highest priority] with last item
            swap(0, tailIndex);
            
            //Decrement tailIndex to remove highest priority
            tailIndex = tailIndex - 1;
            
            // Max Heapify -> Move items to maintain max heap
            heapify(0);
        }
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
    
    /**
     * Compare the values of two elements in the heap
     * 
     * @param index1 -> index of first element to be compared
     * @param index2 -> index of second element to be compared
     * @return the difference between the priorities
     */
    private int compare(int index1, int index2){
        return 
            ((PriorityItem<T>) storage[index1]).getPriority() -
            ((PriorityItem<T>) storage[index2]).getPriority();
    }
    
    /**
     * Swap the elements of the heap
     * 
     * @param index1 -> the index of first element to be swapped
     * @param index2 -> the index of second element to be swapped
     */
    private void swap(int index1, int index2){
        Object temp = storage[index1];
        storage[index1] = storage[index2];
        storage[index2] = temp;
    }
    
    /**
     * Heapify the heap
     * 
     * This method moves a value down the heap until it finds its correct place.
     * It compares the value with its children and swapping it to maintain the max heap.
     * 
     * @param index -> The index of the root node.
     */
    private void heapify(int index){
        
        //Calculate left and right children
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int maxIndex = index;
        
        //Check if left child exists and is greater than current max.
        if(leftChildIndex <= tailIndex && compare(leftChildIndex, maxIndex) > 0){
            maxIndex = leftChildIndex;
        }
        
        //Check if right child exists and is greater than current max.
        if(rightChildIndex <= tailIndex && compare(rightChildIndex, maxIndex) > 0){
            maxIndex = rightChildIndex;
        }
        
        //if either child is greater, swap them.
        if(maxIndex != index){
            swap(index, maxIndex);
            heapify(maxIndex);
        }
    }
}
