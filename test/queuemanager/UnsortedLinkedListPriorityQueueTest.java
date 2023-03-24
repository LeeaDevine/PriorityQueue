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
 * Testing JUnit4 -> Class Unsorted Linked List
 * 
 * @author Lee Devine
 */
public class UnsortedLinkedListPriorityQueueTest {
    
    private UnsortedLinkedListPriorityQueue<Person> queue;
    
    @Before
    public void setUp() {
        queue = new UnsortedLinkedListPriorityQueue<>();
    }
    
    @After
    public void tearDown() {
        queue = null;
    }

    /**
     * Test of add method, of class UnsortedLinkedListPriorityQueue.
     */
    @Test
    public void testAdd() {
        Person person1 = new Person("lee");
        Person person2 = new Person("mary");
        
        queue.add(person1, 10);
        queue.add(person2, 8);
        
        assertFalse(queue.isEmpty());
    }

    /**
     * Test of head method, of class UnsortedLinkedListPriorityQueue.
     * @throws queuemanager.QueueUnderflowException
     */
    @Test
    public void testHead() throws QueueUnderflowException{
        Person person1 = new Person("lee");
        Person person2 = new Person("mary");
        Person person3 = new Person("david");
        
        queue.add(person1, 10);
        queue.add(person2, 8);
        queue.add(person3, 12);
        
        try{
            assertEquals("david", queue.head().getName());
        }catch(QueueUnderflowException e){
            fail("Failed test: " + e);
        }
    }

    @Test(expected = QueueUnderflowException.class)
    public void testHeadException() throws QueueUnderflowException {
        queue.head();
    }
    
    /**
     * Test of remove method, of class UnsortedLinkedListPriorityQueue.
     * @throws queuemanager.QueueUnderflowException
     */
    @Test
    public void testRemove() throws QueueUnderflowException {
        Person person1 = new Person("lee");
        Person person2 = new Person("mary");
        Person person3 = new Person("david");
        
        queue.add(person1, 10);
        queue.add(person2, 8);
        queue.add(person3, 12);
        
        try{
            queue.remove();
            assertEquals("lee", queue.head().getName());
        }catch(QueueUnderflowException e){
            fail("Failed test: " + e);
        }
    }
    
    @Test(expected = QueueUnderflowException.class)
    public void testRemoveException() throws QueueUnderflowException {
        queue.remove();
    }

    /**
     * Test of isEmpty method, of class UnsortedLinkedListPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        
        queue.add(new Person("lee"), 10);
        
        assertFalse(queue.isEmpty());
    }

    /**
     * Test of toString method, of class UnsortedLinkedListPriorityQueue.
     */
    @Test
    public void testToString() {
        Person person1 = new Person("lee");
        Person person2 = new Person("mary");
        Person person3 = new Person("david");
        
        queue.add(person1, 10);
        queue.add(person2, 8);
        queue.add(person3, 12);
        
        String expected = "[(lee, 10), (mary, 8), (david, 12)]";
        assertEquals(expected, queue.toString());
    }
    
}
