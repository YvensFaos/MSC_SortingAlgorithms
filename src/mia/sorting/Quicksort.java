package mia.sorting;

import mia.utils.ArrayUtils;

public class Quicksort {
	
	public int partition(int[] a, int p, int r)
	{
		int x = a[r];
		System.out.printf("Pivot: %d\n", x);
		int i = p - 1;
		for(int j = p; j != (r - 1); j++)
		{
			if(a[j] <= x)
			{
				i++;
				int aux = a[i];
				a[j] = a[i];
				a[j] = aux;
			}
			ArrayUtils.printArray(a);
		}
		
		int aux = a[i+1];
		a[i+1] = a[r];
		a[r] = aux;
		
		return i + 1;
	}
	
	public void quicksort(int[] a, int p, int r)
	{
		if(p < r)
		{
			int q = partition(a, p, r);
			quicksort(a, p, q -1);
			quicksort(a, q + 1, r);
		}
	}

	public static void main(String[] args) {
		int[] array = ArrayUtils.randomArray(20);
		ArrayUtils.printArray(array);
		
		Quicksort sorter = new Quicksort();
		int q = sorter.partition(array, 0, array.length - 1);
		System.out.println(q);
		ArrayUtils.printArray(array);
//		sorter.quicksort(array, 0, array.length - 1);
//		
//		array = ArrayUtils.randomArray(40);
//		ArrayUtils.printArray(array);
//		
//		sorter = new Quicksort();
//		sorter.quicksort(array, 0, array.length - 1);
//		ArrayUtils.printArray(array);
	}
}
