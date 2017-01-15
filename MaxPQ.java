import java.util.NoSuchElementException;

public class MaxPQ
{
    private static Integer[] heap;
    private static int size;
    
    public static void main(String[] args)
    {
        heap = new Integer[10];
        heap[1] = 5;
        heap[2] = 4;
        heap[3] = 4;
        heap[4] = 3;
        
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
            System.out.print("No more room in the heap.");
        }
    }
    
    public static int delMax()
    {
        if (isEmpty()) throw new NoSuchElementException(); // Cannot return anything if heap is empty.
        
        int max = heap[1]; // Save the max value.
        swap(1, size); // Swap the max value at the top of the heap with the last.
        heap[size--] = null; // Decrease the size of the heap and make the previous last value null (the max);
        sink(1); // Sink the value now at the top to its correct competence.

        return max; // Return the max value that was removed.
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
            if (j < size && isLess(j, j + 1)) j++; // If the second child exists and is greater than the first, set j to the second child. 
            if (!isLess(k, j)) break; // If k is greater than the greater of its children, break.
            swap(k, j); // Swap k with its child.
            k = j; // k now points to its child.           
        }
    }
    
    private static void swim(int k)
    {
        while (k > 1 && isLess(k/2, k)) // Check to see if not at root node and that the parent of k is less than k.
        {
            swap(k, k/2); // If the k is greater than its parent, swap them.
            k /= 2; // k now points to its parent.
        }
    }
    
    private static boolean isLess(Integer v, Integer w)
    {
        return heap[v].compareTo(heap[w]) < 0;
    }
    
    private static void swap(int v, int w)
    {
        int swap = heap[v];
        heap[v] = heap[w];
        heap[w] = swap;
    }
}