package search;


/**
 * 基于有序数组的二分查找
 * @author usiel
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
	
	private Key[] keys;
	private Value[] vals;
	private int N;
	public BinarySearchST(int capacity) {
		keys=(Key[])new Comparable[capacity];
		vals=(Value[])new Object[capacity];
	}
	
	public int size() {
		return N;
	}
	
	public Value get(Key key) {
		if(isEmpty())return null;
		int i=rank(key);
		if(i<N&&keys[i].compareTo(key)==0)return vals[i];
		else return null;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public boolean contains(Key key) {
		return get(key)!=null;
	}
	
	public int rank(Key key) {
		int lo=0,hi=N-1;
		while(lo<=hi) {
			int mid=lo+(hi-lo)/2;
			int cmp=key.compareTo(keys[mid]);
			if(cmp<0)hi=mid-1;
			else if(cmp>0)lo=mid+1;
			else return mid;
		}
		return lo;
	}
	
	public void put(Key key,Value val) {
		int i=rank(key);
		if(i<N&&keys[i].compareTo(key)==0) {
			vals[i]=val;
			return;
		}
		for(int j=N;j>i;j--) {
			keys[j]=keys[j-1];
			vals[j]=vals[j-1];
		}
		keys[i]=key;
		vals[i]=val;
		N++;
		
	}
	
	public void delete(Key key) {
		if (isEmpty()) return;

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < N-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        N--;
        keys[N] = null;  // to avoid loitering
        vals[N] = null;

        // resize if 1/4 full
        if (N > 0 && N == keys.length/4) resize(keys.length/2);
	}
	
	// resize the underlying arrays
    private void resize(int capacity) {
        assert capacity >= N;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }
	
	public Key min() {
		return keys[0];
	}
	
	public Key max() {
		return keys[N-1];
	}
	
	public Key select(int k) {
		return keys[k];
	}
	
	public Key ceiling(Key key) {
		int i=rank(key);
		return keys[i];
	}
	
	public Key floor(Key key) {
		int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i-1];
	}
	
	

}
