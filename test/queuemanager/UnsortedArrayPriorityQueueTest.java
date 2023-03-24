/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package queuemanager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing Class -> SortedArrayPriorityQueue
 * 
 * @author Lee Devine
 */
public class UnsortedArrayPriorityQueueTest {
    
    private UnsortedArrayPriorityQueue<Person> queue;
    
    @Before
    public void setUp() {
        queue = new UnsortedArrayPriorityQueue<>(8);
    }
    
    @After
    public void tearDown() {
        queue = null;
    }

    /**
     * Test of head method, of class UnsortedArrayPriorityQueue.
     * @throws queuemanager.QueueOverflowException
     * @throws queuemanager.QueueUnderflowException
     */
    @Test
    public void testAddandHead() throws QueueOverflowException, QueueUnderflowException {
        Person person1 = new Person("Lee");
        Person person2 = new Person("Mary");
        
        queue.add(person1, 1);
        assertEquals(person1, queue.head());
        
        queue.add(person2, 5);
        assertEquals(person2, queue.head()); 
    }
    
        /**
     * 
     * @throws QueueOverflowException
     * @throws QueueUnderflowException 
     */
    @Test
    public void testAddSamePriority() throws QueueOverflowException, QueueUnderflowException {
        queue.add(new Person("lee"), 5);
        queue.add(new Person("mary"), 5);
        
        assertEquals("lee", queue.head().getName());
        
        queue.remove();
        assertEquals("mary", queue.head().getName());
    }

    /**
     * Test of add method, of class UnsortedArrayPriorityQueue.
     * @throws queuemanager.QueueOverflowException
     */
    @Test(expected = QueueOverflowException.class)
    public void testAddOverflow() throws QueueOverflowException {
        for (int i = 0; i < 9; i++) {
            queue.add(new Person("Person" + i), i);
        }
    }

    /**
     * Test of remove method, of class UnsortedArrayPriorityQueue.
     * @throws queuemanager.QueueOverflowException
     * @throws queuemanager.QueueUnderflowException
     */
    @Test
    public void testRemove() throws QueueOverflowException, QueueUnderflowException {
        Person person1 = new Person("Lee");
        Person person2 = new Person("Mary");
        
        queue.add(person1, 1);
        queue.add(person2, 5);
        
        queue.remove();
        assertEquals(person1, queue.head());   
    }
    
        /**
     * 
     * @throws QueueOverflowException
     * @throws QueueUnderflowException 
     */
    @Test
    public void testRemoveAll() throws QueueOverflowException, QueueUnderflowException {
        queue.add(new Person("Lee"), 5);
        queue.add(new Person("Mary"), 10);
        queue.add(new Person("David"), 12);
        
        queue.remove();
        queue.remove();
        queue.remove();
        
        assertTrue(queue.isEmpty());

    }
    
    @Test(expected = QueueUnderflowException.class)
    public void testRemoveUnderflow() throws QueueUnderflowException{
        queue.remove();
    }

    /**
     * Test of isEmpty method, of class UnsortedArrayPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    /**
     * Test of toString method, of class UnsortedArrayPriorityQueue.
     * @throws queuemanager.QueueOverflowException
     */
    @Test
    public void testToString() throws QueueOverflowException{
        Person person1 = new Person("Lee");
        Person person2 = new Person("Mary");
        
        queue.add(person1, 1);
        queue.add(person2, 5);
        
        String expected = "[(Lee, 1), (Mary, 5)]";
        assertEquals(expected, queue.toString());
    }
    
}
