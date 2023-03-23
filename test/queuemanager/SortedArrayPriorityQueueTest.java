/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package queuemanager;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leead
 */
public class SortedArrayPriorityQueueTest {

    @Test
    public void testAddAndHead() throws Exception {
        SortedArrayPriorityQueue<Person> queue = new SortedArrayPriorityQueue<>(5);
        queue.add(new Person("Lee"), 3);
        queue.add(new Person("Mary"), 1);
        queue.add(new Person("David"), 2);
        queue.add(new Person("Leon"), 5);
        queue.add(new Person("Frank"), 4);
        assertEquals("Leon", queue.head().getName());
    }

    @Test
    public void testRemove() throws Exception {
        SortedArrayPriorityQueue<Person> queue = new SortedArrayPriorityQueue<>(5);
        queue.add(new Person("Lee"), 3);
        queue.add(new Person("Mary"), 1);
        queue.add(new Person("David"), 2);
        queue.add(new Person("Leon"), 5);
        queue.add(new Person("Frank"), 4);
        queue.remove();
        assertEquals("Leon", queue.head().getName());
    }

    @Test
    public void testIsEmpty() throws Exception {
        SortedArrayPriorityQueue<Person> queue = new SortedArrayPriorityQueue<>(5);
        assertTrue(queue.isEmpty());
        queue.add(new Person("Lee"), 3);
        assertFalse(queue.isEmpty());
        queue.remove();
        assertTrue(queue.isEmpty());
    }

    @Test(expected = QueueOverflowException.class)
    public void testAddFullQueue() throws Exception {
        SortedArrayPriorityQueue<Person> queue = new SortedArrayPriorityQueue<>(3);
        queue.add(new Person("Lee"), 3);
        queue.add(new Person("Mary"), 1);
        queue.add(new Person("David"), 2);
        // This should throw a QueueOverflowException
        queue.add(new Person("Leon"), 4);
    }

    @Test(expected = QueueUnderflowException.class)
    public void testHeadEmptyQueue() throws Exception {
        SortedArrayPriorityQueue<Person> queue = new SortedArrayPriorityQueue<>(5);
        // This should throw a QueueUnderflowException
        queue.head();
    }

    @Test(expected = QueueUnderflowException.class)
    public void testRemoveEmptyQueue() throws Exception {
        SortedArrayPriorityQueue<Person> queue = new SortedArrayPriorityQueue<>(5);
        // This should throw a QueueUnderflowException
        queue.remove();
    }
}

