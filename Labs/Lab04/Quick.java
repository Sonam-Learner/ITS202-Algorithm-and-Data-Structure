public class Quick {

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(int[] a) {
    
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(int[] a, int lo, int hi) { 
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(int[] a, int lo, int hi) {
        
    }



   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(int v, int w) {
        
    }
        
    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(int[] a) {
        
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        
    }


    // print array to standard output
    private static void show(int[] a) {
        
    }

    /**
     * Reads in a sequence of values ; quicksorts them; 
     * and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int[] a = {4,5,6,7};
        Quick.sort(a);
        show(a);
        assert isSorted(a);

    }

}