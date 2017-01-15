import java.util.NoSuchElementException;

public class MinPQ
{
    private static Integer[] heap;
    private static int size;
    
    public static void main(String[] args)
    {
        heap = new Integer[10];
        heap[1] = 3;
        heap[2] = 4;
        heap[3] = 4;
        heap[4] = 5;
        
        size = 4;
    }
    
    public static void insert(Integer i)
    {
        if (size < heap.length - 1) // Check to see if next element will be in bounds of array.
        {
            heap[++size] = i; // If so, insert element.
            swim(size); // Then swim it to correct competence.
        }
        else
        {
            System.out.println("No more room in the heap.");
        }
        printHeap();
    }
    
    public static int delMin()
    {
        if (isEmpty()) throw new NoSuchElementException(); // Cannot return anything if heap is empty.
        
        int min = heap[1]; // Save the min value.
        swap(1, size); // Swap the min value at the top of the heap with the last element.
        heap[size--] = null; // Decrease the size of the heap and make the previous last value null.
        sink(1); // Sink the value now at the top to its correct competence.
        
        return min; // Return the min value that was removed.
    }
    
    public static boolean isEmpty()
    {
        return size == 0;
    }
    
    public static void printHeap()
    {
        for (int i = 0; i < heap.length; i++)
        {
            System.out.println(heap[i]);
        }
    }
    
    private static void sink(int k)
    {
        while (2 * k <= size) // Check to see if the child of k is within bounds.
        {
            int j = 2 * k; // Set to the first child of k.
            if (j < size && isGreater(j, j + 1)) j++; // If the second child exists and is less than the first, set j to the second child.
            if (!isGreater(k, j)) break; // If k is already less than the lesser of its children, break.
            swap(k, j); // Swap k with its child.
            k = j; // k now points to its child.
        }
    }
    
    private static void swim(int k)
    {
        while (k > 1 && isGreater(k/2, k)) // Check to see if not at root node and that the parent of k is greater than k.
        {
            swap(k, k/2); // If k is less than its parent, swap them.
            k /= 2; // k now points to its parent.
        }
    }
    
    private static boolean isGreater(Integer v, Integer w)
    {
        return heap[v].compareTo(heap[w]) > 0;
    }
    
    private static void swap(int v, int w)
    {
        Integer swap = heap[v];
        heap[v] = heap[w];
        heap[w] = swap;
    }
}