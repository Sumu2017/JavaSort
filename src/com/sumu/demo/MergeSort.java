package com.sumu.demo;
/**
 * 合并排序(并归排序)
 * @author sumu
 *
 */
public class MergeSort {
	/**
	 * 归并排序，它是一种基于“分治”策略的一种算法。
	 * 归并排序算法是典型的分治算法，对于规模较大的问题，可以分解成若干容易求解的简单的问题，最后把解合并构成初始问题的解。
	 * 核心思想:
	 * 1、通过数组的长度除以2，得到中间位置，以该位置进行分割，分为左右两个数组，
	 * 2、左右两个数组再重复1步骤，以此类推，直到所有数组里面只有一个值，
	 * 3、再将左右数组按照从小到大合并到新的数组里面。最终实现排序
	 */
	public static void mergeSort() {
		int[] array = new int[] { 2, 12, 42, 32, 1, 3, 5, 64, 34, 67, -1 };
		mergeSort(array, 0, array.length-1);
		System.out.print("mergeSort:");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	/**
	 * 分割数组
	 * @param array   原数组
	 * @param left    起始下标
	 * @param right   末尾下标
	 */
	private static void mergeSort(int[] array,int left,int right) {
		if (left<right) {
			int middle=(left+right)/2;
			mergeSort(array, left, middle);//分割左边数组
			mergeSort(array, middle+1,right);//分割右边数组
			merge(array,left,middle,right);//合并左右数组
		}
	}
	
	/**
	 * 合并分割的两个数组
	 * @param array  原数组
	 * @param left	 起始下标
	 * @param middle 中间分割下标
	 * @param right	 末尾下标
	 */
	private static void merge(int[] array, int left,int middle, int right) {
		// TODO Auto-generated method stub
		int[] newArray=new int[array.length];
		int beginIndex=left;
		int rightStart=middle+1;
		int leftStart=left;
		//比较两个小数组相应下标位置的数值大小，小的先放进数组
		while(leftStart<=middle&&rightStart<=right) {
			if (array[leftStart]<array[rightStart]) {
				newArray[beginIndex]=array[leftStart];
				beginIndex++;
				leftStart++;
			}else {
				newArray[beginIndex]=array[rightStart];
				beginIndex++;
				rightStart++;
			}
		}
		//如果左边还没有全部拷贝完，则把左边数组剩下的拷贝到新数组
		while (leftStart<=middle) {
			newArray[beginIndex]=array[leftStart];
			beginIndex++;
			leftStart++;
		}
		//如果右边还没有全部拷贝完，则把右边数组剩下的拷贝到新数组
		while (rightStart<=right) {
			newArray[beginIndex]=array[rightStart];
			beginIndex++;
			rightStart++;
		}
		//将合并好的新数组，赋值给原数组
		for (int i = left; i <=right; i++) {
			array[i]=newArray[i];
		}
		
	}

	public static void main(String[] args) {
		MergeSort.mergeSort();
	}
}
