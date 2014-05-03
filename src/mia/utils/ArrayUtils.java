package mia.utils;

import java.util.Random;

public class ArrayUtils {

	private static Random random;
	static
	{
		random = new Random(13);
	}
	
	public static int[] randomArray(int length)
	{
		int[] a = new int[length];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(length + 1);
		}
		
		return a;
	}
	
	public static void printArray(int[] a)
	{
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%4d ", a[i]);
		}
		System.out.printf("Size = %d\n", a.length);
	}
}
