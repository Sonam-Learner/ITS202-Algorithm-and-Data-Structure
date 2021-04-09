import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public Solution() {
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size()==0;
       
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size(root);
       
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if(x == null) return 0;
        else return x.size;
       
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    // public boolean contains(Key key) {
       
    // }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if(root==null) return null;
        else return get(root,key);
       
    }

    private Value get(Node x, Key key) {
        while(x!=null)
        {
            int cmp = key.compareTo(x.key);
            if(cmp<0) x = x.left;
            else if(cmp>0) x = x.right;
            else return x.val;
        }
        return null;
        
        
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        int incre;
        if(get(key)==null) incre = 1;
        else incre = 0;
        Node z = new Node(key,val,1);
        if(root == null) root = z;
        else
        {
            Node parent = null, x = root;
            int cmp = 0;
            while(x!= null)
            {
                parent = x;
                parent.size+=incre;
                cmp = key.compareTo(parent.key);
                if(cmp<0) x = parent.left;
                else if(cmp>0) x = parent.right;
                else
                {
                    x.val = val;
                    return;
                }

            }
            if(cmp<0) parent.left = z;
            else parent.right = z;
        }
       
    }

    // private Node put(Node x, Key key, Value val) {
        
    // }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        if(root == null) return null;
        else return min(root).key;
       
    } 

    private Node min(Node x) { 
        while(x.left!=null)
        {
            x = x.left;
        }
        return x;       
    } 

   

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if(root == null) return null;
        Node x = root;
        Node t = x;
        while(x!=null)
        {
            int cmp = key.compareTo(x.key);
            if(cmp == 0)
            {
                return x.key;
            }
            else if(cmp<0)
            {
                x = x.left;

            }
            else
            {
                t = x;
                x = x.right;
            }
        }
        int newcmp = key.compareTo(t.key);
        if(newcmp<0) return null;
        else return t.key;
    } 

    // private Node floor(Node x, Key key) {
    //     return null;
       
    // } 

    
    

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Key select(int k) {
        if(k < 0|| k>= size())
            throw new IllegalArgumentException("invalid input");
        else
        {
            Node x = root;
            while(x!=null)
            {
                int t = size(x.left);
                if(t>k) x = x.left;
                else if(t<k)
                {
                    x = x.right;
                    k = k-t-1;
                }
                else return x.key;
            }

        }
        return null;
    }

    // Return key of rank k. 
    private Node select(Node x, int k) {
        return null;
         
    } 

    
    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table
     */
    public Iterable<Key> keys() {
        return null;
       
    }

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        if(lo == null) throw new IllegalArgumentException("First element empty");
        if(hi == null) throw new IllegalArgumentException("Last element empty");
        Queue<Key> queue = new Queue<Key>();
        keys(root,queue,lo,hi);
        return queue;
    } 

    private void keys(Node x,Queue<Key> queue, Key lo, Key hi) { 
        ArrayList<Node> list = new ArrayList<Node>();
        while(x != null || !list.isEmpty())
        {

            if(x!=null)
            {
                int cmplo = lo.compareTo(x.key);
                if(cmplo<=0)
                {
                    list.add(x);
                    x = x.left;

                }
                else
                {
                    x = x.right;
                }
                
            }
            else
            {
                int len = list.size();
                x = list.remove(len-1);
                int cmphi = hi.compareTo(x.key);
                if(cmphi>=0)
                {
                    queue.enqueue(x.key);
                    x = x.right;
                }
                else return;
            }   
        }
    } 

   
    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/
  
    public static void main(String[] args) { 
        Solution<String, Integer> st = new Solution<String, Integer>();
        while(!StdIn.isEmpty())
        {
            String str = StdIn.readLine();
            String[] arr = str.split(" ");
            if(arr[0].equals("PUT"))
            {
                st.put(arr[1],Integer.parseInt(arr[2]));
            }
            else if(arr[0].equals("GET"))
                System.out.println(st.get(arr[1]));
            else if(arr[0].equals("FLOOR"))
                System.out.println(st.floor(arr[1]));

            else if(arr[0].equals("SIZE"))
                System.out.println(st.size());
            else if(arr[0].equals("KEYS"))
            {
                System.out.println(st.keys(arr[1],arr[2]));
            }                
            else if(arr[0].equals("SELECT"))
                System.out.println(st.select(Integer.parseInt(arr[1])));
            else
                System.out.println(st.min());
        }
       
    }
}