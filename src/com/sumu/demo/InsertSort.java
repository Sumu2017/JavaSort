package com.sumu.demo;

public class InsertSort {
	/**
	 * 直接插入排序
	 * 
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
	/**
	 * 堆排序
	 */
	public static void heapSort() {
		int[] array = new int[] { 2, 12, 42, 32, 1, 3, 5, 64, 34, 67, -1 };
		buildMaxHeap(array);
		for (int i = array.length-1; i >=1; i--) {
			exchange(array, i, 0);
			maxHeap(array, i, 0);
		}
		
		System.out.print("\nheapSort:");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	/**
	 * 构建最大堆
	 * @param array
	 */
	private static void buildMaxHeap(int[] array) {
		if (array==null || array.length<=1) {
			return;
		}
		int half=(array.length-1)/2;
		//比较只需要从树中间开始，因为只要知道父结点的位置就可以得到左右子结点的位置
		//也就是说树的最底层不需要遍历，只需要从倒数第二层开始即可。
		for (int i = half; i>=0; i--) {
			maxHeap(array,array.length,i);
		}
	}
	
	/**
	 * 将父结点跟左右子结点的大小进行比较，将最大的跟父结点交换位置
	 * @param array  原数组
	 * @param length 需要建立大堆的数组长度
	 * @param index  从哪个位置开始
	 */
	private static void maxHeap(int[] array, int length, int index) {
		// TODO Auto-generated method stub
		//index为完全二叉树中的一个根节点，则左子结点下标为2*index+1,右子结点下标2*index+2,
		//因为数组下标是从0开始,所以完全二叉树的最顶根节点为0
		int left=2*index+1;
		int right=2*index+2;
		int	max=index;
		if (left<length&&array[left]>array[max]) {
			//如果left超出了数组的长度，则表示没有该子结点，
			max=left;
		}
		
		if (right<length&&array[right]>array[max]) {
			max=right;
		}
		if (max!=index) {
			//如果子结点比父结点大，则交换两个在数组中的位置
			exchange(array, index, max);
			//如果最大的位置跟起始位置不同，说明起始位置(父结点)不是最大的，需要交换，
			//那么就有可能会影响下子结点下面的树，所以需要继续寻找子结点树当中最大的。
			maxHeap(array, length, max);
		}
		
	}
	
	/**
	 * 交换两个在数组中的位置
	 * @param array      
	 * @param index1
	 * @param index2
	 */
	public static void exchange(int[] array,int index1,int index2) {
		int temp=array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
	}

	public static void main(String[] args) {
		InsertSort.directInsertSort();
		InsertSort.binaryInsertSort();
		//InsertSort.shellSort();
		InsertSort.heapSort();
	}
}
