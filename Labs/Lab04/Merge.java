public class Merge {

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(int[] a, int[] aux, int lo, int hi) {
    	if (hi <= lo){System.out.println("reached return"); return;}
        int mid = (lo + hi) / 2;
        // System.out.println(mid);
        sort(a, aux, lo, mid);
        // System.out.println("so"+lo);
        //   System.out.println("so"+mid);
        // System.out.println("left");
        sort(a, aux, mid + 1, hi);
        // System.out.println(mid+1);
        // System.out.println(hi);
        // System.out.println("hhi");
        merge(a, aux, lo, mid, hi);
        // System.out.println(lo);
        // System.out.println(mid);
        // System.out.println(hi);
        // System.out.println("Merge");
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length-1);
    }

   /***************************************************************************
    *  Helper sorting function.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    // print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(" "+a[i]);
        }
        System.out.println();
    }
    /**
     * Reads in a sequence of strings from standard input; mergesorts them; 
     * and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
    	int[] a = {9,7,8,3,2,1};
        Merge.sort(a);
        show(a);
    }
}
