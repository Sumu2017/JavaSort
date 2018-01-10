package com.sumu.demo;

public class InsertSort {
	/**
	 * 直接插入排序
	 * 核心思想:从第二个数开始，不断与前面的数进行对比（从后往前），
	 * 遇到大的就将大的往后移一位，直到遇到小的，那么小的后面一个位置就是该值的位置
	 */
	public static void directInsertSort() {
		int[] array = new int[] { 2, 12, 42, 32, 1, 3, 5, 64, 34, 67, -1 };
		for (int i = 1; i < array.length; i++) {
			int value = array[i];
			int j = 0;
			for (j = i - 1; j >= 0; j--) {
				// 从最大的往小的比，从后往前
				if (value < array[j]) {
					// 跟前面已排序的进行对比，如果小于则将该值往后移一位，
					array[j + 1] = array[j];
				} else {
					break;
				}
			}
			array[j + 1] = value;
		}
		System.out.print("DirectInsertSort:");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	/**
	 * 二分法插入排序
	 * 核心思想:思想跟直接插入排序基本一致，只是寻找插入的位置的方式不同，
	 * 直接插入排序是跟前面已排序数组从大到小一个一个的进行对比，直到找到比value小的
	 * 而二分法插入排序，是折中查找位置，先跟已排序数组最中间的值进行对比，如果比value大，
	 * 则说明位置在中间值的左边，否则在中间值的右边，以此循环，直到找到正确index，然后将index后面的值都向后移一位，
	 * 让出位置，然后插入
	 */
	public static void binaryInsertSort() {
		int[] array = new int[] { 2, 12, 42, 32, 1, 3, 5, 64, 34, 67, -1 };
		for (int i = 0; i < array.length; i++) {
			int value = array[i];// 待插入的值
			int left = 0;// 已排序最左边的下标
			int right = i - 1;// 已排序最右边的下标
			int mid = 0;
			while (left <= right) {
				// 二分法查找，先获取中间的值，然后跟当前值对比，
				// 不断缩小left-right的区域，直到找到合适的位置
				mid = (left + right) / 2;
				if (array[mid] > value) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			for (int j = i - 1; j >= left; j--) {
				// 将left右边的值全部向后移，让出位置等value的插入
				array[j + 1] = array[j];
			}
			if (left != i) {
				// 如果所需要插入的位置与待插入值的位置相同，则不需要再进行交换
				array[left] = value;
			}
		}
		System.out.print("BinaryInsertSort:");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	/**
	 * 希尔排序(不稳定排序) 相对于直接插入排序，元素之间的交换次数减少
	 * 核心思想：选择一个增量(一般选取数组长度的一半)，然后根据增量，将数组分成好几组，再将每组分别进行直接插入排序，
	 * 然后增量递减重复分组，排序，直到增量为0结束
	 */
	public static void shellSort() {
		int[] array = new int[] { 2, 12, 42, 32, 1, 3, 5, 64, 34, 67, -1 };
		int d = array.length;//增量
		while (true) {
			d = d / 2;
			System.out.println("增量="+d);
			for (int i = 0; i < d; i++) {
				//根据增量，分为d组,然后再对每组进行直接插入排序
				//列如d为5的时候，5组为{5,10},{6},{7},{8},{9}，里面数字为下标
				System.out.print("第"+i+"组  ==");
				
				//对每组数组进行直接插入排序
				for (int j = i+d; j < array.length; j=j+d) {
					System.out.print(j+" ");
					int temp=array[j];
					int k=0;
					for (k = j-d;k>=i&&temp<array[k]; k=k-d) {
						array[k+d]=array[k];
					}
					array[k+d]=temp;
				}
				System.out.println("");
			}
			if (d == 1) {
				break;
			}
		}

		System.out.print("\nshellSort:");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	

	public static void main(String[] args) {
		InsertSort.directInsertSort();
		InsertSort.binaryInsertSort();
		InsertSort.shellSort();
	}
}
