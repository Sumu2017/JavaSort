package com.sumu.demo;

public class QuickSort {
	/**
	 * ��������
	 * ����˼��:
	 * 1��ÿ�ζ�������ĵ�һ����Ϊ��׼Ԫ�أ��ȴ���������ұ߿�ʼ�������������� right��ʼֵΪ���������±� right--����
	 * ֱ�������Ȼ�׼Ԫ��С���ͽ���λ�ã�
	 * 2���ٴӻ�׼Ԫ��λ�ÿ�ʼ��(�������� left��ʼֵΪ��׼Ԫ�ص��±�,left++),
	 * ֱ�������Ȼ�׼Ԫ�ش󣬾ͽ���λ�ã�Ȼ����ұ��ϴε�rightλ�ÿ�ʼ�������Դ����ƣ�ֱ��left=right��
	 * ��ʱleft����right��λ�þ��ǻ�׼Ԫ�ص�����λ�ã�����׼Ԫ�ز��뵽���λ��
	 * 3��Ȼ���Ե�ǰ��׼Ԫ�ص�λ�ý�����ָ�����������֣��ٶ����������ظ�1,2���衣
	 * 
	 * ͨ��һ������Ҫ��������ݷָ�ɶ����������֣�����һ���ֵ��������ݶ�������һ���ֵ��������ݶ�ҪС��
	 * Ȼ���ٰ��˷����������������ݷֱ���п�����������������̿��Եݹ���У��Դ˴ﵽ�������ݱ���������С�
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
	 * ��������
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] array,int low,int high) {
		if (low<high) {
			int insertIndex = getInsertIndex(array,low,high);
			//��insertIndex�������߽��п�������
			quickSort(array,0,insertIndex-1);
			quickSort(array,insertIndex+1,high);
		}
	}
	
	/**
	 * ��ȡ��ʼlowλ�õĲ�����±�
	 * @param array
	 * @param low
	 * @param high
	 */
	private static int getInsertIndex(int[] array, int low, int high) {
		// TODO Auto-generated method stub
		int temp=array[low];//��׼Ԫ�أ���ҪѰ��λ�õ�ֵ,���Ҫ����tempС���ұ�Ҫ����temp��
		while(low<high) {
			while (low<high&&temp<=array[high]) {
				//���������������Ѱ�ұ�tempС��ֵ��Ȼ��ֵ��tempλ��
				high--;
			}
			//��ʱlow��λ��ֵ����temp������˵Ӧ���ٽ�temp��ֵ��high,���Ǻ���tempֵ��λ�û��п��ܷ����仯��
			//���Խ�temp��ֵ������󣬼��ٸ�ֵƵ�ʣ����һ����Ч��
			array[low]=array[high];
			//array[high]=temp;
			
			while (low<high&&temp>=array[low]) {
				//���������ұ�����Ѱ�ұ�temp���ֵ,Ȼ��ֵ��tempλ��
				low++;
			}
			array[high]=array[low];
			//array[low]=temp;
		}
		//��Ϊlow++,high--����������while��low==high;
		array[low]=temp;
		return low;
	}

	public static void main(String[] args) {
		QuickSort.quickSort();
	}
}
