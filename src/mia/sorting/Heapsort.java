package mia.sorting;

import mia.utils.ArrayUtils;

public class Heapsort {
  
	protected int heapSize = 0;
	
	public int left(int index)
	{
		return 2*index;
	}
	public int right(int index)
	{
		return 2*index + 1;
	}
	
	public void maxHeapify(int[] a, int index)
	{
		int left = left(index);
		int right = right(index);
		int maior = index;
		
		if(left < heapSize && a[left] > a[index])
		{
			maior = left;
		}
		if(right < heapSize && a[right] > a[maior])
		{
			maior = right;
		}
		if(maior != index)
		{
			int aux = a[index];
			a[index] = a[maior];
			a[maior] = aux;
			
			maxHeapify(a, maior);
		}
	}
	
	public void buildMaxHeap(int[] a)
	{
		int size = a.length;
		for(int i = size/2 + 1; i > -1; i--)
		{
			maxHeapify(a, i);
		}
	}
	
	public void headSort(int[] a)
	{
		buildMaxHeap(a);
		int size = a.length;
		
		for (int i = (size  - 1); i > 0; i--) {
			int aux = a[0];
			a[0] = a[i]; 
			a[i] = aux;
			
			heapSize--;
			buildMaxHeap(a);
		}
	}
	
	public static void main(String[] args) {
		
		int[] array = ArrayUtils.randomArray(20);
		ArrayUtils.printArray(array);
		
		Heapsort sorter = new Heapsort();
		sorter.heapSize = array.length;
		sorter.headSort(array);
		ArrayUtils.printArray(array);
		
		array = ArrayUtils.randomArray(40);
		ArrayUtils.printArray(array);
		
		sorter.heapSize = array.length;
		sorter.headSort(array);
		ArrayUtils.printArray(array);
	}
}
