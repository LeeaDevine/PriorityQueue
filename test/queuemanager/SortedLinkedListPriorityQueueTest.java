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
 * Testing JUnit4 -> Class SortedLinkedList
 * 
 * @author Lee Devine
 */
public class SortedLinkedListPriorityQueueTest {
    
    private SortedLinkedListPriorityQueue<Person> queue;
    
    @Before
    public void setUp() {
        queue = new SortedLinkedListPriorityQueue<>();
    }
    
    @After
    public void tearDown() {
        queue = null;
    }

    /**
     * Test of add method, of class SortedLinkedListPriorityQueue.
     * 
     * list is sorted -> so when last item is added (david, 12) - 
     * that item will be head() of the list because it is highest priority.
     */
    @Test
    public void testAdd() {
            Person person1 = new Person("lee");
            Person person2 = new Person("mary");
            Person person3 = new Person("david");
            
            queue.add(person1, 10);
            queue.add(person2, 8);
            queue.add(person3, 12);
            
            try{
                assertEquals("david", queue.head().getName());
            } catch(QueueUnderflowException e){
                fail("Failed Test: " + e);
            }   
    }

    /**
     * Test of head method, of class SortedLinkedListPriorityQueue.
     */
    @Test
    public void testHead() {
        Person person1 = new Person("lee");
        Person person2 = new Person("mary");

        queue.add(person1, 10);
        queue.add(person2, 8);

        try{
            assertEquals("lee", queue.head().getName());
        } catch(QueueUnderflowException e){
            fail("Failed Test: " + e);
        }   
    }

    /**
     * Test of head() method, of class SortedLinkedListPriorityQueue.
     * Check for Exceptions
     * @throws queuemanager.QueueUnderflowException
     */
    @Test(expected = QueueUnderflowException.class)
    public void testHeadException() throws QueueUnderflowException {
       queue.head();
    }

    /**
     * Test of remove method, of class SortedLinkedListPriorityQueue.
     */
    @Test
    public void testRemove() {
        Person person1 = new Person("lee");
        Person person2 = new Person("mary");

        queue.add(person1, 10);
        queue.add(person2, 8);

        try{
            queue.remove();
            assertEquals("mary", queue.head().getName());
        } catch(QueueUnderflowException e){
            fail("Failed Test: " + e);
        }  
    }
    
    /**
     * Test of remove() method, of class SortedLinkedListPriorityQueue.
     * Check for Exceptions
     * @throws queuemanager.QueueUnderflowException
     */
    @Test(expected = QueueUnderflowException.class)
    public void testRemoveException() throws QueueUnderflowException {
       queue.remove();
    }
    
    /**
     * Test of isEmpty() method, of class SortedLinkedListPriorityQueue.
     */
    @Test
    public void testIsEmpty(){
        assertTrue(queue.isEmpty());
        
        queue.add(new Person("lee"), 10);
        
        assertFalse(queue.isEmpty());
    }


    /**
     * Test of toString method, of class SortedLinkedListPriorityQueue.
     */
    @Test
    public void testToString() {
        Person person1 = new Person("lee");
        Person person2 = new Person("mary");
        Person person3 = new Person("david");
        
        queue.add(person1, 10);
        queue.add(person2, 8);
        queue.add(person3, 12);
        
        String expected = "[(david, 12), (lee, 10), (mary, 8)]";
        assertEquals(expected, queue.toString());   
    }
    
}
