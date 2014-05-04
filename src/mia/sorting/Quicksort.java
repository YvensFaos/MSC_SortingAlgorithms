package mia.sorting;

import mia.utils.ArrayUtils;

public class Quicksort {
	
	public int partition(int[] a, int p, int r)
	{
//		System.out.println("<=====>");
		int x   = a[r];
		int i = p - 1;
		int aux = 0;
//		System.out.printf("Pivô %2d[%2d a %2d]|\n",x,p,r);
//		for (int j = p; j <= r; j++) {
//			System.out.printf("%2d ",a[j]);
//		}
//		System.out.println("\n=====");
		for (int j = p; j < r;) {
			
			if(a[j] <= x)
			{
//				System.out.printf("Adiciona na menor: %d\n",a[j]);
				i++;
				aux = a[i];
				a[i] = a[j];
				a[j] = aux;
			}
//			else
//			{
//				System.out.printf("Adiciona na maior: %d\n",a[j]);
//			}
			j++;
//			System.out.printf("Smaller: ");
//			printPartition(a, p, i);
//			System.out.printf("Bigger: ");
//			printPartition(a, i + 1, j);
		}
//		System.out.println("=====");
		
		aux = a[i + 1];
		a[i + 1] = a[r];
		a[r] = aux;
//		printPivot(a, p, r, i + 1);
//		System.out.println();
//		System.out.println("<=====>");
		return i + 1;
	}
	
	/*
	private void printPartition(int[] a, int ini, int fin)
	{
		if(ini == -1)
			return;
		System.out.printf("(%d a %d){",ini,fin);
		if(ini == fin)
		{
			System.out.printf("%2d ",a[ini]);
		}
		else
		{
			for (int i = ini; i < fin; i++) {
				System.out.printf("%2d ",a[i]);
			}
		}
		System.out.printf("}\n");
	}
	
	private void printPivot(int[] a, int p, int r, int x)
	{
		for (int i = p; i <= r; i++) {
			if(i != x)
			{
				System.out.printf("%2d ",a[i]);
			}
			else
			{
				System.out.printf("{%2d} ",a[i]);
			}
		}
	}
	*/
	public void quicksort(int[] a, int p, int r)
	{
		if(p < r)
		{
			int q = partition(a, p, r);
			quicksort(a, p, q - 1);
			quicksort(a, q + 1, r);
		}
	}

	public static void main(String[] args) {
		Quicksort sorter = new Quicksort();
		
		int[] array = new int[] {8,1,6,4,0,3,9,5};
		ArrayUtils.printArray(array);
		sorter.quicksort(array, 0, array.length - 1);
		ArrayUtils.printArray(array);
		
		array = ArrayUtils.randomArray(20);
		ArrayUtils.printArray(array);
		sorter.quicksort(array, 0, array.length - 1);
		ArrayUtils.printArray(array);
		
		array = ArrayUtils.randomArray(40);
		ArrayUtils.printArray(array);
		sorter.quicksort(array, 0, array.length - 1);
		ArrayUtils.printArray(array);
	}
}
