package com.sumu.demo;

public class HeapSort {
	/**
	 * 堆排序
	 * 核心思想：利用大堆的特性，每个节点的值都不大于其父节点的值，所以最大值一定在堆顶
	 * 通过构建初始大堆，获取到一个最大值，然后跟数组最后一个交换，然后再调整堆，继续获取最大值，直到最后
	 */
	public static void heapSort() {
		int[] array = new int[] { 2, 12, 42, 32, 1, 3, 5, 64, 34, 67, -1 };
		buildMaxHeap(array);
		for (int i = array.length-1; i >=1; i--) {
			exchange(array, i, 0);
			maxHeap(array, i, 0);
		}
		
		System.out.print("heapSort:");
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
		HeapSort.heapSort();
	}
}
