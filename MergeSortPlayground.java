public class MergeSortPlayground
{
    public static void main(String[] args)
    {
        int[] a = new int[8];
        int[] aux = new int[8];
        
        a[0] = 6;
        a[1] = 1;
        a[2] = 7;
        a[3] = 5;
        a[4] = 4;
        a[5] = 0;
        a[6] = 3;
        a[7] = 2;
              
        sort(a, aux, 0, a.length - 1);
    }
    
    private static void sort(int a[], int aux[], int lo, int hi)
    {
        if (hi <= lo)  return;
        
        int mid = (hi + lo) / 2;
        
        sort(a, aux, lo, mid); // Sort left side.
        sort(a, aux, mid + 1, hi); // Sort right side.
        merge(a, aux, lo, hi, mid); // Merge the sorted sides.
        
        // Test to watch sorting at each step.
        for (int i = 0; i < a.length; i ++)
        {
            System.out.print(a[i]);
        }
        System.out.println("");
    }
    
    private static void merge(int a[], int aux[], int lo, int hi, int mid)
    {
        /* First implementation. Refactored below.
        int pointer = lo;
        int i = lo; // Beginning of left side.
        int j = mid + 1; // Beginning of right side.
        
        for (int k = lo; k <= hi; k++)
        {
            aux[k] = a[k];
        }
        
        while (i <= mid && j <= hi) // While left and right sides are within their bounds.
        {
            if (isLess(aux[j], aux[i]))
            {
                a[pointer++] = aux[j++]; // Right side pointer is greater.
            }
            else
            {
                a[pointer++] = aux[i++]; // Left side pointer is greater, or equivalent.
            }
        }
        
        while (i <= mid) // Right side exhausted itself first, continue until left side does.
        {
            a[pointer++] = aux[i++];
        }
        
        while (j <= hi) // Left side exhausted itself first, continue until right side does.
        {
            a[pointer++] = aux[j++];
        }
        */
        
        for (int k = lo; k <= hi; k++)
        {
            aux[k] = a[k];
        }
        
        int i = lo;
        int j = mid + 1;
        
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (isLess(a[j], a[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
    
    private static boolean isLess(int v, int w)
    {
        return v - w < 0;
    }
}