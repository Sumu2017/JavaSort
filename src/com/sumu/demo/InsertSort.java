package com.sumu.demo;

public class InsertSort {
	/**
	 * ֱ�Ӳ�������
	 * 
	 */
	public static void directInsertSort() {
		int[] array = new int[] { 2, 12, 42, 32, 1, 3, 5, 64, 34, 67, -1 };
		for (int i = 1; i < array.length; i++) {
			int value = array[i];
			int j = 0;
			for (j = i - 1; j >= 0; j--) {
				// ��������С�ıȣ��Ӻ���ǰ
				if (value < array[j]) {
					// ��ǰ��������Ľ��жԱȣ����С���򽫸�ֵ������һλ��
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
	 * ���ַ���������
	 */
	public static void binaryInsertSort() {
		int[] array = new int[] { 2, 12, 42, 32, 1, 3, 5, 64, 34, 67, -1 };
		for (int i = 0; i < array.length; i++) {
			int value = array[i];// �������ֵ
			int left = 0;// ����������ߵ��±�
			int right = i - 1;// ���������ұߵ��±�
			int mid = 0;
			while (left <= right) {
				// ���ַ����ң��Ȼ�ȡ�м��ֵ��Ȼ�����ǰֵ�Աȣ�
				// ������Сleft-right������ֱ���ҵ����ʵ�λ��
				mid = (left + right) / 2;
				if (array[mid] > value) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			for (int j = i - 1; j >= left; j--) {
				// ��left�ұߵ�ֵȫ������ƣ��ó�λ�õ�value�Ĳ���
				array[j + 1] = array[j];
			}
			if (left != i) {
				// �������Ҫ�����λ���������ֵ��λ����ͬ������Ҫ�ٽ��н���
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
	 * ϣ������(���ȶ�����) �����ֱ�Ӳ�������Ԫ��֮��Ľ�����������
	 */
	public static void shellSort() {
		int[] array = new int[] { 2, 12, 42, 32, 1, 3, 5, 64, 34, 67, -1 };
		int d = array.length;//����
		while (true) {
			d = d / 2;
			System.out.println("����="+d);
			for (int i = 0; i < d; i++) {
				//������������Ϊd��,Ȼ���ٶ�ÿ�����ֱ�Ӳ�������
				//����dΪ5��ʱ��5��Ϊ{5,10},{6},{7},{8},{9}����������Ϊ�±�
				System.out.print("��"+i+"��  ==");
				
				//��ÿ���������ֱ�Ӳ�������
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
	 * ������
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
		InsertSort.directInsertSort();
		InsertSort.binaryInsertSort();
		//InsertSort.shellSort();
		InsertSort.heapSort();
	}
}
