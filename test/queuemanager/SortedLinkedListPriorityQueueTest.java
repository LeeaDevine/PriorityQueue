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
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object item = null;
        int priority = 0;
        SortedLinkedListPriorityQueue instance = new SortedLinkedListPriorityQueue();
        instance.add(item, priority);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of head method, of class SortedLinkedListPriorityQueue.
     */
    @Test
    public void testHead() throws Exception {
        System.out.println("head");
        SortedLinkedListPriorityQueue instance = new SortedLinkedListPriorityQueue();
        Object expResult = null;
        Object result = instance.head();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class SortedLinkedListPriorityQueue.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        SortedLinkedListPriorityQueue instance = new SortedLinkedListPriorityQueue();
        instance.remove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class SortedLinkedListPriorityQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SortedLinkedListPriorityQueue instance = new SortedLinkedListPriorityQueue();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class SortedLinkedListPriorityQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SortedLinkedListPriorityQueue instance = new SortedLinkedListPriorityQueue();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
