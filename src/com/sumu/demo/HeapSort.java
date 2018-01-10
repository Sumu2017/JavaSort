package com.sumu.demo;

public class HeapSort {
	/**
	 * ������
	 * ����˼�룺���ô�ѵ����ԣ�ÿ���ڵ��ֵ���������丸�ڵ��ֵ���������ֵһ���ڶѶ�
	 * ͨ��������ʼ��ѣ���ȡ��һ�����ֵ��Ȼ����������һ��������Ȼ���ٵ����ѣ�������ȡ���ֵ��ֱ�����
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
	 * ��������
	 * @param array
	 */
	private static void buildMaxHeap(int[] array) {
		if (array==null || array.length<=1) {
			return;
		}
		int half=(array.length-1)/2;
		//�Ƚ�ֻ��Ҫ�����м俪ʼ����ΪֻҪ֪��������λ�þͿ��Եõ������ӽ���λ��
		//Ҳ����˵������ײ㲻��Ҫ������ֻ��Ҫ�ӵ����ڶ��㿪ʼ���ɡ�
		for (int i = half; i>=0; i--) {
			maxHeap(array,array.length,i);
		}
	}
	
	/**
	 * �������������ӽ��Ĵ�С���бȽϣ������ĸ�����㽻��λ��
	 * @param array  ԭ����
	 * @param length ��Ҫ������ѵ����鳤��
	 * @param index  ���ĸ�λ�ÿ�ʼ
	 */
	private static void maxHeap(int[] array, int length, int index) {
		// TODO Auto-generated method stub
		//indexΪ��ȫ�������е�һ�����ڵ㣬�����ӽ���±�Ϊ2*index+1,���ӽ���±�2*index+2,
		//��Ϊ�����±��Ǵ�0��ʼ,������ȫ������������ڵ�Ϊ0
		int left=2*index+1;
		int right=2*index+2;
		int	max=index;
		if (left<length&&array[left]>array[max]) {
			//���left����������ĳ��ȣ����ʾû�и��ӽ�㣬
			max=left;
		}
		
		if (right<length&&array[right]>array[max]) {
			max=right;
		}
		if (max!=index) {
			//����ӽ��ȸ������򽻻������������е�λ��
			exchange(array, index, max);
			//�������λ�ø���ʼλ�ò�ͬ��˵����ʼλ��(�����)�������ģ���Ҫ������
			//��ô���п��ܻ�Ӱ�����ӽ�����������������Ҫ����Ѱ���ӽ�����������ġ�
			maxHeap(array, length, max);
		}
		
	}
	
	/**
	 * ���������������е�λ��
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
