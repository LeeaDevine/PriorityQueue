/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package queuemanager;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing Class -> SortedArrayPriorityQueue
 * 
 * @author Lee Devine
 */
public class SortedArrayPriorityQueueTest {

    private SortedArrayPriorityQueue<Person> queue;

    @Before
    public void setUp() {
        queue = new SortedArrayPriorityQueue<>(8);
    }

    /**
     * 
     * @throws QueueOverflowException
     * @throws QueueUnderflowException 
     */
    @Test
    public void testAdd() throws QueueOverflowException, QueueUnderflowException {
        assertTrue(queue.isEmpty());
        queue.add(new Person("Lee"), 5);
        assertFalse(queue.isEmpty());
        assertEquals("Lee", queue.head().getName());
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
     * 
     * @throws QueueOverflowException 
     */
    @Test(expected = QueueOverflowException.class)
    public void testAddOverflow() throws QueueOverflowException {
        for (int i = 0; i < 9; i++) {
            queue.add(new Person("Person " + i), i);
        }
    }

    /**
     * 
     * @throws QueueOverflowException
     * @throws QueueUnderflowException 
     */
    @Test
    public void testHead() throws QueueOverflowException, QueueUnderflowException {
        queue.add(new Person("Lee"), 5);
        queue.add(new Person("Mary"), 10);
        assertEquals("Mary", queue.head().getName());
    }

    /**
     * 
     * @throws QueueUnderflowException 
     */
    @Test(expected = QueueUnderflowException.class)
    public void testHeadUnderflow() throws QueueUnderflowException {
        queue.head();
    }

    /**
     * 
     * @throws QueueOverflowException
     * @throws QueueUnderflowException 
     */
    @Test
    public void testRemove() throws QueueOverflowException, QueueUnderflowException {
        queue.add(new Person("Lee"), 5);
        queue.add(new Person("Mary"), 10);
        assertFalse(queue.isEmpty());
        queue.remove();
        assertFalse(queue.isEmpty());
        assertEquals("Lee", queue.head().getName());
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

    /**
     * 
     * @throws QueueUnderflowException 
     */
    @Test(expected = QueueUnderflowException.class)
    public void testRemoveUnderflow() throws QueueUnderflowException {
        queue.remove();
    }

    /**
     * 
     * @throws QueueOverflowException 
     */
    @Test
    public void testIsEmpty() throws QueueOverflowException {
        assertTrue(queue.isEmpty());
        
        queue.add(new Person("lee"), 10);
        
        assertFalse(queue.isEmpty());
    }

    /**
     * 
     * @throws QueueOverflowException 
     */
    @Test
    public void testToString() throws QueueOverflowException {
        assertEquals("[]", queue.toString());
        queue.add(new Person("Lee"), 5);
        assertEquals("[(Lee, 5)]", queue.toString());
        queue.add(new Person("Mary"), 10);
        assertEquals("[(Mary, 10), (Lee, 5)]", queue.toString());
    }
}


