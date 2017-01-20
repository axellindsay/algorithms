public class HeapSortPlayground
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
              
        heapsort(a);
    }
    
    private static void heapsort(Integer[] a)
    {
        int n = a.length;
        
        for (int k = n / 2; k >= 1; k--)
        {
            sink(a, k, n);
        }
        
        while (n > 1)
        {
            swap(a, 1, n);
            sink(a, 1, --n);
        }
        
        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }
        
    private static void sink(Integer[] a, int k, int n)
    {
        while (2 * k <= n)
        {
            int j = 2 * k;
            if (j  < n && isLess(a, j, j + 1)) { j++; }
            if (!isLess(a, k, j)) { break;}
            swap(a, k, j);
            k = j;
        }
    }
    
    private static boolean isLess(Integer[] a, Integer v, Integer w)
    {
        return a[v - 1].compareTo(a[w - 1]) < 0;
    }
    
    private static void swap(Integer[] a, Integer v, Integer w)
    {
        Integer swap = a[v - 1];
        a[v - 1] = a[w - 1];
        a[w - 1] = swap;
    }
}