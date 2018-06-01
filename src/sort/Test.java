package sort;

import java.util.Random;

public class Test {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("origin:");
		Comparable[] array=generateRandomArray(100,30);
		Example.show(array);
		
		//Selection
		System.out.println("Selection:");
		Comparable[] clone1=array.clone();
		Selection.sort(clone1);
		Example.show(clone1);
		System.out.println("isSorted:"+Example.isSorted(clone1));
		
		//Insertion
		System.out.println("Insertion:");
		Comparable[] clone2=array.clone();
		Selection.sort(clone2);
		Example.show(clone2);
		System.out.println("isSorted:"+Example.isSorted(clone2));
		
		//Shell
		System.out.println("Shell:");
		Comparable[] clone3=array.clone();
		Selection.sort(clone3);
		Example.show(clone3);
		System.out.println("isSorted:"+Example.isSorted(clone3));
	}
	
	private static Comparable[] generateRandomArray(int bound,int N) {
		Random random=new Random();
		Integer[] res=new Integer[N];
		for(int i=0;i<N;i++) {
			res[i]=random.nextInt(bound);
		}
		return res;
	}
}
