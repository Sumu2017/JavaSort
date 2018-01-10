package com.sumu.demo;

public class QuickSort {
	/**
	 * 快速排序
	 * 核心思想:
	 * 1、每次都以数组的第一个作为基准元素，先从数组的最右边开始遍历（从右往左 right初始值为数组的最大下标 right--），
	 * 直到遇到比基准元素小，就交换位置，
	 * 2、再从基准元素位置开始遍(从左往右 left初始值为基准元素的下标,left++),
	 * 直到遇到比基准元素大，就交换位置，然后从右边上次的right位置开始遍历，以此类推，直到left=right。
	 * 这时left或者right的位置就是基准元素的最终位置，将基准元素插入到这个位置
	 * 3、然后以当前基准元素的位置将数组分割成左右两部分，再对着两部分重复1,2步骤。
	 * 
	 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
	 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
	 */
	public static void quickSort() {
		int[] array = new int[] { 2, 12, 42, 32, 1, 3, 5, 64, 34, 67, -1 };
		quickSort(array, 0, array.length-1);
		System.out.print("QuickSort:");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	/**
	 * 快速排序
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] array,int low,int high) {
		if (low<high) {
			int insertIndex = getInsertIndex(array,low,high);
			//对insertIndex左右两边进行快速排序
			quickSort(array,0,insertIndex-1);
			quickSort(array,insertIndex+1,high);
		}
	}
	
	/**
	 * 获取初始low位置的插入的下标
	 * @param array
	 * @param low
	 * @param high
	 */
	private static int getInsertIndex(int[] array, int low, int high) {
		// TODO Auto-generated method stub
		int temp=array[low];//基准元素，需要寻找位置的值,左边要都比temp小，右边要都比temp大
		while(low<high) {
			while (low<high&&temp<=array[high]) {
				//从最右往左遍历，寻找比temp小的值，然后赋值给temp位置
				high--;
			}
			//这时low的位置值就是temp，按理说应该再将temp赋值给high,但是后面temp值的位置还有可能发生变化，
			//所以将temp赋值留到最后，减少赋值频率，提高一定的效率
			array[low]=array[high];
			//array[high]=temp;
			
			while (low<high&&temp>=array[low]) {
				//从最左往右遍历，寻找比temp大的值,然后赋值给temp位置
				low++;
			}
			array[high]=array[low];
			//array[low]=temp;
		}
		//因为low++,high--，所以跳出while后，low==high;
		array[low]=temp;
		return low;
	}

	public static void main(String[] args) {
		QuickSort.quickSort();
	}
}
