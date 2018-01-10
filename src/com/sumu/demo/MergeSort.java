package com.sumu.demo;
/**
 * �ϲ�����(��������)
 * @author sumu
 *
 */
public class MergeSort {
	/**
	 * �鲢��������һ�ֻ��ڡ����Ρ����Ե�һ���㷨��
	 * �鲢�����㷨�ǵ��͵ķ����㷨�����ڹ�ģ�ϴ�����⣬���Էֽ�������������ļ򵥵����⣬���ѽ�ϲ����ɳ�ʼ����Ľ⡣
	 * ����˼��:
	 * 1��ͨ������ĳ��ȳ���2���õ��м�λ�ã��Ը�λ�ý��зָ��Ϊ�����������飬
	 * 2�����������������ظ�1���裬�Դ����ƣ�ֱ��������������ֻ��һ��ֵ��
	 * 3���ٽ��������鰴�մ�С����ϲ����µ��������档����ʵ������
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
	 * �ָ�����
	 * @param array   ԭ����
	 * @param left    ��ʼ�±�
	 * @param right   ĩβ�±�
	 */
	private static void mergeSort(int[] array,int left,int right) {
		if (left<right) {
			int middle=(left+right)/2;
			mergeSort(array, left, middle);//�ָ��������
			mergeSort(array, middle+1,right);//�ָ��ұ�����
			merge(array,left,middle,right);//�ϲ���������
		}
	}
	
	/**
	 * �ϲ��ָ����������
	 * @param array  ԭ����
	 * @param left	 ��ʼ�±�
	 * @param middle �м�ָ��±�
	 * @param right	 ĩβ�±�
	 */
	private static void merge(int[] array, int left,int middle, int right) {
		// TODO Auto-generated method stub
		int[] newArray=new int[array.length];
		int beginIndex=left;
		int rightStart=middle+1;
		int leftStart=left;
		//�Ƚ�����С������Ӧ�±�λ�õ���ֵ��С��С���ȷŽ�����
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
		//�����߻�û��ȫ�������꣬����������ʣ�µĿ�����������
		while (leftStart<=middle) {
			newArray[beginIndex]=array[leftStart];
			beginIndex++;
			leftStart++;
		}
		//����ұ߻�û��ȫ�������꣬����ұ�����ʣ�µĿ�����������
		while (rightStart<=right) {
			newArray[beginIndex]=array[rightStart];
			beginIndex++;
			rightStart++;
		}
		//���ϲ��õ������飬��ֵ��ԭ����
		for (int i = left; i <=right; i++) {
			array[i]=newArray[i];
		}
		
	}

	public static void main(String[] args) {
		MergeSort.mergeSort();
	}
}
