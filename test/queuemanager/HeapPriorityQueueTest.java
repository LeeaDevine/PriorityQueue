/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package queuemanager;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lee Devine
 */
public class HeapPriorityQueueTest {
    
    private HeapPriorityQueue<Person> queue;
    
    @Before
    public void setUp(){
        queue = new HeapPriorityQueue<>(8);
    }
    
    /**
     * Test of add method, of class HeapPriorityQueue.
     * @throws queuemanager.QueueOverflowException
     * @throws queuemanager.QueueUnderflowException
     */
    @Test
    public void testAddAndHead() throws QueueOverflowException, QueueUnderflowException {
        Person person1 = new Person("lee");
        Person person2 = new Person("mary");
        Person person3 = new Person("david");
        
        queue.add(person1, 10);
        assertEquals("lee", queue.head().getName());
        
        queue.add(person2, 8);
        assertEquals("lee", queue.head().getName());
        
        queue.add(person3, 12);
        assertEquals("david", queue.head().getName());
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
     * Test of head method, of class HeapPriorityQueue.
     * @throws queuemanager.QueueUnderflowException
     */
    @Test(expected = QueueUnderflowException.class)
    public void testHeadException() throws QueueUnderflowException {
        queue.head();
    }

    /**
     * Test of remove method, of class HeapPriorityQueue.
     * @throws queuemanager.QueueOverflowException
     * @throws queuemanager.QueueUnderflowException
     */
    @Test
    public void testRemove() throws QueueOverflowException, QueueUnderflowException {
        Person person1 = new Person("lee");
        Person person2 = new Person("mary");
        Person person3 = new Person("david");
        
        queue.add(person1, 10);
        queue.add(person2, 8);
        queue.add(person3, 12);
        
        queue.remove();
        assertEquals("lee", queue.head().getName());
        
        queue.remove();
        assertEquals("mary", queue.head().getName());
        
    }
    
    /**
     * Test of remove method, of class HeapPriorityQueue.
     * @throws queuemanager.QueueUnderflowException
     */
    @Test(expected = QueueUnderflowException.class)
    public void testRemoveException() throws QueueUnderflowException {
        queue.remove();
    }

    /**
     * Test of isEmpty method, of class HeapPriorityQueue.
     * @throws queuemanager.QueueOverflowException
     */
    @Test
    public void testIsEmpty() throws QueueOverflowException{
        assertTrue(queue.isEmpty());
        
        queue.add(new Person("lee"), 10);
        
        assertFalse(queue.isEmpty());
    }
    
}
