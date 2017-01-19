public class QuickSortPlayground
{
    private Integer[] a;
    public static void main(String[] args)
    {
        Integer[] a = new Integer[8];
       
        a[0] = 6;
        a[1] = 1;
        a[2] = 7;
        a[3] = 5;
        a[4] = 4;
        a[5] = 0;
        a[6] = 3;
        a[7] = 2;
              
        quicksort(a, 0, a.length - 1);
    }
        
    private static void quicksort(Integer[] a, int lo, int hi)
    {
        if (hi <= lo) return; // Base case.
        
        int lt = lo; // Pointer for less than partition value.
        int gt = hi; // Pointer for greater than partition value.
        Integer v = a[lo]; // The partition value.
        int i = lo; // Pointer.
        
        while (i <= gt)
        {
            int compare = a[i].compareTo(v); // Compare the current pointer value to the partition value.
            if (compare > 0) { swap(a, i, gt--); } // If the current pointer value is greater, swap it with the value at the gt pointer, and decrease gt.
            else if (compare < 0) { swap(a, i++, lt++); } // If the current pointer value is lesser, swap it with the value at the lt pointer, and increase both lt and the pointer.
            else { i++; } // If the current pointer value equals the partition value, increase the current pointer value.
        }
        
        quicksort(a, lo, lt - 1); // Recursive left subarray, for any values less than the partition.
        quicksort(a, gt + 1, hi); // Recursive right subarray, for any values greater than the partition.
        
        System.out.println(isSorted(a, lo, hi));
    }
        
    private static void swap(Integer[] a, Integer v, Integer w)
    {
        Integer swap = a[v];
        a[v] = a[w];
        a[w] = swap;
    }
    
    private static boolean isSorted(Integer[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (a[i].compareTo(a[i-1]) < 0) return false;
        return true;
    }
}